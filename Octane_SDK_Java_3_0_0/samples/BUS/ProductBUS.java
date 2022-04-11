/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.ProductDAO;
import DTO.ProductDTO;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class ProductBUS {
//    ArrayList<ProductDTO> productDTOs = new ArrayList<>();
    ProductDAO productDAO;
    
    public ArrayList<ProductDTO> getList () {
        productDAO = new ProductDAO();
        return productDAO.getList();
    }
}
