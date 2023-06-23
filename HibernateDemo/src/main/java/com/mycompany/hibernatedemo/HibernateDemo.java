/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.hibernatedemo;

import com.mycompany.pojo.Category;
import com.mycompany.repository.ProductRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import org.hibernate.Session;




/**
 *
 * @author admin
 */
public class HibernateDemo {

    public static void main(String[] args) {
        Map<String,String> params = new HashMap<>();
        params.put("kw", "Galaxy");
        
        ProductRepository pre = new ProductRepository();
        pre.getProducts(params,500000).forEach(p -> System.out.printf("%d - %s - %f\n",p.getId(),p.getName(),p.getPrice()));
        
//     try(Session session = HibernateUtils.getFactory().openSession()){
//         Query q = session.createQuery("FROM Category");
//         List<Category> cates = q.getResultList();
//          cates.forEach(p -> System.out.println(p.getName()));  
//     }
    }
}
