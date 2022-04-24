/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.UserDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class UserDAO {
    Connect conn;

    public UserDAO() {
    }

    public ArrayList<UserDTO> getList() {
        ArrayList<UserDTO> userDTOs = new ArrayList<UserDTO>();
        conn = new Connect();
        conn.getConnection();
        String query = "select * from User_App";
        try {
            conn.executeQuery(query);
            while (conn.rs.next()) {
                UserDTO dto = new UserDTO();
                dto.setUserId(conn.rs.getString(1));
                dto.setUserName(conn.rs.getString(2));
                dto.setPassWord(conn.rs.getString(3));
                dto.setFullName(conn.rs.getString(4));
                dto.setPhoneNum(conn.rs.getString(5));
                dto.setMail(conn.rs.getString(6));
                userDTOs.add(dto);
            }
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("UserDAO.getList.executeQuery error.");
        }
        try {
            conn.getConn().close();
        } catch (SQLException e) {
            System.out.println("UserDAO.getList.close error.");
        }
        return userDTOs;
    }

    public boolean insertUser(UserDTO userDTO) {
        conn = new Connect();
        conn.getConnection();
        //(tag_id,product_id,tag_gate_in,tag_date_in,tag_gate_out,tag_date_out)
        String query = "INSERT INTO User_App"
                + " VALUES ('" + userDTO.getUserId()
                + "','" + userDTO.getUserName() + "'"
                + ",'" + userDTO.getPassWord() + "'"
                + ",'" + userDTO.getFullName() + "'"
                + ",'" + userDTO.getPhoneNum() + "'"
                + ",'" + userDTO.getMail() + "')";
        System.out.println("query: " + query);
        if (conn.executeUpdate(query)) {
            conn.close();
            System.out.println("UserDAO insert success.");
            return true;
        }
        conn.close();
        System.out.println("UserDAO insert fail.");
        return false;
    }
}
