package com.java.web_travel.repository;

import com.java.web_travel.entity.Order;
import com.java.web_travel.model.response.PageResponse;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

@Repository
public class SearchRepository {
    @PersistenceContext
    private EntityManager entityManager; // inject vao de co the tuong tac voi co so du lieu

    public  PageResponse getAllOrderWithSortByMultipleColumsAndSearch(int pageNo, int pageSize, String search, String sortBy){
        StringBuilder sqlQuery = new StringBuilder("select o from Order o where 1=1 ");
        if(StringUtils.hasLength(search)){
            // tim kiem theo destination
            sqlQuery.append(" and lower(o.destination) like lower(:destination) "); // :destination : tham so dong duoc gan sau bang setParameter
        }

        Query selectQuery = entityManager.createQuery(sqlQuery.toString());
        // pageNo : so trang bat dau tim
        // pageSize : moi trang chua toi da pageSize ban ghi
        selectQuery.setFirstResult(pageNo*pageSize); // tim bat dau tu dong pageNo*pageSize
        selectQuery.setMaxResults(pageSize);
        if(StringUtils.hasLength(search)){
            selectQuery.setParameter("destination", "%"+search+"%");
        }
        List<Order> orders = (List<Order>) selectQuery.getResultList();
        System.out.println(sqlQuery.toString());
        System.out.println("orders: " + orders);
        return null;
    }
}
