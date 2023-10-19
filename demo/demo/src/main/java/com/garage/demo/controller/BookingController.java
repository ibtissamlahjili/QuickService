package com.garage.demo.controller;

import com.garage.demo.model.RDV;
import com.garage.demo.model.UserDtls;
import com.garage.demo.repository.UserRepository;
import com.garage.demo.service.RDVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.beans.PropertyEditorSupport;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
public class BookingController {
    private RDVService rdvService;

    @Autowired
    private UserRepository userDtlsRepository;

    @Autowired
    public BookingController(RDVService rdvService) {
        this.rdvService = rdvService;
    }

    @GetMapping("/booking")
    public String showBookingForm(Model model) {
        model.addAttribute("rdv", new RDV());
        return "booking";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    Date parsedDate = new Date(dateFormat.parse(text).getTime());
                    setValue(parsedDate);
                } catch (ParseException e) {
                    setValue(null);
                }
            }
        });
    }
    @PostMapping("/booking")
    public String processBookingForm(@ModelAttribute("rdv") RDV rdv, @RequestParam("email") String email , HttpSession session) {
        // Récupérez l'utilisateur à partir de l'identifiant ou créez un nouvel utilisateur
        UserDtls user1 = userDtlsRepository.findByEmail(email);

        // Associez l'utilisateur à l'objet RDV
        rdv.setUser(user1);


        try {
            // Sauvegardez l'objet RDV
            rdvService.saveRDV(rdv);
            return "redirect:/rdvList";
        } catch (RuntimeException e) {
            // Le RDV existe déjà, définissez l'attribut d'erreur dans le modèle
            session.setAttribute("msg", "Le rendez-vous existe déjà !");
            return "redirect:/gestrdv";
        }

    }


    @GetMapping("/rdvList")
    public ModelAndView getAllRDV() {
        List<RDV> list=rdvService.getAllRDV();

//		ModelAndView m=new ModelAndView();
//		m.setViewName("bookList");
//		m.addObject("book",list);
        return new ModelAndView("RdvList","RDV",list);
    }

    @RequestMapping("/deleteRDV/{id}")
    public String deleteBook(@PathVariable("id")int id) {
        rdvService.deleteById(id);
        return "redirect:/rdvList";
    }
    @RequestMapping("/editRDV/{id}")
    public String editBook(@PathVariable("id") int id, Model model) {
        RDV b=rdvService.getRDVById(id);
        model.addAttribute("RDV",b);
        return "RDVEdit";
    }

//pour Client


    @GetMapping("/rendez")
    public String showRendezForm(Model model) {
        model.addAttribute("rdv", new RDV());
        return "bookingC";
    }
    @PostMapping("/rendez")
    public String booking(@ModelAttribute("rdv") RDV rdv, @RequestParam("email") String email , HttpSession session) {
    // Récupérez l'utilisateur à partir de l'identifiant ou créez un nouvel utilisateur
    UserDtls user1 = userDtlsRepository.findByEmail(email);

    // Associez l'utilisateur à l'objet RDV
    rdv.setUser(user1);


    try {
        // Sauvegardez l'objet RDV
        rdvService.saveRDV(rdv);
        return "redirect:/bookingC";
    } catch (RuntimeException e) {
        // Le RDV existe déjà, définissez l'attribut d'erreur dans le modèle
        session.setAttribute("msg", "Le rendez-vous existe déjà !");
        return "redirect:/bookingC";
    }

}


}

