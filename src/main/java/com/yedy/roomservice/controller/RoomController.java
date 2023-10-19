package com.yedy.roomservice.controller;

import com.yedy.roomservice.model.RoomDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("room")
public class RoomController {
    @GetMapping("test")
    public RoomDto test(){
        RoomDto dto = new RoomDto();
        dto.setAdi("oda1");
        dto.setKapasite("15");
        return dto;
    }
}
