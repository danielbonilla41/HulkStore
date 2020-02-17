package com.hulkstore.service.rs.manageinventory.ts;

import com.hulkstore.service.rs.manageinventory.dto.ManageInventoryRequest;
import com.hulkstore.service.rs.manageinventory.dto.ManageInventoryResponse;
import com.hulkstore.service.rs.manageinventory.ejb.ManageInventoryEjb;
import javax.ejb.EJB;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Daniel
 */
@Path("/")
public class ManageInventoryRs {

    @EJB
    private ManageInventoryEjb manageInventoryEjb;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/add")
    public Response addInventory(ManageInventoryRequest inventoryRequest) {
        try {
            String response = manageInventoryEjb.addInventory(inventoryRequest);
            ManageInventoryResponse manageInventoryResponse = new ManageInventoryResponse(response);
            GenericEntity genericEntity = new GenericEntity<ManageInventoryResponse>(manageInventoryResponse) {
            };
            return Response.status(200).entity(genericEntity).build();
        } catch (Exception ex) {
            return Response.status(500).entity(ex).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/purchase")
    public Response purchaseProduct(ManageInventoryRequest inventoryRequest) {
        try {
            String response = manageInventoryEjb.purchaseProduct(inventoryRequest);
            ManageInventoryResponse manageInventoryResponse = new ManageInventoryResponse(response);
            GenericEntity genericEntity = new GenericEntity<ManageInventoryResponse>(manageInventoryResponse) {
            };
            return Response.status(200).entity(genericEntity).build();
        } catch (Exception ex) {
            return Response.status(500).entity(ex).build();
        }
    }
}
