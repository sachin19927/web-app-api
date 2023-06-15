package com.service.developersjourneysource.webclient;

import static io.netty.handler.codec.http.HttpHeaders.Values.APPLICATION_JSON;
import static org.springframework.http.HttpHeaders.ACCEPT;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Configuration
@RequiredArgsConstructor
@ConfigurationProperties(prefix = "idp")
public class WebClientConfig {

	private static final String X_SUNGARD_IDP_API_KEY = "X-SunGard-Idp-API-Key";
	
	private String url;
	private String apiKey;
	private String token;
	
	@Bean
	IdpHttpClient spaClient(WebClient.Builder webClientBuilder) {
	
		var webClient = webClientBuilder
				.baseUrl(url)
				.defaultHeaders(httpHeeaders->httpHeeaders.addAll(createHeaders()))
				.build();
		
		var httpServiceProxyFactory = HttpServiceProxyFactory
				.builder(WebClientAdapter.forClient(webClient)).build();
		
		return httpServiceProxyFactory.createClient(IdpHttpClient.class);
	}
	
	private HttpHeaders createHeaders() {
		var httpHeaders = new HttpHeaders();
		httpHeaders.add(ACCEPT,APPLICATION_JSON);
		httpHeaders.add(CONTENT_TYPE,APPLICATION_JSON);
		httpHeaders.add(AUTHORIZATION,"Bearer "+token);
		httpHeaders.add(X_SUNGARD_IDP_API_KEY,apiKey);
		return httpHeaders;
	}
	
}
