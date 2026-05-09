package sv.edu.udb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.boot.test.web.client.TestRestTemplate;
import sv.edu.udb.dto.AuthRequest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class SpringJwtBasicApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testLogin() {
		AuthRequest authRequest = new AuthRequest("testuser", "testpassword");

		ResponseEntity<String> response = restTemplate.exchange("/auth/login", HttpMethod.POST,
				new HttpEntity<>(authRequest), String.class);

		assertEquals(200, response.getStatusCodeValue());

		assertNotNull(response.getBody());
		assertTrue(response.getBody().contains("Bearer "));
	}
	@Test
	public void testSecureEndpoint() {
		// Suponiendo que ya tienes un token JWT generado de una solicitud de login exitosa
		String token = "Bearer <tu_token_aqui>";

		// Usamos el token para acceder a un endpoint seguro
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", token);
		ResponseEntity<String> response = restTemplate.exchange("/secure-endpoint", HttpMethod.GET,
				new HttpEntity<>(headers), String.class);

		// Verificamos que el código de estado sea 200 OK para el endpoint seguro
		assertEquals(200, response.getStatusCodeValue());
	}
}

