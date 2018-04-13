package com.rupertoss.toripchecker;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Test
	public void testGetTorIpCheck_whenRequestedIpIsNotTorIp_shouldRespondStatus404() throws Exception {
		String request = "A.B.C.D";
		
		String uri = "/{A.B.C.D}";
		
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri, request)).andReturn();
		
		int status = result.getResponse().getStatus();
		int content = result.getResponse().getContentLength();
		
		assertEquals(404, status);
		assertEquals(0, content);
	}
}
