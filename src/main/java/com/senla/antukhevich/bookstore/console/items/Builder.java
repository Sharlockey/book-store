package com.senla.antukhevich.bookstore.console.items;

import com.senla.antukhevich.bookstore.console.actions.*;
import com.senla.antukhevich.bookstore.administrator.Administrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Builder {

    @Autowired
    private Menu rootMenu;
    @Autowired
    Administrator administrator;

    public void buildMenu() {
        Menu rootMenu = new Menu();
        rootMenu.setName("Root Menu Options:");

        MenuItem doBookActions      = new MenuItem("Do book actions"  , new BookAction(administrator)   , rootMenu);
        MenuItem doOrderActions     = new MenuItem("Do order actions" , new OrderAction(administrator)  , rootMenu);
        MenuItem showObject         = new MenuItem("Show object"      , new ShowAction  (administrator) , rootMenu);
        MenuItem exit               = new MenuItem("Exit"             , new ExitAction()                , rootMenu);


        rootMenu.setMenuItems(new MenuItem[] { doBookActions, doOrderActions, showObject, exit });
        setRootMenu(rootMenu);
    }

    public Menu getRootMenu() {
        return rootMenu;
    }

    public void setRootMenu(Menu rootMenu) {
        this.rootMenu = rootMenu;
    }

}
