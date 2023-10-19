package com.garage.demo.controller;

import com.garage.demo.model.UserDtls;
import com.garage.demo.repository.UserRepository;
import com.garage.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private UserService userService;

    @ModelAttribute
    private void userDetails(Model m, Principal p) {
        String email = p.getName();
        UserDtls user = userRepo.findByEmail(email);

        m.addAttribute("user", user);

    }


   @GetMapping("/")
   public String home(@ModelAttribute("user") UserDtls user) {

       if (user.getRol().equals("ADMIN")) {
           return "Admin";
       } else if (user.getRol().equals("CLIENT")) {
           return "monClient";
       }else if (user.getRol().equals("SPECIALISTE")){
           return "specialiste/homeS";
       }
       else {
           return "login";
       }
   }





}
