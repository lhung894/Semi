/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Date;

/**
 *
 * @author User
 */
public class OrderDTO {
    private String orderId;
    private String orderDate;
    private int status;

    public OrderDTO() {
    }

    public OrderDTO(String orderId, String orderDate, int status) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.status = status;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrderDTO{" + "orderId=" + orderId + ", orderDate=" + orderDate + ", status=" + status + "}\n";
    }
}
