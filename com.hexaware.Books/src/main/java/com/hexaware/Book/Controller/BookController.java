package com.hexaware.Book.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.Book.Entity.Book;
import com.hexaware.Book.Service.BookService;



@RestController
@RequestMapping("/api/admin")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/addNewBook")
    public Book addNewBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @GetMapping("/getAllBooks")
    public List<Book> getAllBooks() {
        return bookService.getBooks();
    }

    @DeleteMapping("/deleteBook/{isbn}")
    public Book deleteBook(@PathVariable("isbn") long isbn) {
        return bookService.delete(isbn);
    }

    @PutMapping("/updateBook/{isbn}/{name}")
    public String updateBook(@PathVariable("isbn") long isbn, @PathVariable("name") String name) {
        return bookService.updatebook(isbn, name);
    }

    @GetMapping("/findByISBN/{isbn}")
    public String findByISBN(@PathVariable("isbn") long isbn) {
        return bookService.findbyISBN(isbn);
    }
    
}
