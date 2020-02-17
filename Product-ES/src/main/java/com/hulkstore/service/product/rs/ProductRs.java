/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hulkstore.service.product.rs;

import com.hulkstore.service.product.dto.ProductResponse;
import com.hulkstore.service.product.ejb.ProductEjb;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Daniel
 */
@Path("/")
public class ProductRs {

    @EJB
    private ProductEjb productEjb;

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProduct() {
        try {
            List<ProductResponse> response = productEjb.getAllProducts();            
            if (response.isEmpty() || response.size() < 1) {
                return Response.status(200).entity("No se encontraron resultados").build();
            }
            GenericEntity<List<ProductResponse>> genericEntity = new GenericEntity<List<ProductResponse>>(response){};                        
            return Response.status(200).entity(genericEntity).build();
        } catch (Exception ex) {
            return Response.status(500).entity(ex).build();
        }
    }
}
