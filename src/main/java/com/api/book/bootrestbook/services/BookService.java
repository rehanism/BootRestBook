package com.api.book.bootrestbook.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.entities.Book;

@Component
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    // private static List<Book> list = new ArrayList<>();

    // static{
    //     list.add(new Book(11, "Spring", "Brook"));
    //     list.add(new Book(21, "SpringMVC", "Zoro"));
    //     list.add(new Book(13, "SpringBoot", "Ussop"));
    // }

   
    //get all books
    public List<Book> getAllBooks()
    {
        List<Book> list = (List<Book>)this.bookRepository.findAll();
        return list;
    }
    //get single book by id
    public Book getBookById(int id)
    {

           // book = list.stream().filter(e->e.getId()==id).findFirst().get();
           Book book = this.bookRepository.findById(id);
        
        return book;
    }

    //adding the book
    public Book addBook(Book book)
    {
        //list.add(book);
        Book b = this.bookRepository.save(book);
        return b;
    }
    //delete book
    public void deleteBook(int id)
    {
       // list = list.stream().filter(book->book.getId()!=id).collect(Collectors.toList());
       this.bookRepository.deleteById(id);
    }
    //update book
    public void updateBook(Book book, int id) {
        // list = list.stream().map(b->{
        //     if(b.getId()==id)
        //     {
        //         b.setTitle(book.getTitle());
        //         b.setAuthor(book.getAuthor());
        //     }
        //     return b;
        // }).collect(Collectors.toList());

        book.setId(id);
        this.bookRepository.save(book);
    }
}
