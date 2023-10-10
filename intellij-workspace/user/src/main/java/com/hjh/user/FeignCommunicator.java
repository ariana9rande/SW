package com.hjh.user;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController // ?
@FeignClient("board")
public interface FeignCommunicator
{
    @RequestMapping("/showOne/{id}")
    String showOne(@PathVariable int id);
}
