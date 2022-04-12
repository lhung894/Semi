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
    ProductDAO productDAO = new ProductDAO();;
    
    public ArrayList<ProductDTO> getList () {
        return productDAO.getList();
    }
    
    public boolean updateProduct (ProductDTO productDTO) {
        if (productDAO.updateProductQuantity(productDTO)) {
            System.out.println("Update product success BUS");
            return true;
        }
        System.out.println("Update product fail BUS");
        return false;
    }
    
    public boolean updateProducts (ArrayList<ProductDTO> productDTOs) {
        if (productDAO.updateProductsQuantity(productDTOs)) {
            System.out.println("Update products success BUS");
            return true;
        }
        System.out.println("Update products fail BUS");
        return false;
    }
}
