package com.senla.antukhevich.bookstore.dto;

import com.senla.antukhevich.bookstore.status.BookStatus;

import java.util.Date;

public class BookDTO {
    private final int    id;
    private final String name;
    private final float price;
    private final Date issue_date;
    private final BookStatus status;

    public BookDTO(int id, String name, float price, Date issue_date, BookStatus status){
        this.id = id;
        this.name = name;
        this.price = price;
        this.issue_date = issue_date;
        this.status = status;
    }

    @Override
    public String toString(){
        return "BookDTO[" + id + ',' + name + ',' + price + ',' + issue_date + ',' + status + ']';
    }
}
