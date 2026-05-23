package com.substring.helpdesk.entity;


import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="help_desk_tickets")
public class Ticket {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Lob
	private String summary;
	@Enumerated(EnumType.STRING)
	private Priority priority;
	
	@Column(unique=true)
	private String email;
	
	private LocalDateTime createdon;
	
	private LocalDateTime updatedon;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@PrePersist
	void preSave() {
		if(this.createdon==null) 
		{
			this.createdon=LocalDateTime.now();
		}
		this.updatedon=LocalDateTime.now();
	}
	@PreUpdate
	void preUpdate()
	{
		this.updatedon=LocalDateTime.now();
	}
	
}
