/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hulkstore.service.inventory.facade;

import com.hulkstore.service.inventory.dto.InventoryRequest;
import com.hulkstore.service.inventory.dto.InventoryResponse;
import com.hulkstore.service.inventory.entity.Inventory;

/**
 *
 * @author Daniel
 */
public interface InventoryFacade {
    
    public Inventory addProduct(InventoryRequest inventoryRequest) throws Exception;
    
    public Inventory discountProduct(InventoryRequest inventoryRequest) throws Exception;
    
    public InventoryResponse toInventoryProduct(Long productId) throws Exception;
    
}
