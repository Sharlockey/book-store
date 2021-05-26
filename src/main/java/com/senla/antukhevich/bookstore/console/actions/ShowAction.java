package com.senla.antukhevich.bookstore.console.actions;

import com.senla.antukhevich.bookstore.administrator.Administrator;
import java.util.Scanner;

public class ShowAction implements IAction{
    private Administrator administrator;

    public ShowAction(Administrator administrator){
        this.administrator=administrator;
    }
    @Override
    public void execute() {
        System.out.println("Choose object list:\n" +
                "1. Book list\n" +
                "2. Order list");
        int key = new Scanner(System.in).nextInt();

        switch (key){
            case 1:
                administrator.showBooks();
                break;
            case 2:
                administrator.showOrders();
                break;
            case 3:
                break;
        }
    }
}
