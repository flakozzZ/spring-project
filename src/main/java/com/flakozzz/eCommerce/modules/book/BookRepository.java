package com.flakozzz.eCommerce.modules.book;

import com.flakozzz.eCommerce.common.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
