package com.example.clientapi.service;

import com.example.clientapi.dto.ClientDto;
import com.example.clientapi.entity.Client;

import java.util.List;

public interface ClientService {
	List<Client> getAllClients(int page, int size);

	Client createClient(ClientDto clientDto);

	Client updateClient(Long id, ClientDto clientDto);

	Client getClient(Long id);
}
