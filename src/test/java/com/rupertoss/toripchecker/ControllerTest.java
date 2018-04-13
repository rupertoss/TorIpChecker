package com.rupertoss.toripchecker;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(Controller.class)
@AutoConfigureWebMvc
public class ControllerTest extends AbstractionTest {

	@Rule
	public MockitoRule rule = MockitoJUnit.rule();
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	TorIpAddr torIpAddr;
	
	@InjectMocks
	Controller controller;
	
	@Test
	public void testGetStatus() throws Exception {
		String uri = "/status";
		
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		
		int status = result.getResponse().getStatus();
		String content = result.getResponse().getContentAsString();
		
		assertEquals(200, status);
		assertTrue(content.trim().length() > 0);
	}

	@Test
	public void testGetTorIpCheck_whenRequestedIpIsTorIp_shouldRespondStatus200() throws Exception {
		String request = "A.B.C.D";
		String uri = "/{A.B.C.D}";
		
		
		when(torIpAddr.isTorIp(request)).thenReturn(true);
		
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri, request)).andReturn();
		
		int status = result.getResponse().getStatus();
		String content = result.getResponse().getContentAsString();
		
		assertEquals(200, status);
		assertTrue(content.trim().length() > 0);
	}
	
	@Test
	public void testGetTorIpCheck_whenRequestedIpIsNotTorIp_shouldRespondStatus404() throws Exception {
		String request = "A.B.C.D";
		
		String uri = "/{A.B.C.D}";
		
		when(torIpAddr.isTorIp(request)).thenReturn(false);
		
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri, request)).andReturn();
		
		int status = result.getResponse().getStatus();
		int content = result.getResponse().getContentLength();
		
		assertEquals(404, status);
		assertEquals(0, content);
	}
	
	@Test
	public void testGetTorIpCheck_whenExceptionIsThrown_shouldRespondStatus500() throws Exception {
		String request = "A.B.C.D";
		
		String uri = "/{A.B.C.D}";
		
		when(torIpAddr.isTorIp(request)).thenThrow(RuntimeException.class);
		
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri, request)).andReturn();
		
		int status = result.getResponse().getStatus();
		String content = result.getResponse().getContentAsString();
		
		assertEquals(500, status);
		assertTrue(content.trim().length() > 0);
	}
}
