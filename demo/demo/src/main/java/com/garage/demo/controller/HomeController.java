package com.garage.demo.controller;

import com.garage.demo.model.UserDtls;
import com.garage.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
@Controller
public class HomeController {

/*
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }
*/

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index(){
        return "index";
    }
    @GetMapping("/signin")
    public String login(){
        return "login";
    }
    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/createUser")
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
        return "redirect:/signin";
    }
    /*@PostMapping("/ajoutpiece")
    public String ajoutpiece(@ModelAttribute Piece piece, HttpSession session) {


        boolean f=pieceService.checkNom(piece.getNom());

        if (f) {
            session.setAttribute("msg","Nom Id already exist");
        }else {


            Piece piece1 =pieceService.ajoutpiece(piece);

            if(piece1!=null){
                session.setAttribute("msg","Ajout succesfully");
            }else {
                session.setAttribute("msg","Something error in server");
            }}
        return "redirect:/gestpiece";
    }*/

    @GetMapping("/logout")
    public String logout(){
        return "index";
    }
}
