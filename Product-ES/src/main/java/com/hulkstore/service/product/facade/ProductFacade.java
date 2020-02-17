/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hulkstore.service.product.facade;

import com.hulkstore.service.product.dto.ProductResponse;
import java.util.List;

/**
 *
 * @author Daniel
 */
public interface ProductFacade {
    
    public List<ProductResponse> getAllProducts() throws Exception;
}

