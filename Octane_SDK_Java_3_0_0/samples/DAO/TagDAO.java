/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.TagDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class TagDAO {

    Connect conn;

    public TagDAO() {
    }

    public ArrayList<TagDTO> getList() {
        ArrayList<TagDTO> tagDTOs = new ArrayList<TagDTO>();
        conn = new Connect();
        conn.getConnection();
        String query = "select * from Tag";
        try {
            conn.executeQuery(query);
            while (conn.rs.next()) {
                TagDTO dto = new TagDTO();
                dto.setTagId(conn.rs.getString(1));
                dto.setProductId(conn.rs.getString(2));
                dto.setTagGateIn(conn.rs.getString(3));
                dto.setTagDateIn(conn.rs.getString(4));
                dto.setTagGateOut(conn.rs.getString(5));
                dto.setTagDateOut(conn.rs.getString(6));
                dto.setOrderId(conn.rs.getString(7));
                tagDTOs.add(dto);
            }
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("TagDAO.getList.executeQuery error.");
        }
        try {
            conn.getConn().close();
        } catch (SQLException e) {
            System.out.println("TagDAO.getList.close error.");
        }
        return tagDTOs;
    }

    public boolean insertTag(TagDTO tagDTO) {
        conn = new Connect();
        conn.getConnection();
        //(tag_id,product_id,tag_gate_in,tag_date_in,tag_gate_out,tag_date_out)
        String query = "INSERT INTO Tag"
                + " VALUES ('" + tagDTO.getTagId()
                + "','" + tagDTO.getProductId() + "'"
                + ",'" + tagDTO.getTagGateIn() + "'"
                + "," + tagDTO.getTagDateIn()
                + ",'" + tagDTO.getTagGateOut() + "'"
                + "," + tagDTO.getTagDateOut()
                + ",'" + tagDTO.getOrderId() + "')";
        if (conn.executeUpdate(query)) {
            conn.close();
            System.out.println("TagDAO insert success.");
            return true;
        }
        conn.close();
        System.out.println("TagDAO insert fail.");
        return false;
    }

    public boolean updateTag(TagDTO tagDTO, boolean check) {
        conn = new Connect();
        conn.getConnection();
        String sql = "UPDATE Tag SET";
        // true = nhập
        if (check) {
            sql += ", tag_gate_in='" + tagDTO.getTagGateIn() + "'"
                    + ", " + "tag_date_in='" + tagDTO.getTagDateOut();
        } else {
            sql += ", tag_gate_out='" + tagDTO.getTagGateIn() + "'"
                    + ", " + "tag_date_out='" + tagDTO.getTagDateOut();
        }
        sql += " WHERE tag_id='" + tagDTO.getTagId() + "';";
        if (conn.executeUpdate(sql)) {
            conn.close();
            System.out.println("TagDAO update success.");
            return true;
        }
        conn.close();
        System.out.println("TagDAO update fail.");
        return false;
    }
}
