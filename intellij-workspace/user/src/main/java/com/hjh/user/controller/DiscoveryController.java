package com.hjh.user.controller;

import com.hjh.user.service.DiscoveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DiscoveryController
{
    @Autowired
    DiscoveryService discoveryService;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/services")
    public List<String> services()
    {
        return discoveryService.getServices();
    }

    @GetMapping("/showOne/{id}")
    public String showBoard(@PathVariable int id)
    {
        return restTemplate.exchange("http://board/showOne/{id}", HttpMethod.GET, null, String.class, id).getBody();
    }
}
