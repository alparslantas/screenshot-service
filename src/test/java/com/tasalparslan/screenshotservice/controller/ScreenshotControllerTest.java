package com.tasalparslan.screenshotservice.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ScreenshotControllerTest {

	MockMvc mockMvc;

	@Mock
	private ScreenshotController screenshotController;

	@Autowired
	private TestRestTemplate template;

	@Before
	public void setup() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(screenshotController).build();
	}

	@Test
	public void testScreenshot() throws Exception {
		ResponseEntity<String> response = template.getForEntity("/screenshot", String.class);
		Assert.assertEquals(200, response.getStatusCode().value());
	}
}
