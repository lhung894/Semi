/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.LastIdDAO;
import DAO.OrderDAO;
import DTO.OrderDTO;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class OrderBUS {
    OrderDAO orderDAO = new OrderDAO();
    Utils ult = new Utils();
    LastIdDAO lastIdDAO = new LastIdDAO();

    public ArrayList<OrderDTO> getList() {
        return orderDAO.getList();
    }

    public boolean insertOrder(OrderDTO orderDTO) {
        //orderDAO.insertOrder(orderDTO)
        if (orderDAO.insertOrder(orderDTO)) {
            String temp[] = orderDTO.getOrderId().split("_");
            System.out.println("temp[1] Order: " + temp[1]);
            lastIdDAO.updateOrderId(temp[1]);
            return true;
        }
        return false;
    }
}
