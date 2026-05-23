package com.substring.helpdesk.service;

import com.substring.helpdesk.entity.Ticket;

public interface TicketService {
	Ticket CreateTicket(Ticket ticket);
	Ticket getTicket(Long ticketId);
	Ticket getTicketByEmail(String email);
	Ticket updateTicket(Ticket ticket);
}
