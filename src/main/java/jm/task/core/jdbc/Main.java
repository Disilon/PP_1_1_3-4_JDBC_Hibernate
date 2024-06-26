package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;


public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Name1", "LastName1", (byte) 99);
        userService.saveUser("Name2", "LastName2", (byte) 121);
        System.out.println(userService.getAllUsers());
        Util.close();
    }
}
