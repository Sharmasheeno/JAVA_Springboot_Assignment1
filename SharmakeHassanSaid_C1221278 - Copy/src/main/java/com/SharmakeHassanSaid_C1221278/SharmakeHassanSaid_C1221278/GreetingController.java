package com.SharmakeHassanSaid_C1221278.SharmakeHassanSaid_C1221278;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class GreetingController {

    @GetMapping
    public String welcome() {
        return "Welcome to our API!";
    }

    @GetMapping("/greet/{name}")
    public String greet(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("/success")
    public ResponseEntity<String> success() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "SuccessHeader");
        return new ResponseEntity<>("Request was successful!", headers, HttpStatus.OK);
    }

    @GetMapping("/not-found")
    public ResponseEntity<String> notFound() {
        return new ResponseEntity<>("Error: Resource not found.", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createResource() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/resource/123"); // Example Location
        return new ResponseEntity<>("Resource created successfully!", headers, HttpStatus.CREATED);
    }
}