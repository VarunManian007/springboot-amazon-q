package com.example.controller;

import com.example.dto.UserDto;
import com.example.exception.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable("id") Long id) throws IOException {
        if (id == 2) {
            throw new ResourceNotFoundException("Resource with ID " + id + " not found");
        }
        if (id == 3) {
            throw new IOException("Exception occurred while processing request " + id);
        }
        return new UserDto(id, "John Doe", "john.doe@example.com");
    }

    @PostMapping
    public UserDto createUser(@RequestBody UserDto user) {
        return user;
    }

    // New method using Java 8 features
    @GetMapping("/names")
    public List<String> getUserNames() {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        return names.stream()
                .map(String::toLowerCase)
                .collect(Collectors.toList());
    }

    @GetMapping("/getIdByName/{id}")
    public String getIdByName(@PathVariable("id") int id) {
        String str = "   Hello, World!   ";
        System.out.println(str.trim());

        String dayName;
        switch (id) {
            case 1: dayName = "Monday"; break;
            case 2: dayName = "Tuesday"; break;
            case 3: dayName = "Wednesday"; break;
            default: dayName = "Unknown"; break;
        }
        return dayName;
    }


}