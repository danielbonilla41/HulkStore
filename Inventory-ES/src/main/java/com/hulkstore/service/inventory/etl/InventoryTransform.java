/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hulkstore.service.inventory.etl;

import com.hulkstore.service.inventory.dto.InventoryRequest;
import com.hulkstore.service.inventory.dto.InventoryResponse;
import com.hulkstore.service.inventory.entity.Inventory;
import java.util.List;

/**
 *
 * @author Daniel
 */
public class InventoryTransform {

    public Inventory toInventory(InventoryRequest inventoryRequest) {
        Inventory inventory = new Inventory();
        inventory.setDiscount(Boolean.FALSE);
        inventory.setProductid(inventoryRequest.getProductId());
        inventory.setQuantity(inventoryRequest.getQuantity());
        inventory.setId(inventoryRequest.getId());
        return inventory;
    }

    public Inventory toInventoryDiscount(InventoryRequest inventoryRequest) {
        Inventory inventory = new Inventory();
        inventory.setDiscount(Boolean.TRUE);
        inventory.setProductid(inventoryRequest.getProductId());
        inventory.setQuantity(inventoryRequest.getQuantity());
        inventory.setId(inventoryRequest.getId());
        return inventory;
    }

    public InventoryResponse toInventoryResponse(List<Inventory> inventoryProduct) {
        InventoryResponse inventoryResponse = new InventoryResponse();
        Long quantityAdd = 0L;
        Long quantityDiscount = 0L;
        for (Inventory i : inventoryProduct) {
            if (i.getDiscount()) {
                quantityDiscount = quantityDiscount + i.getQuantity();
            } else {
                quantityAdd = quantityAdd + i.getQuantity();
            }
        }
        inventoryResponse.setQuantity(quantityAdd - quantityDiscount);
        return inventoryResponse;
    }
    public InventoryResponse toInventoryResponse(Long inventoryId) {
        InventoryResponse inventoryResponse = new InventoryResponse();
        inventoryResponse.setId(inventoryId);        
        return inventoryResponse;
    }

}
