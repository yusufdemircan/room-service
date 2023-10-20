package com.yedy.roomservice.mikroservices;

import com.yedy.roomservice.model.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "gateway-service")
public interface UserClient {
    @GetMapping("/user/test")
    UserDto getUserTest(@RequestHeader("Authorization") String token);
}
