package com.example.uniqueemail;

import com.example.uniqueemail.request.UniqueEmailRequest;
import com.example.uniqueemail.response.UniqueEmailResponse;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UniqueemailApplicationTests {

	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();

	@Test
	public void testUniqueEmailAddresses() throws Exception {

		UniqueEmailRequest request = new UniqueEmailRequest();
		request.setEmails(Arrays.asList("test@gmail.com", "test1@gmail.com"));

		HttpEntity<UniqueEmailRequest> entity = new HttpEntity<UniqueEmailRequest>(request, null);
		ResponseEntity<UniqueEmailResponse> response = restTemplate.exchange(
				"http://localhost:" + port + "/", HttpMethod.POST, entity, UniqueEmailResponse.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(2, response.getBody().getNumberOfUniqueEmails());
	}

}
