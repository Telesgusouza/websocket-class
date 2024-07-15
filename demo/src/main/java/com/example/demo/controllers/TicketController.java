package com.example.demo.controllers;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.TicketService;

// quem quiser logar tera que pássar por aqui para que seu ticket seja gerado

@RestController
@RequestMapping("api/v1/ticket")
@CrossOrigin
public class TicketController {

	@Autowired
	private TicketService ticketService;

	@PostMapping
	public Map<String, String> buildTicket(@RequestHeader(HttpHeaders.AUTHORIZATION) String authorization) {
		String token = Optional.ofNullable(authorization).map(it -> it.replace("Bearer ", "")).orElse("");
		String ticket = ticketService.buildAndSaveTicket(token);
		return Map.of("ticket", ticket);
	}
}
