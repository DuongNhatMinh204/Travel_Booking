package com.java.web_travel.service.impl;

import com.java.web_travel.entity.Flight;
import com.java.web_travel.entity.Hotel;
import com.java.web_travel.entity.Order;
import com.java.web_travel.entity.User;
import com.java.web_travel.enums.ErrorCode;
import com.java.web_travel.exception.AppException;
import com.java.web_travel.model.request.OrderDTO;
import com.java.web_travel.model.request.OrderHotelDTO;
import com.java.web_travel.model.response.PageResponse;
import com.java.web_travel.repository.*;
import com.java.web_travel.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private SearchRepository searchRepository;
    @Override
    public Order addOrder(OrderDTO orderDTO, Long userId) {
        Order order = new Order();
        if(!userRepository.existsById(userId)) {
            throw new AppException(ErrorCode.USER_NOT_EXISTS) ;
        }
        //kiểm tra xem thời gian check in có sau thời gian hiện tại không
        if(orderDTO.getCheckInDate().before(new Date())){
            throw new IllegalArgumentException("DATE_NOT_VALID") ;
        }
        // kiểm tra xem thời gian check in có trước thời gian check out không
        if(orderDTO.getCheckInDate().after(orderDTO.getCheckOutDate())){
            throw  new AppException(ErrorCode.DATE_TIME_NOT_VALID) ;
        }
        order.setDestination(orderDTO.getDestination());
        order.setNumberOfPeople(orderDTO.getNumberOfPeople());
        order.setCheckinDate(orderDTO.getCheckInDate());
        order.setCheckoutDate(orderDTO.getCheckOutDate());

        User user = userRepository.findById(userId).get();
        order.setUser(user);

        return orderRepository.save(order);
    }

    @Override
    public Order chooseHotel(Long orderId, Long hotelId, OrderHotelDTO orderHotelDTO) {
        // Tìm Hotel theo hotelId
        Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new AppException(ErrorCode.HOTEL_NOT_FOUND));

        // Tìm Order theo orderId
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new AppException(ErrorCode.ORDER_NOT_FOUND));
        if(orderHotelDTO.getStartHotel().before(order.getCheckinDate())){
            throw  new AppException(ErrorCode.DATE_INVALID);
        }

        order.setHotel(hotel);
        order.setStartHotel(orderHotelDTO.getStartHotel());
        order.setEndHotel(orderHotelDTO.getEndHotel());
        // tính tiền
        order.setTotalPrice(order.getTotalPrice()+order.getNumberOfPeople()*hotel.getHotelPrice());
        return orderRepository.save(order);
    }

    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order chooseFlight(Long orderId , Long flightId) {
        Flight flight = flightRepository.findById(flightId)
                .orElseThrow(()->new AppException(ErrorCode.NOT_EXISTS)) ;

        Order order = orderRepository.findById(orderId)
                .orElseThrow(()->new AppException(ErrorCode.ORDER_NOT_FOUND));

        if(flight.getCheckInDate().before(order.getCheckinDate())){
            throw new AppException(ErrorCode.NOT_VALID_FLIGHT_DATE) ;
        }

        flight.setSeatAvailable(flight.getNumberOfChairs()-order.getNumberOfPeople());// cập nhật số ghees thừa
        order.setFlight(flight);
        // tính tiền
        order.setTotalPrice(order.getTotalPrice()+order.getNumberOfPeople()*flight.getPrice());

        orderRepository.save(order);
        return order ;
    }

    @Override
    public void cancelOrder(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(()->new AppException(ErrorCode.ORDER_NOT_FOUND));
        orderRepository.delete(order);
        return ;
    }

    @Override
    public Order cancelFlight(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(()->new AppException(ErrorCode.ORDER_NOT_FOUND));
        Flight flight = order.getFlight();
        order.setFlight(null);
        orderRepository.save(order);
        return order ;
    }

    @Override
    public PageResponse getOrdersByUserId(Long userId , int pageNo , int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        User user = userRepository.findById(userId).get();
        Page<Order> orders = orderRepository.findByUser(user,pageable) ;

        return PageResponse.builder()
                .pageNo(pageNo)
                .pageSize(pageSize)
                .totalPages(orders.getTotalPages())
                .items(orders)
                .build();
    }

    @Override
    public PageResponse getAllOrders(int pageNo , int pageSize,String sortBy) {
        List<Sort.Order> sorts = new ArrayList<>();
        // xu ly sort by
        if(StringUtils.hasLength(sortBy)) {
            // orderDate:asc|desc
            Pattern  pattern = Pattern.compile("(\\w+?)(:)(.*)");
            Matcher matcher = pattern.matcher(sortBy);
            if(matcher.find()) {
                if(matcher.group(3).equalsIgnoreCase("asc")){
                    sorts.add(new Sort.Order(Sort.Direction.ASC,matcher.group(1)));
                }else {
                    sorts.add(new Sort.Order(Sort.Direction.DESC,matcher.group(1)));
                }
            }

        }
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sorts)); // phan trang co sap xep
        Page<Order> orders = orderRepository.findAll(pageable);

        return PageResponse.builder()
                .pageNo(pageNo)
                .pageSize(pageSize)
                .totalPages(orders.getTotalPages())
                .items(orders.getContent())
                .build();
    }

    @Override
    public PageResponse getAllOrdersByMultipleColumns(int pageNo, int pageSize, String... sorts) {
        List<Sort.Order> ordersSort = new ArrayList<>();
        for (String sortBy : sorts) {
            // orderDate:asc|desc
            Pattern  pattern = Pattern.compile("(\\w+?)(:)(.*)");
            Matcher matcher = pattern.matcher(sortBy);
            if(matcher.find()) {
                if(matcher.group(3).equalsIgnoreCase("asc")){
                    ordersSort.add(new Sort.Order(Sort.Direction.ASC,matcher.group(1)));
                }else {
                    ordersSort.add(new Sort.Order(Sort.Direction.DESC,matcher.group(1)));
                }
            }
        }

        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(ordersSort)); // phan trang co sap xep
        Page<Order> orders = orderRepository.findAll(pageable);

        return PageResponse.builder()
                .pageNo(pageNo)
                .pageSize(pageSize)
                .totalPages(orders.getTotalPages())
                .items(orders.getContent())
                .build();
    }

    @Override
    public PageResponse getAllOrderWithSortByMultipleColumsAndSearch(int pageNo, int pageSize, String search, String sortBy) {
        return searchRepository.getAllOrderWithSortByMultipleColumsAndSearch(pageNo,pageSize,search,sortBy);
    }

    @Override
    public PageResponse advanceSearchByCriteria(int pageNo, int pageSize, String sortBy, String... search) {
        return searchRepository.advanceSearchOrder(pageNo,pageSize,sortBy,search);
    }

}
