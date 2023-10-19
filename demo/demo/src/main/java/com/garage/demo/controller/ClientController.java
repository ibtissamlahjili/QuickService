package com.garage.demo.controller;

import com.garage.demo.model.UserDtls;
import com.garage.demo.service.RDVService;
import com.garage.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.List;

@Controller
public class ClientController {


    @Autowired
    private UserService userService;

    @Autowired
    private RDVService rdvService;

    @GetMapping("/client")
    public String client(){
        return "monClient";
    }

    @GetMapping("/service")
    public String serviceC(){
        return "service";
    }

    @GetMapping("/bookingC")
    public String bookingC(){
        return "bookingC";
    }


    /*@GetMapping("/shop")
    public String shop(){
        return "shop";
    }*/

    @PostMapping("/createclient")
    public String createuser(@ModelAttribute UserDtls user, HttpSession session) {


        boolean f=userService.checkEmail(user.getEmail());

        if (f) {
            session.setAttribute("msg","Email Id already exist");
        }else {


            UserDtls userDtls =userService.createUser(user);

            if(userDtls!=null){
                session.setAttribute("msg","Register succesfully");
            }else {
                session.setAttribute("msg","Something error in server");
            }}
        return "redirect:/list_client";
    }

    @GetMapping("/list_client")
    public ModelAndView getAllRDV() {
        List<UserDtls> list=userService.getAllClients();

//		ModelAndView m=new ModelAndView();
//		m.setViewName("bookList");
//		m.addObject("book",list);
        return new ModelAndView("Clientlist","clientes",list);
    }

    @Transactional
    @RequestMapping("/deleteclient/{id}")
    public String deleteBook(@PathVariable("id")int id) {
        rdvService.deleteByUserId(id);
        userService.deleteUserById(id);

        return "redirect:/list_client";
    }
    @RequestMapping("/editclient/{id}")
    public String editBook(@PathVariable("id") int id, Model model) {
        UserDtls b=userService.getRDVById(id);
        model.addAttribute("clientes",b);
        return "ClientEdit";
    }


}
