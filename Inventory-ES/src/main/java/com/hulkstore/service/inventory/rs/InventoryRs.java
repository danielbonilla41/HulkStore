/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hulkstore.service.inventory.rs;

import com.hulkstore.service.inventory.dto.InventoryRequest;
import com.hulkstore.service.inventory.dto.InventoryResponse;
import com.hulkstore.service.inventory.ejb.InventoryEjb;
import com.hulkstore.service.inventory.entity.Inventory;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Daniel
 */
@Path("v1")
public class InventoryRs {

    @EJB
    private InventoryEjb inventoryEjb;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/add")
    public Response addInventory(InventoryRequest inventoryRequest) {
        try {
            Inventory response = inventoryEjb.addProduct(inventoryRequest);
            GenericEntity genericEntity = new GenericEntity<Inventory>(response) {
            };
            return Response.status(200).entity(genericEntity).build();
        } catch (Exception ex) {
            return Response.status(500).entity(ex).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/discount")
    public Response discountInventory(InventoryRequest inventoryRequest) {
        try {
            Inventory response = inventoryEjb.discountProduct(inventoryRequest);
            GenericEntity genericEntity = new GenericEntity<Inventory>(response) {
            };
            return Response.status(200).entity(genericEntity).build();
        } catch (Exception ex) {
            return Response.status(500).entity(ex).build();
        }
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/product/{product-id}/stock")
    public Response gettoInventoryProduct(@PathParam("product-id") Long productId) {
        try {
            InventoryResponse response = inventoryEjb.toInventoryProduct(productId);
            GenericEntity genericEntity = new GenericEntity<InventoryResponse>(response) {
            };
            return Response.status(200).entity(genericEntity).build();
        } catch (Exception ex) {
            return Response.status(500).entity(ex).build();
        }
    }

}
