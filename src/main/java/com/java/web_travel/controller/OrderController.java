package com.java.web_travel.controller;

import com.java.web_travel.entity.Order;
import com.java.web_travel.model.request.OrderDTO;
import com.java.web_travel.model.request.OrderHotelDTO;
import com.java.web_travel.model.response.ApiReponse;
import com.java.web_travel.model.response.PageResponse;
import com.java.web_travel.service.OrderService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @PostMapping("/create/{id}") // id này là của user
    public ApiReponse<Order> addOrder(@Valid  @RequestBody OrderDTO orderDTO,@PathVariable Long id) {
        log.info("Start add order of user id = {}",id);
        ApiReponse<Order> apiReponse = new ApiReponse<>();
        apiReponse.setData(orderService.addOrder(orderDTO,id));
        log.info("Add order successfully of user id = {}",id);
        return apiReponse;
    }
    @PostMapping("/chooseHotel/{orderId}/{hotelId}") // id này là của id order dto
    public ApiReponse<Order> chooseHotel(
            @PathVariable Long orderId,
            @PathVariable Long hotelId,
            @RequestBody OrderHotelDTO orderHotelDTO) {
        log.info("Start choose hotel of user id = {}",orderId);

        ApiReponse<Order> apiReponse = new ApiReponse<>();

        Order order = orderService.chooseHotel(orderId, hotelId, orderHotelDTO);
        orderService.saveOrder(order);

        apiReponse.setData(order);
        apiReponse.setMessage("success");
        log.info("Choose hotel successfully of user id = {}",orderId);
        return apiReponse;
    }
    @PostMapping("/chooseFlight/{idOrder}/{idFlight}")
    public ApiReponse<Order> chooseFlight(@PathVariable Long idOrder,@PathVariable Long idFlight) {
        log.info("Start choose flight of user id = {}",idOrder);
        ApiReponse<Order> apiReponse = new ApiReponse<>();
        Order order = orderService.chooseFlight(idOrder,idFlight);
        apiReponse.setData(order);
        apiReponse.setMessage("success");
        log.info("Choose flight successfully of user id = {}",idOrder);
        return apiReponse;
    }
    // hủy cả chuyến
    @DeleteMapping("/{id}")
    public ApiReponse<Order> deleteOrder(@PathVariable Long id) {
        log.info("Start delete order of user id = {}",id);
        ApiReponse<Order> apiReponse = new ApiReponse<>();
        orderService.cancelOrder(id);
        apiReponse.setMessage("cancel success");
        log.info("Delete order successfully of user id = {}",id);
        return apiReponse;
    }
    // hủy máy bay
    @PutMapping("/cancelFlight/{id}")
    public ApiReponse<Order> cancelFlight(@PathVariable Long id) {
        log.info("Start cancel flight of user id = {}",id);
        ApiReponse<Order> apiReponse = new ApiReponse<>();
        Order order = orderService.cancelFlight(id);
        apiReponse.setData(order);
        apiReponse.setMessage("cancel success");
        log.info("Cancel flight successfully of user id = {}",id);
        return apiReponse;
    }
    @GetMapping("/{id}")
    public ApiReponse<List<Order>> getOrderById(@PathVariable Long id) {
        log.info("Start get order of user id = {}",id);
        ApiReponse<List<Order>> apiReponse = new ApiReponse<>();
        List<Order> orderList = orderService.getOrdersByUserId(id) ;
        apiReponse.setData(orderList);
        apiReponse.setMessage("success");
        log.info("Get order successfully of user id = {}",id);
        return apiReponse;
    }
    @GetMapping("/getAllOrder")
    public ApiReponse<PageResponse> getAllOrder(@RequestParam(defaultValue = "0",required = false) int pageNo,
                                                @RequestParam(defaultValue = "5",required = false) int pageSize) {
        log.info("Start get order of user id = {}",pageNo);
        try{
            PageResponse<?> orders = orderService.getAllOrders(pageNo,pageSize)  ;
            return new ApiReponse<>(1000,"get success",orders);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ApiReponse<>(7777,e.getMessage(),null);
        }
    }
}
