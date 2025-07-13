package com.example.clientapi.service.impl;

import com.example.clientapi.service.ExternalApiService;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExternalApiServiceImpl implements ExternalApiService {

    private static final Logger logger = LoggerFactory.getLogger(ExternalApiServiceImpl.class);

    @Override
    public String getRandomAdvice() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.adviceslip.com/advice";
        String response = restTemplate.getForObject(url, String.class);

        logger.info("Advice API response: {}", response);

        JSONObject json = new JSONObject(response);
        return json.getJSONObject("slip").getString("advice");
    }
}
