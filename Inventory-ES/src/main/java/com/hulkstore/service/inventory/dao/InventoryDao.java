/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hulkstore.service.inventory.dao;

import com.hulkstore.service.inventory.entity.Inventory;
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
public class InventoryDao {

    @PersistenceContext(unitName = "persistence")
    private EntityManager entityManager;

    public Inventory addInvetory(Inventory inventory) throws Exception {
        return entityManager.merge(inventory);
    }

    public List<Inventory> toInventoryProduct(Long productId) throws Exception {
        String jpql = "SELECT i FROM Inventory i WHERE i.productid = :arg";
        Query query = entityManager.createQuery(jpql, Inventory.class).setParameter("arg", productId);
        return query.getResultList();
    }

}
