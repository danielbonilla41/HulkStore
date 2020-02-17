/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hulkstore.service.rs.manageinventory.dao;

import com.hulkstore.service.restclient.RestClient;
import javax.enterprise.inject.Model;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.StringReader;
import java.math.BigDecimal;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Daniel
 */
@Model
public class InventoryDao {

    public Long consumeInventoryProductService(Long productId) throws Exception {

        String resource = "http://localhost:8080/Inventory-ES/v1/product/{product-id}/stock";
        String client = new RestClient(resource.replace("{product-id}", productId.toString())).consumeGetService().getResponse();

        JsonReader jsonReader = Json.createReader(new StringReader(client));
        JsonObject object = jsonReader.readObject();

        return object.getJsonNumber("quantity").longValue();

    }

    public Long consumeAddInventoryService(Long productId, Long quantity) throws Exception {

        String resource = "http://localhost:8080/Inventory-ES/v1/add";

        JsonObjectBuilder jsonBuilder = Json.createObjectBuilder();
        jsonBuilder.add("productId", productId);
        jsonBuilder.add("quantity", quantity);

        String client = new RestClient(resource)
                .consumePostService(jsonBuilder.build().toString(), MediaType.APPLICATION_JSON).getResponse();

        JsonReader jsonReader = Json.createReader(new StringReader(client));
        JsonObject object = jsonReader.readObject();

        return object.getJsonNumber("id").longValue();

    }

    public Long consumeDiscountInventoryService(Long productId, Long quantity) throws Exception {

        String resource = "http://localhost:8080/Inventory-ES/v1/discount";

        JsonObjectBuilder jsonBuilder = Json.createObjectBuilder();
        jsonBuilder.add("productId", productId);
        jsonBuilder.add("quantity", quantity);

        String client = new RestClient(resource)
                .consumePostService(jsonBuilder.build().toString(), MediaType.APPLICATION_JSON).getResponse();

        JsonReader jsonReader = Json.createReader(new StringReader(client));
        JsonObject object = jsonReader.readObject();

        return object.getJsonNumber("id").longValue();

    }

}
