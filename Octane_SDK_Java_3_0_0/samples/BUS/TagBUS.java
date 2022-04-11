/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.TagDAO;
import DTO.TagDTO;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class TagBUS {
    TagDAO tagDAO;
    
    public ArrayList<TagDTO> getList () {
        tagDAO = new TagDAO();
        return tagDAO.getList();
    }
    
    public boolean insertTag (TagDTO tagDTO) {
        tagDAO = new TagDAO();
        if (tagDAO.insertTag(tagDTO)) {
            System.out.println("insert success TagBUS");
            return true;
        }
        System.out.println("insert fail TagBUS");
        return false;
    }
}
