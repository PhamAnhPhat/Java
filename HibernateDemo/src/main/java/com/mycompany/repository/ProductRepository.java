/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repository;

import com.mycompany.hibernatedemo.HibernateUtils;
import com.mycompany.pojo.Product;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Hibernate;
import org.hibernate.Session;

/**
 *
 * @author admin
 */
public class ProductRepository {

    public List<Product> getProducts(Map<String, String> params, double price) {
        try ( Session session = HibernateUtils.getFactory().openSession()) {
            CriteriaBuilder b = session.getCriteriaBuilder();
            CriteriaQuery<Product> q = b.createQuery(Product.class);
            Root root = q.from(Product.class);
            q.select(root);

            if (params != null) {
                String kw = params.get("kw");
                if (kw != null && !kw.isEmpty()) {
                    Predicate pl = b.like(root.get("name"), String.format("%%%s%%", kw));
                    q.where(pl);
                }
                
            }
            q.orderBy(b.desc(root.get("id")));

            Query query = session.createQuery(q);
            return query.getResultList();
        }

    }
}
