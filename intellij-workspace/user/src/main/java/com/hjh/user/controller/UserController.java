package com.hjh.user.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.hjh.user.model.UserDTO;
import com.hjh.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
public class UserController
{
    private final UserService USER_SERVICE;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    public UserController(UserService userService)
    {
        this.USER_SERVICE = userService;
    }

    @PostMapping("/auth")
    public String auth(@RequestBody UserDTO attempt)
    {
        UserDTO result = USER_SERVICE.auth(attempt);

        if(result != null)
        {
            Gson gson = new Gson();
            return gson.toJson(result);
        }
        else
        {
            JsonObject object = new JsonObject();
            object.addProperty("result", "fail");

            return object.toString();
        }
    }
}
