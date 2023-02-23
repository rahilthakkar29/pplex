package com.example.pragraplex.contoller;

import com.example.pragraplex.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@RequiredArgsConstructor
public class OrderController {
    private final OrderService service;

   /* public String showOrdersByCustomer(Model model){
        model.addAttribute("title","Showing orders");
        model.addAttribute("orders",service.findAll());

    }*/
}
