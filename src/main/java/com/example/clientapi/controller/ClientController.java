package com.example.clientapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.example.clientapi.dto.ClientDto;
import com.example.clientapi.dto.NestedClientResponse;
import com.example.clientapi.entity.Client;
import com.example.clientapi.service.ClientService;
import com.example.clientapi.service.ExternalApiService;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

	@Autowired
	private ClientService clientService;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ExternalApiService externalApiService;

	@GetMapping
	public ResponseEntity<List<Client>> getClients(@RequestParam(defaultValue = "0") int page) {
		return ResponseEntity.ok(clientService.getAllClients(page, 10));
	}

	@PostMapping
	public ResponseEntity<Client> createClient(@RequestBody ClientDto dto) {
		return ResponseEntity.ok(clientService.createClient(dto));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody ClientDto dto) {
		return ResponseEntity.ok(clientService.updateClient(id, dto));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Client> getClient(@PathVariable Long id) {
		return ResponseEntity.ok(clientService.getClient(id));
	}

	@GetMapping("/with-advice")
	public ResponseEntity<NestedClientResponse> getClientsWithAdvice(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {

		List<Client> clients = clientService.getAllClients(page, size);
		String advice = externalApiService.getRandomAdvice();

		return ResponseEntity.ok(new NestedClientResponse(clients, advice));
	}
}
