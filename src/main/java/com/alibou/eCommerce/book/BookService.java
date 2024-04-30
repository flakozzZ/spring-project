package com.alibou.eCommerce.book;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository repository;

    public void save(BookRequest request) {
        var book = Book.builder()
                .id(request.getId())
                .author(request.getAuthor())
                .isbn(request.getIsbn())
                .build();
        repository.save(book);
    }

    public void saveWithImage(BookRequest request, MultipartFile image) throws IOException {
        var book = Book.builder()
                .id(request.getId())
                .author(request.getAuthor())
                .isbn(request.getIsbn())
                .build();
        if (image != null && !image.isEmpty()) {
            book.setImageData(image.getBytes());
        }
        repository.save(book);
    }

    public List<Book> findAll() {
        return repository.findAll();
    }
}
