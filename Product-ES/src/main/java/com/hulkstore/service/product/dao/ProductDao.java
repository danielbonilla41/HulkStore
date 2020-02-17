/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hulkstore.service.product.dao;

import com.hulkstore.service.product.entity.Product;
import javax.enterprise.inject.Model;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Daniel
 */
@Model
public class ProductDao {

    @PersistenceContext(name = "persistence")
    private EntityManager entityManager;

    public List<Product> getAllProduct() throws Exception {
        String jpql = "SELECT p FROM Product p";
        Query query = entityManager.createQuery(jpql, Product.class);
        return query.getResultList();
    }
}
