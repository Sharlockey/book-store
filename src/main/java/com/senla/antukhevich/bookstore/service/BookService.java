package com.senla.antukhevich.bookstore.service;

import com.senla.antukhevich.bookstore.entity.Book;
import com.senla.antukhevich.bookstore.repository.BookRepository;
import com.senla.antukhevich.bookstore.repository.OrderRepository;
import com.senla.antukhevich.bookstore.status.BookStatus;
import com.senla.antukhevich.bookstore.status.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private OrderRepository orderRepository;

    public void addBook(Book book){
        bookRepository.save(book);
    }

    public Book getByID(Long ID){
        return bookRepository.findById(ID).orElse(null);
    }

    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    public Book findByName(String name){
        return bookRepository.findBookByName(name);
    }

    public void removeBook(Book book) {
        bookRepository.delete(book);
    }

    public void writeOffBook(Book book){
        book.setStatus(BookStatus.ABSENT);
        bookRepository.save(book);
    }

    public void addBookToStore(Book book){
        var orders = orderRepository.findAll().stream().filter(order -> order.getBook() == book).collect(Collectors.toList());
        for (var order: orders){
           order.setStatus(OrderStatus.NEW);
           orderRepository.save(order);
        }

        book.setStatus(BookStatus.PRESENT);
        bookRepository.save(book);
    }

    public void showBooks(){
        var books = getBooks();
        for (var book: books) {
            System.out.println(book.getID() + " " + book.getName());
        }
    }

    public void showBookInfo(Book book){
        System.out.println(book.getID() + " " +
                         book.getName() + " " +
                        book.getPrice() + " " +
                    book.getIssueDate() + " " +
                             book.getStatus());
    }
}
