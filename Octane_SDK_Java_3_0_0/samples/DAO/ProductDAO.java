/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.ProductDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class ProductDAO {
    Connect conn;

    public ProductDAO() {
    }

    public ArrayList<ProductDTO> getList() {
        ArrayList<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
        conn = new Connect();
        conn.getConnection();
        String query = "select * from Product";
        try {
            conn.executeQuery(query);
            while (conn.rs.next()) {
                ProductDTO dto = new ProductDTO();
                dto.setProductId(conn.rs.getString(1));
                dto.setProductName(conn.rs.getString(2));
                dto.setProductQuantity(conn.rs.getInt(3));
                dto.setProductDetail(conn.rs.getString(4));
                productDTOs.add(dto);
            }
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("ProductDAO.getList.executeQuery error.");
        }
        try {
            conn.getConn().close();
        } catch (SQLException e) {
            System.out.println("ProductDAO.getList.close error.");
        }
        return productDTOs;
    }
    
    public boolean updateProductQuantity(ProductDTO productDTO) {
        conn = new Connect();
        conn.getConnection();
        String sql = "UPDATE Product SET"
                + " product_quantity=" + productDTO.getProductQuantity()
                + " WHERE product_id='" + productDTO.getProductId() + "';";
        if (conn.executeUpdate(sql)) {
            conn.close();
            System.out.println("ProductDAO update success.");
            return true;
        }
        conn.close();
        System.out.println("ProductDAO update fail.");
        return false;
    }
    
    public boolean updateProductsQuantity(ArrayList<ProductDTO> productDTOs) {
        conn = new Connect();
        conn.getConnection();
        String sql = ""; 
        for (ProductDTO product : productDTOs) {
            sql += "UPDATE Product SET"
                + " product_quantity=" + product.getProductQuantity()
                + " WHERE product_id='" + product.getProductId() + "';";
        }
        if (conn.executeUpdate(sql)) {
            conn.close();
            System.out.println("ProductDAO update success.");
            return true;
        }
        conn.close();
        System.out.println("ProductDAO update fail.");
        return false;
    }
}
