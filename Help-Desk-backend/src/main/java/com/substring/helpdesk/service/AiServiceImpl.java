package com.substring.helpdesk.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.substring.helpdesk.tools.EmailTool;
import com.substring.helpdesk.tools.TicketDatabaseTool;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;


@Service
@Data
@RequiredArgsConstructor
public class AiServiceImpl implements AiService {
	
	@Autowired
	private ChatClient chatClient;
	@Autowired
	private EmailTool et;
	
	@Value("classpath:/helpdesk-system.st")
	private Resource systemPromptResout;
	
	@Autowired
	private TicketDatabaseTool tdt;
	
	public String getResponseFromAssistant(String query,String conversationId) {
		//basic llm call
		return chatClient
				.prompt()
				.advisors(advisorSpec->advisorSpec.param(ChatMemory.CONVERSATION_ID,conversationId))
				.tools(tdt,et)
				.system(systemPromptResout)
				.user(query)
				.call()
				.content();
	}
	public Flux<String> streamResponseFromAssisstant(String query,String conversationId)
	{
		return chatClient
				.prompt()
				.advisors(advisorSpec->advisorSpec.param(ChatMemory.CONVERSATION_ID,conversationId))
				.tools(tdt,et)
				.system(systemPromptResout)
				.user(query)
				.stream()
				.content();
	}
}
