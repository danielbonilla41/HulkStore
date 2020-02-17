/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hulkstore.service.product.ejb;

import com.hulkstore.service.product.dao.ProductDao;
import com.hulkstore.service.product.dto.ProductResponse;
import com.hulkstore.service.product.etl.ProductTransform;
import com.hulkstore.service.product.facade.ProductFacade;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

/**
 *
 * @author Daniel
 */
@Stateless
@LocalBean
public class ProductEjb implements ProductFacade {

    @Inject
    private ProductDao productDao;
    @Inject
    private ProductTransform productTransform;

    @Override
    public List<ProductResponse> getAllProducts() throws Exception {
        return productTransform.toProductResponse(productDao.getAllProduct());
    }

}
