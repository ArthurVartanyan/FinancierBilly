package com.financier.billy.contoller;

import com.financier.billy.dto.UserDTO;
import com.financier.billy.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping(value = "/generate")
    public ResponseEntity<UserDTO> generateUser() {
        return new ResponseEntity<>(userService.generateUser(), HttpStatusCode.valueOf(201));
    }
}