package com.substring.helpdesk.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.substring.helpdesk.entity.Ticket;

public interface TicketRepo extends JpaRepository<Ticket,Long> {
	
	Optional<Ticket> findById(Long ticketId);
	Optional<Ticket> findByEmail(String email);
}
