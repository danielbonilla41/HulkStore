/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hulkstore.service.rs.manageinventory.ejb;

import com.hulkstore.service.rs.manageinventory.dao.InventoryDao;
import com.hulkstore.service.rs.manageinventory.dto.ManageInventoryRequest;
import com.hulkstore.service.rs.manageinventory.facade.ManageInventoryFacade;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Daniel
 */
@Stateless
@LocalBean
public class ManageInventoryEjb implements ManageInventoryFacade {

    @Inject
    private InventoryDao inventoryDao;

    @Override
    public String purchaseProduct(ManageInventoryRequest manageInventoryRequest) throws Exception {
        Long inventoryProduct = inventoryDao.consumeInventoryProductService(manageInventoryRequest.getProductId());
        if (inventoryProduct > 0) {
            if (inventoryProduct > manageInventoryRequest.getQuantity()) {
                return "La cantidad ingresada excede la cantidad en inventario";
            } else {
                Long discountId = inventoryDao.consumeDiscountInventoryService(manageInventoryRequest.getProductId(), manageInventoryRequest.getQuantity());
                return "Se ha realizado la compra, " + "codigo de compra: " + discountId;
            }
        } else {
            return "Producto agotado";
        }
    }

    public String addInventory(ManageInventoryRequest manageInventoryRequest) throws Exception {
        Long addId = inventoryDao.consumeAddInventoryService(manageInventoryRequest.getProductId(), manageInventoryRequest.getQuantity());
        return "Se ha agregado al stock, " + "codigo : " + addId;

    }

}
