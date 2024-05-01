package com.flakozzz.eCommerce.modules.book;

import com.flakozzz.eCommerce.common.entities.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService service;

    @PostMapping
    public ResponseEntity<?> save(
            @RequestBody BookRequest request
    ) {
        service.save(request);
        return ResponseEntity.accepted().build();
    }

    @PostMapping("/save-image")
    public ResponseEntity<String> saveBookWithImage(@ModelAttribute BookRequest request, @RequestParam("image") MultipartFile image) {
        try {
            service.saveWithImage(request, image);
            return ResponseEntity.status(HttpStatus.CREATED).body("Image was created successfully");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something bad happen");
        }

    }

    @GetMapping
    public ResponseEntity<List<Book>> findAllBooks() {
        return ResponseEntity.ok(service.findAll());
    }
}
