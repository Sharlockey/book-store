package com.senla.antukhevich.bookstore.dto;

import com.senla.antukhevich.bookstore.entity.Book;
import com.senla.antukhevich.bookstore.status.OrderStatus;

import java.util.Date;

public class OrderDTO {
    private final int id;
    private final Book book;
    private final float price;
    private final Date order_date;
    private final OrderStatus status;


    public OrderDTO(int id, Book book, float price, Date order_date, OrderStatus status) {
        this.id = id;
        this.book = book;
        this.price = price;
        this.order_date = order_date;
        this.status = status;
    }

    @Override
    public String toString(){
        return "OrderDTO[" + id + ',' + book.getName() + ',' + price + ',' + order_date + ',' + status + ']';
    }
}
