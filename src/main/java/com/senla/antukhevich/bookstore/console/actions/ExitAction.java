package com.senla.antukhevich.bookstore.console.actions;

import com.senla.antukhevich.bookstore.administrator.Administrator;

public class ExitAction implements IAction {

    @Override
    public void execute() {
        System.out.println("Process terminated");
        System.exit(0);
    }
}
