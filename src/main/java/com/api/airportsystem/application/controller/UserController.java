package com.api.airportsystem.application.controller;

import com.api.airportsystem.application.service.UserService;
import com.api.airportsystem.domain.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/v1/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody UserDTO userDTO) {
        userService.createUser(userDTO);
        return ResponseEntity.ok().body("Created");
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getUserByUserId(@PathVariable String userId) {
        return ResponseEntity.ok().body(userService.getUserByUserId(userId));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<String> updateUser(@RequestBody UserDTO userDTO, @PathVariable String userId) {
        userService.updateUser(userDTO, userId);
        return ResponseEntity.ok().body("Updated");
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok().body("Deleted");
    }
}
