package com.example.pragraplex.rest;

import com.example.pragraplex.dto.ErrorDto;
import com.example.pragraplex.entity.Order;
import com.example.pragraplex.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
@Slf4j
public class OrderApi {
    private final OrderService service;


    @PostMapping("/{id}/order")
   public ResponseEntity<Order> addOrder(@RequestHeader("X-COUNTRY") String country,@PathVariable("id") int customerId, @RequestBody Order order){
        Order serviceOrder=service.createOrder(customerId,order);
        log.info("Processing order for country {} got from header",country);
        if(country.equals("INDIA")){
            serviceOrder.setAmount(serviceOrder.getAmount()*1.18);
        }
            return ResponseEntity.status(HttpStatus.CREATED).header("X-CREATOR","Jismi").body(serviceOrder);
   }
   @GetMapping("/orders")
   public List<Order> getAll(){
       return service.findAll();
   }
   @GetMapping("/order/{id}")
    public ResponseEntity<?>getOrderById(@RequestParam Integer id){
       return ResponseEntity.status(HttpStatus.FOUND).body(service.findOneById(id));
    }

    @DeleteMapping("/order/delete/{id}")
    public void deleteOrderByUUID(@PathVariable Integer id){
       service.deleteOrderByUUID(id);
    }
    @PutMapping("/order/update")
    public Order updateOrder(@RequestBody Order order){
       return service.updateOrder(order);
    }
}
