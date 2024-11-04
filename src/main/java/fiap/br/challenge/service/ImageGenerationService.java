package fiap.br.challenge.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ImageGenerationService {

    private final RestTemplate restTemplate;

    @Value("${spring.ai.azure.openai.api-key}")
    private String apiKey;

    @Value("${spring.ai.azure.openai.endpoint}")
    private String endpoint;

    public ImageGenerationService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String generateImage(String promptText) {

    	HttpHeaders headers = new HttpHeaders();
        headers.set("api-key",apiKey);
        headers.set("Content-Type", "application/json");

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("prompt", promptText);
        requestBody.put("n", 1);
        requestBody.put("size", "1024x1024");
        requestBody.put("response_format", "url");

        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(requestBody, headers);

        String url = UriComponentsBuilder.fromHttpUrl(endpoint)
                .queryParam("api-version", "2024-02-01")
                .toUriString();

        try {
        	System.out.println(url);
            ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, Map.class);
            Map<String, Object> responseBody = response.getBody();

            if (responseBody != null && responseBody.containsKey("data")) {
                List<Map<String, String>> data = (List<Map<String, String>>) responseBody.get("data");
                if (!data.isEmpty() && data.get(0).containsKey("url")) {
                    return data.get(0).get("url");  // Retorna a URL da imagem gerada
                }
            }
            return null;
        } catch (Exception e) {
            System.err.println("Erro ao gerar imagem: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
