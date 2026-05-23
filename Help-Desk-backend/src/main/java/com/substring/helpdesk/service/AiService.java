package com.substring.helpdesk.service;

import reactor.core.publisher.Flux;

public interface AiService {
	String getResponseFromAssistant(String query,String conversationId);
	Flux<String> streamResponseFromAssisstant(String query,String conversationId);
}
