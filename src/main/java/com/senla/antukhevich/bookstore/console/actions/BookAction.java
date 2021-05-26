package com.senla.antukhevich.bookstore.console.actions;


import com.senla.antukhevich.bookstore.administrator.Administrator;
import com.senla.antukhevich.bookstore.entity.Book;

import java.util.GregorianCalendar;
import java.util.Scanner;

public class BookAction implements IAction {
    private final Administrator administrator;
    private final Scanner scanner;

    public BookAction(Administrator administrator){
        this.administrator=administrator;
        scanner = new Scanner(System.in);
    }
    @Override
    public void execute() {
        String name;
        showMenu();
        int key = scanner.nextInt();
        switch (key) {
            case 1:
                addBook();
                break;
            case 2:
                System.out.println("Enter an book name");
                name    = new Scanner(System.in).nextLine();
                var book = administrator.findBookByName(name);
                removeBook(book);
                break;
            case 3:
                System.out.println("Enter an book name");
                name    = new Scanner(System.in).nextLine();
                book = administrator.findBookByName(name);
                showBookInfo(book);
                break;
            case 4:
                System.out.println("Enter an book name");
                name    = new Scanner(System.in).nextLine();
                book = administrator.findBookByName(name);
                writeOffBook(book);
                break;
            case 5:
                System.out.println("Enter an book name");
                name    = new Scanner(System.in).nextLine();
                book = administrator.findBookByName(name);
                addBookToStore(book);
                break;
            default:
                break;
        }
    }

    private void showMenu(){
        System.out.println("Choose actions:\n" +
                "1. Add Book\n" +
                "2. Remove Book\n" +
                "3. Show Book Info\n" +
                "4. Write off book\n" +
                "5. Add book to store");
    }

    private void addBook(){
        System.out.println("Enter an book name");
        String  name    = new Scanner(System.in).nextLine();
        System.out.println("Enter an date of issue [day, month, year] in integer value: ");
        int     day     = scanner.nextInt();
        int     month   = scanner.nextInt() - 1;
        int     year    = scanner.nextInt();
        System.out.println("Enter a price of book:");
        float   price   = scanner.nextFloat();

        var book = new Book(name, price, new GregorianCalendar(year, month , day));
        administrator.addBook(book);
    }

    private void removeBook(Book book) {
        administrator.removeBook(book);
    }

    private void showBookInfo(Book book){
        administrator.showBookInfo(book);
    }

    private void writeOffBook(Book book){
        administrator.writeOffBook(book);
    }

    private void addBookToStore(Book book){
        administrator.addBookToStore(book);
    }
}
