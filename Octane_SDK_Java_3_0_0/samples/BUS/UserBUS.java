/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import static BUS.HashPass.MD5Hash;
import DAO.UserDAO;
import DTO.UserDTO;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class UserBUS {
    UserDAO userDAO = new UserDAO();

    public ArrayList<UserDTO> getList() {
        return userDAO.getList();
    }
    
    public UserDTO checkLogin (String userName, String passWord) {
        String passHash = MD5Hash(passWord);
        ArrayList<UserDTO> list = userDAO.getList();
        for (UserDTO u : list) {
            if (u.getUserName().equals(userName) && u.getPassWord().equals(passHash)) {
                return u;
            }
        }
        return null;
    }

    public boolean insertUser(UserDTO userDTO) {
        userDTO.setPassWord(MD5Hash(userDTO.getPassWord()));
        if (userDAO.insertUser(userDTO)) {
            System.out.println("insert success UserBUS");
            return true;
        }
        System.out.println("insert fail UserBUS");
        return false;
    }
}
