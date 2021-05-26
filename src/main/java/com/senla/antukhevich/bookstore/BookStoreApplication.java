package com.senla.antukhevich.bookstore;

import com.senla.antukhevich.bookstore.console.items.MenuController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookStoreApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(BookStoreApplication.class, args);
    }
    @Autowired
    MenuController menu;

    @Override
    public void run(String... args) throws Exception {
        menu.run();
    }
}
