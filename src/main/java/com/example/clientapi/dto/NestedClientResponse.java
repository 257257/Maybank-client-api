package com.example.clientapi.dto;

import com.example.clientapi.entity.Client;
import java.util.List;

public class NestedClientResponse {
    private List<Client> clients;
    private String advice;

    public NestedClientResponse(List<Client> clients, String advice) {
        this.clients = clients;
        this.advice = advice;
    }

    public List<Client> getClients() {
        return clients;
    }

    public String getAdvice() {
        return advice;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }
}
