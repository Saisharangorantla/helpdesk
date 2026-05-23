package com.substring.helpdesk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.substring.helpdesk.service.AiService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;


@RestController
@RequestMapping("/api/v1/helpdesk") 
@RequiredArgsConstructor
@CrossOrigin("http://localhost:5173") 
public class AiController {
	
	@Autowired
	private AiService aiService;
	
	@PostMapping   
	public ResponseEntity<String>  getResponse(@RequestBody String query, @RequestHeader("ConversationId") String conversationId)
	{
		return ResponseEntity.ok(aiService.getResponseFromAssistant(query,conversationId));
	}
	
	@PostMapping("/stream")
	public Flux<String>  streamResponse(@RequestBody String query, @RequestHeader("ConversationId") String conversationId)
	{
		return aiService.streamResponseFromAssisstant(query, conversationId);
	}
	
}
