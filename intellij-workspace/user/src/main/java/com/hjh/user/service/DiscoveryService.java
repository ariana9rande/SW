package com.hjh.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DiscoveryService
{
    @Autowired
    DiscoveryClient discoveryClient;

    public List<String> getServices()
    {
        List<String> services = new ArrayList<>();
        discoveryClient.getServices().forEach(serviceName ->
        {
            discoveryClient.getInstances(serviceName).forEach(instance ->
            {
                services.add(serviceName + ": " + instance.getUri());
            });
        });

        return services;
    }
}
