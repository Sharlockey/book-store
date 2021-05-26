package com.senla.antukhevich.bookstore.console.items;

import com.senla.antukhevich.bookstore.administrator.Administrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Component
public class MenuController {

    @Autowired
    private Builder builder;
    @Autowired
    private Navigator navigator;



    public void run() {

        builder.buildMenu(); // builds main menu and sub-menus, creates actions
        navigator.setCurrentMenu(builder.getRootMenu());
        navigator.printMenu();
        try {
            try (Scanner scanner = new Scanner(System.in)) {
                while (true) { // waits for user input, never stops until exit action is called or error occurs
                    int choice = scanner.nextInt();
                    navigator.navigate(choice);
                }
            }
        } catch (Exception e) { /// you can use try-catch inside the 'while' loop, not to terminate process in case of error
            e.printStackTrace();
        }
    }
}
