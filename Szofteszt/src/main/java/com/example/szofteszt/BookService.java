package com.example.szofteszt;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookService {

        @Autowired
        BookRepository bookRepository;

    public List<Book> getAllBooks() {
        try {
            List<Book> books = new ArrayList<Book>();
                bookRepository.findAll().forEach(books::add);
            if (books.isEmpty()) {
                System.out.println("There are no books!");
            }
            return books;
        } catch (Exception e) {
            return null;
        }

    }

    public void createBook(Book book) {
        try {
            bookRepository.save(book);
        } catch (Exception e) {
            System.out.println("Couldnt save book: " + e);
        }

    }

    public Optional<Book> findById(Long id) {

            Optional<Book> book = bookRepository.findById(id);

            if (book.equals(null)) {
                System.out.println("No book was found");
                return null;
            } else {
                return book;
            }
    }

    public void deleteBookById(Long id) {

        try {
            bookRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println("Failed to delete book with id: "+ id + "Error cause: " + e);
        }
    }


    public void deleteALlBook() {
        try {
            bookRepository.deleteAll();
        } catch (Exception e) {
            System.out.println("Failed to delete books. Error cause: " + e);
        }
    }

    public void findByPublished() {
       List<Book> bookList = bookRepository.findAll();
       if (!bookList.isEmpty()){
           bookRepository.findByPublished(true);
       } else {
            System.out.println("no books");
       }
    }

    
}
