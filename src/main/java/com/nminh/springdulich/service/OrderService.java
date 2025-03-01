package com.nminh.springdulich.service;

import com.nminh.springdulich.entity.Order;
import com.nminh.springdulich.model.request.OrderDTO;
import com.nminh.springdulich.model.request.OrderHotelDTO;

import java.util.List;

public interface OrderService {
    public Order addOrder(OrderDTO orderDTO, Long userId);
    public Order chooseHotel(Long orderId, Long HotelId, OrderHotelDTO orderHotelDTO);
    public  Order saveOrder(Order order) ;
    public Order chooseFlight(Long orderId , Long flightId);
    public void cancelOrder(Long orderId);
    public Order cancelFlight(Long orderId) ;
    public List<Order> getOrdersByUserId(Long userId);
    public List<Order> getAllOrders();
}
