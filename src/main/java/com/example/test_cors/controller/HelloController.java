package com.example.test_cors.controller;

import com.example.test_cors.request.HelloRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class HelloController {
    @GetMapping(value = "hello")
    public ResponseEntity<String> getHello(){
        return ResponseEntity.status(HttpStatus.OK).body("Hello World");
    }

    @PostMapping(value = "hello")
    public ResponseEntity<String> getHelloPost(@RequestBody HelloRequest helloRequest){
        log.info(helloRequest.getMessage());
        return ResponseEntity.status(HttpStatus.OK).body("Hello World Post");
    }

    @PutMapping(value = "hello/{id}")
    public ResponseEntity<String> getHelloPut(@RequestBody HelloRequest helloRequest, @PathVariable int id){
        log.info(helloRequest.getMessage());
        log.info("id:"+id);
        return ResponseEntity.status(HttpStatus.OK).body("Hello World Put");
    }

    @DeleteMapping(value = "hello/{id}")
    public ResponseEntity<String> getHelloDelete(@PathVariable int id){
        log.info("id:"+id);
        return ResponseEntity.status(HttpStatus.OK).body("Hello World Delete");
    }
}
