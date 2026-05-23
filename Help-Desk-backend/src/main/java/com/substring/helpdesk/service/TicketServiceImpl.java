package com.substring.helpdesk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.substring.helpdesk.Repository.TicketRepo;
import com.substring.helpdesk.entity.Ticket;

import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Service
@Data
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService{
	
	@Autowired
	private TicketRepo ticketrepository;
	
	//create ticket
	@Transactional
	public Ticket CreateTicket(Ticket ticket) {
		ticket.setId(null);
		return ticketrepository.save(ticket);
	}
	
	//update ticket
	public Ticket getTicket(Long ticketId)
	{
		return ticketrepository.findById(ticketId).orElse(null);
	}
	
	public Ticket getTicketByEmail(String email)
	{
		return ticketrepository.findByEmail(email).orElse(null);
	}
	@Transactional
	public Ticket updateTicket(Ticket ticket)
	{
		return ticketrepository.save(ticket);
	}

	
	//delete ticket
	
}
