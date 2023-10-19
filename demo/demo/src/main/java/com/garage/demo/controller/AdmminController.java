package com.garage.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdmminController {


    @GetMapping("/Admin")
    public String gesthomeAdmin(){
        return "Admin";
    }
    @GetMapping("/gestclient")
    public String gestclient(){
        return "GClient";
    }
    @GetMapping("/gestcommande")
    public String gestcommande(){
        return "GCommande";
    }
    @GetMapping("/gestrdv")
    public String gestrdv(){
        return "GRdv";
    }

    @GetMapping("/gestservice")
    public String gestsevice(){
        return "GService";
    }

   /* @GetMapping("/gestpiece")
    public String gestpiece(){
        return "GPiece";
    }*/
   /* @GetMapping("/rdvList")
    public String rdvList(){
        return "RdvList";
    }
*///
   /* @GetMapping("/HomerdvList")
    public String rdvListHome(){
        return "Admin";
    }*/
}
