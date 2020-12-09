package com.biz.data.config;

import java.io.IOException;

import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
/**
 * RestTemplate을 사용하여 OpenAPI데이터를 가져올 때
 * OpenAPI 데이터를 제공하는 곳에서 apllication/json, apllication/xml 형식으로 데이터를 보내야하는데
 * HttpHeader에 APLLICATION_JSON, APLLICATION_XML 형식을 지정했음에도
 * TEXT/HTML, TEXT/JSON, TEXT/XML 형식으로 데이터를 제공하는 경우에는
 * VO클래스에 데이터를 mapping하지 못해서 오류가 발생한다.
 * 
 * RestTemplate에 interceptor를 설정하여
 * 강제로 데이터를 변환시키도록 하기 위한 클래스 선언
 * ClientHttpRequestInterceptor 상속받아서 method를 구현해주어야 한다.
 *
 */
public class RestTempInterceptor implements  ClientHttpRequestInterceptor {

	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {
		
		ClientHttpResponse response = execution.execute(request, body);
		
		response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
		
		return response;
		
	}


}
