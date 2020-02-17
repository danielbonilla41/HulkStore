/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hulkstore.service.inventory.ejb;

import com.hulkstore.service.inventory.dao.InventoryDao;
import com.hulkstore.service.inventory.dto.InventoryRequest;
import com.hulkstore.service.inventory.dto.InventoryResponse;
import com.hulkstore.service.inventory.entity.Inventory;
import com.hulkstore.service.inventory.etl.InventoryTransform;
import com.hulkstore.service.inventory.facade.InventoryFacade;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Daniel
 */
@Stateless
@LocalBean
public class InventoryEjb implements InventoryFacade {

    @Inject
    private InventoryDao inventoryDao;
    @Inject
    private InventoryTransform inventoryTransform;

    @Override
    public Inventory addProduct(InventoryRequest inventoryRequest) throws Exception {
        return inventoryDao.addInvetory(inventoryTransform.toInventory(inventoryRequest));

    }

    @Override
    public Inventory discountProduct(InventoryRequest inventoryRequest) throws Exception {
        return inventoryDao.addInvetory(inventoryTransform.toInventoryDiscount(inventoryRequest));
    }

    @Override
    public InventoryResponse toInventoryProduct(Long productId) throws Exception {
        return inventoryTransform.toInventoryResponse(inventoryDao.toInventoryProduct(productId));
    }

}
