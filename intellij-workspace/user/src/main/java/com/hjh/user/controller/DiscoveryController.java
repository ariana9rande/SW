package com.hjh.user.controller;

import com.hjh.user.service.DiscoveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DiscoveryController
{
    @Autowired
    DiscoveryService discoveryService;

    @GetMapping("/services")
    public List<String> services()
    {
        return discoveryService.getServices();
    }
}
