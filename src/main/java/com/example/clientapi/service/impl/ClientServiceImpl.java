package com.example.clientapi.service.impl;


import com.example.clientapi.dto.ClientDto;
import com.example.clientapi.entity.Client;
import com.example.clientapi.repository.ClientRepository;
import com.example.clientapi.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Client> getAllClients(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return clientRepository.findAll(pageable).getContent();
    }

    @Override
    @Transactional
    public Client createClient(ClientDto clientDto) {
        Client client = new Client();
        client.setName(clientDto.getName());
        client.setEmail(clientDto.getEmail());
        return clientRepository.save(client);
    }

    @Override
    @Transactional
    public Client updateClient(Long id, ClientDto clientDto) {
        Client client = clientRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Client not found"));
        client.setName(clientDto.getName());
        client.setEmail(clientDto.getEmail());
        return clientRepository.save(client);
    }

    @Override
    @Transactional(readOnly = true)
    public Client getClient(Long id) {
        return clientRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Client not found"));
    }
}

