package com.senla.antukhevich.bookstore.administrator;

import com.senla.antukhevich.bookstore.entity.Book;
import com.senla.antukhevich.bookstore.entity.Order;
import com.senla.antukhevich.bookstore.service.BookService;
import com.senla.antukhevich.bookstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Administrator {
    @Autowired
    BookService bookService;

    @Autowired
    OrderService orderService;

    public Administrator(){

    }

    public void addBook(Book book){
        bookService.addBook(book);
    }

    public Book findBookByName(String name){
        return bookService.findByName(name);
    }


    public void addOrder(Order order){
        orderService.addOrder(order);
    }

    public void removeBook(Book book){
        bookService.removeBook(book);
    }

    public void removeOrder(Order order) {
        orderService.removeOrder(order);
    }

    public Order findOrderById(Long id){
        return orderService.findOrderById(id);
    }

    public void completeOrder(Order order){
        orderService.completeOrder(order);
    }

    public void cancelOrder(Order order) {
        orderService.cancelOrder(order);
    }

    public void showOrders(){
        orderService.showOrders();
    }

    public void showBooks(){
        bookService.showBooks();
    }

    public void addBookToStore(Book book){
        bookService.addBookToStore(book);
    }

    public void writeOffBook(Book book){
        bookService.writeOffBook(book);
    }

    public void showBookInfo(Book book){
        bookService.showBookInfo(book);
    }

    public void showOrderInfo(Order order){
        orderService.showOrderInfo(order);
    }
}
