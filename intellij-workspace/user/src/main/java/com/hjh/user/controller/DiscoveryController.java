package com.hjh.user.controller;

import com.hjh.user.service.DiscoveryService;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
=======
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
>>>>>>> origin/master
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
