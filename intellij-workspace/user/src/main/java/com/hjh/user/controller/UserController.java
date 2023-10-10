package com.hjh.user.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.hjh.user.model.UserDTO;
import com.hjh.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController
{
    private final UserService USER_SERVICE;

    @Autowired
    public UserController(UserService userService)
    {
        this.USER_SERVICE = userService;
    }

    public String auth(UserDTO userDTO)
    {
        UserDTO result = USER_SERVICE.auth(userDTO);
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
