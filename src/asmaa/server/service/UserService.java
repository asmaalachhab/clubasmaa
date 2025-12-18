package asmaa.server.service;

import asmaa.server.dao.UserDAO;
import asmaa.server.model.User;

import java.sql.Connection;

public class UserService {
    private static UserService instance;
    private UserDAO userDAO;

    private UserService(Connection conn) { userDAO=new UserDAO(conn); }

    public static void init(Connection conn) {
        if(instance==null) instance=new UserService(conn);
    }

    public static UserService getInstance() { return instance; }

    public User login(String email, String password) { return userDAO.login(email,password); }
    public boolean register(User user) { return userDAO.register(user); }
}
