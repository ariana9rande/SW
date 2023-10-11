package com.hjh.board.controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.hjh.board.model.BoardDTO;
import com.hjh.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class BoardController
{
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private BoardService boardService;

    @GetMapping("/selectAll")
    public String selectAll()
    {
        List<BoardDTO> list = boardService.selectAll();
        JsonArray resultArray = new JsonArray();
        Gson gson = new Gson();

        for(BoardDTO b : list)
            resultArray.add(gson.toJson(b));

        return resultArray.toString();
    }

    @GetMapping("/selectOne/{id}")
    public String selectOne(@PathVariable int id)
    {
        BoardDTO boardDTO = boardService.selectOne(id);
        JsonObject resultObject = new JsonObject();
        Gson gson = new Gson();

        resultObject.addProperty("id", boardDTO.getId());
        resultObject.addProperty("writerId", boardDTO.getWriterId());
        resultObject.addProperty("title", boardDTO.getTitle());
        resultObject.addProperty("content", boardDTO.getContent());
        resultObject.addProperty("entryDate", String.valueOf(boardDTO.getEntryDate()));
        resultObject.addProperty("modifyDate", String.valueOf(boardDTO.getModifyDate()));

        return resultObject.toString();
    }
}
