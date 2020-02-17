/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hulkstore.service.product.etl;

import com.hulkstore.service.product.dto.ProductResponse;
import com.hulkstore.service.product.entity.Product;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class ProductTransform {

    public List<ProductResponse> toProductResponse(List<Product> product) {
        List<ProductResponse> response = new ArrayList();
        for (Product p : product) {
            ProductResponse item = new ProductResponse();
            item.setId(p.getId());
            item.setName(p.getName());
            response.add(item);
        }
        return response;
    }

}
