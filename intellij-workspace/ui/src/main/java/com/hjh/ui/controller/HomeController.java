package com.hjh.ui.controller;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class HomeController
{
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/")
    public String showIndex()
    {
        return "index";
    }

    @PostMapping("/auth")
    public String sendAuthRequest(String username, String password, HttpSession session)
    {
        JsonObject object = new JsonObject();
        object.addProperty("username", username);
        object.addProperty("password", password);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<>(object.toString(), headers);

//        restTemplate.exchange("http://user/auth", HttpMethod.POST, request, String.class, multiValueMap);
        String result = restTemplate.postForObject("http://user/auth", request, String.class);

        JsonElement jsonElement = JsonParser.parseString(result);
        JsonObject resultObject = jsonElement.getAsJsonObject();

        if(resultObject.has("result"))
            return "redirect:/";
        else
        {
            session.setAttribute("loginId", resultObject.get("id"));

            return "redirect:/board/showAll";
        }
    }
}
