package com.substring.helpdesk.tools;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.substring.helpdesk.entity.Ticket;
import com.substring.helpdesk.service.TicketService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TicketDatabaseTool {
	
	@Autowired
	private TicketService tservice;
	
	@Tool(description="this tool helps to create new ticket in database")
	public Ticket createTicketTool(@ToolParam(description="Ticket fields required to create new ticket")Ticket ticket)
	{
		try {
			System.out.print("going to create ticket");
			System.out.println(ticket);
			return tservice.CreateTicket(ticket);
		}catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	@Tool(description="this tool helps to get  ticket from database by username")
	public Ticket getTicketByEmail(@ToolParam(description="email id	 whoes ticket is required ") String email)
	{
		return tservice.getTicketByEmail(email);	
	}
	@Tool(description="this tool helps to update ticket")
	public Ticket updateTicket(@ToolParam(description="new ticket detail with ticket id") Ticket ticket) {
		return tservice.updateTicket(ticket);	
	}
	@Tool(description="this tool hels to get current time")
	public String getCurrentTime()
	{
		return String.valueOf(System.currentTimeMillis());
	}
}
