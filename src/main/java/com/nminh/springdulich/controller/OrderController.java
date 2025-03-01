package com.nminh.springdulich.controller;

import com.nminh.springdulich.entity.Order;
import com.nminh.springdulich.model.request.OrderDTO;
import com.nminh.springdulich.model.request.OrderHotelDTO;
import com.nminh.springdulich.model.response.ApiReponse;
import com.nminh.springdulich.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @PostMapping("/create/{id}") // id này là của user
    public ApiReponse<Order> addOrder(@Valid  @RequestBody OrderDTO orderDTO,@PathVariable Long id) {
        ApiReponse<Order> apiReponse = new ApiReponse<>();
        apiReponse.setData(orderService.addOrder(orderDTO,id));
        return apiReponse;
    }
    @PostMapping("/chooseHotel/{orderId}/{hotelId}") // id này là của id order dto
    public ApiReponse<Order> chooseHotel(
            @PathVariable Long orderId,
            @PathVariable Long hotelId,
            @RequestBody OrderHotelDTO orderHotelDTO) {

        ApiReponse<Order> apiReponse = new ApiReponse<>();

        Order order = orderService.chooseHotel(orderId, hotelId, orderHotelDTO);
        orderService.saveOrder(order);

        apiReponse.setData(order);
        apiReponse.setMessage("success");
        return apiReponse;
    }
    @PostMapping("/chooseFlight/{idOrder}/{idFlight}")
    public ApiReponse<Order> chooseFlight(@PathVariable Long idOrder,@PathVariable Long idFlight) {
        ApiReponse<Order> apiReponse = new ApiReponse<>();
        Order order = orderService.chooseFlight(idOrder,idFlight);
        apiReponse.setData(order);
        apiReponse.setMessage("success");
        return apiReponse;
    }
    // hủy cả chuyến
    @DeleteMapping("/{id}")
    public ApiReponse<Order> deleteOrder(@PathVariable Long id) {
        ApiReponse<Order> apiReponse = new ApiReponse<>();
        orderService.cancelOrder(id);
        apiReponse.setMessage("cancel success");
        return apiReponse;
    }
    // hủy máy bay
    @PutMapping("/cancelFlight/{id}")
    public ApiReponse<Order> cancelFlight(@PathVariable Long id) {
        ApiReponse<Order> apiReponse = new ApiReponse<>();
        Order order = orderService.cancelFlight(id);
        apiReponse.setData(order);
        apiReponse.setMessage("cancel success");
        return apiReponse;
    }
    @GetMapping("/{id}")
    public ApiReponse<List<Order>> getOrderById(@PathVariable Long id) {
        ApiReponse<List<Order>> apiReponse = new ApiReponse<>();
        List<Order> orderList = orderService.getOrdersByUserId(id) ;
        apiReponse.setData(orderList);
        apiReponse.setMessage("success");
        return apiReponse;
    }
    @GetMapping("/getAllOrder")
    public ApiReponse<List<Order>> getAllOrder() {
        ApiReponse<List<Order>> apiReponse = new ApiReponse<>();
        apiReponse.setData(orderService.getAllOrders());
        apiReponse.setMessage("success");
        return apiReponse;
    }
}
