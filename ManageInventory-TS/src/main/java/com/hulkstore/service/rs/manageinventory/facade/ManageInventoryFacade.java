/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hulkstore.service.rs.manageinventory.facade;

import com.hulkstore.service.rs.manageinventory.dto.ManageInventoryRequest;

/**
 *
 * @author Daniel
 */
public interface ManageInventoryFacade {

    public String purchaseProduct(ManageInventoryRequest manageInventoryRequest) throws Exception;

    public String addInventory(ManageInventoryRequest manageInventoryRequest) throws Exception;
}
