package com.senla.antukhevich.bookstore.entity;

import com.senla.antukhevich.bookstore.status.BookStatus;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "books")
public class Book {
    protected Book(){}

    public Book(String name, float price, Calendar calendar){
        this.name = name;
        this.price = price;
        this.IssueDate = new Date(calendar.getTimeInMillis());
        this.status = BookStatus.PRESENT;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column(unique = true, nullable = false)
    @NonNull
    private String name;
    @NonNull
    private float price;
    private Date IssueDate;
    private BookStatus status;

    @OneToOne(mappedBy = "book")
    @JoinColumn(columnDefinition = "book_id")
    private Order order;


    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public Date getIssueDate() {
        return IssueDate;
    }

    public void setIssueDate(Date issueDate) {
        IssueDate = issueDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }
}
