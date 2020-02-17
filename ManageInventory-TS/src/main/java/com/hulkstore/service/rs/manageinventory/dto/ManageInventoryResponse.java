/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hulkstore.service.rs.manageinventory.dto;

/**
 *
 * @author Daniel
 */
public class ManageInventoryResponse {

    private String message;

    public ManageInventoryResponse() {
    }

    public ManageInventoryResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
