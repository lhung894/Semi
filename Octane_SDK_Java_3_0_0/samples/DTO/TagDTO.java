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
public class TagDTO {
    private String tagId;
    private String productId;
    private String tagGateIn;
    private Date tagDateIn;
    private String tagGateOut;
    private Date tagDateOut;

    public TagDTO() {
    }

    public TagDTO(String tagId, String productId, String tagGateIn, Date tagDateIn, String tagGateOut, Date tagDateOut) {
        this.tagId = tagId;
        this.productId = productId;
        this.tagGateIn = tagGateIn;
        this.tagDateIn = tagDateIn;
        this.tagGateOut = tagGateOut;
        this.tagDateOut = tagDateOut;
    }

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getTagGateIn() {
        return tagGateIn;
    }

    public void setTagGateIn(String tagGateIn) {
        this.tagGateIn = tagGateIn;
    }

    public Date getTagDateIn() {
        return tagDateIn;
    }

    public void setTagDateIn(Date tagDateIn) {
        this.tagDateIn = tagDateIn;
    }

    public String getTagGateOut() {
        return tagGateOut;
    }

    public void setTagGateOut(String tagGateOut) {
        this.tagGateOut = tagGateOut;
    }

    public Date getTagDateOut() {
        return tagDateOut;
    }

    public void setTagDateOut(Date tagDateOut) {
        this.tagDateOut = tagDateOut;
    }

    @Override
    public String toString() {
        return "TagDTO{" + "tagId=" + tagId + ", productId=" + productId + ", tagGateIn=" + tagGateIn + ", tagDateIn=" + tagDateIn + ", tagGateOut=" + tagGateOut + ", tagDateOut=" + tagDateOut + "}\n";
    }
}
