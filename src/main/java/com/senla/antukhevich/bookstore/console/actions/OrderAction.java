package com.senla.antukhevich.bookstore.console.actions;

import com.senla.antukhevich.bookstore.administrator.Administrator;
import com.senla.antukhevich.bookstore.entity.Order;
import com.senla.antukhevich.bookstore.status.BookStatus;
import com.senla.antukhevich.bookstore.status.OrderStatus;

import java.util.Scanner;

public class OrderAction implements IAction {
    private Administrator administrator;
    private Scanner scanner;

    public OrderAction(Administrator administrator){
        this.administrator=administrator;
        scanner = new Scanner(System.in);
    }

    @Override
    public void execute(){
        showMenu();

        int key = scanner.nextInt();

        switch (key) {
            case 1:
                addOrder();
                break;
            case 2:
                removeOrder();
                break;
            case 3:
                cancelOrder();
                break;
            case 4:
                cancelOrder();
                break;
            case 5:
                showOrderInfo();
                break;
            default:
                break;
        }
    }

    private void showMenu(){
        System.out.println("Choose actions:\n" +
                "1. Add Order\n" +
                "2. Remove Order\n" +
                "3. Cancel Order\n" +
                "4. Complete Order\n" +
                "5. Show Order Info");
    }

    private void addOrder(){
        Order order;
        System.out.println("Enter the book name you want to add: ");
        String  name    = new Scanner(System.in).nextLine();
        var book = administrator.findBookByName(name);

        if(book != null){
            if(book.getStatus() == BookStatus.ABSENT){
                order = new Order(book, book.getPrice(), OrderStatus.REQUEST);
                administrator.addOrder(order);
            }
            order = new Order(book, book.getPrice(), OrderStatus.NEW);
            administrator.addOrder(order);
        }
    }

    private void removeOrder(){
        System.out.println("Enter an order id");
        Long id = scanner.nextLong();
        var order = administrator.findOrderById(id);

        administrator.removeOrder(order);
    }

    private void cancelOrder(){
        System.out.println("Enter an order id");
        Long id = scanner.nextLong();
        var order = administrator.findOrderById(id);

        administrator.cancelOrder(order);
    }

    private void completeOrder(){
        System.out.println("Enter an order id");
        Long id = scanner.nextLong();
        var order = administrator.findOrderById(id);

        administrator.completeOrder(order);
    }

    private void showOrderInfo(){
        System.out.println("Enter an order id");
        Long id = scanner.nextLong();
        var order = administrator.findOrderById(id);

        administrator.showOrderInfo(order);
    }

}
