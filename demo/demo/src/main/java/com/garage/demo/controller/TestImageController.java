package com.garage.demo.controller;

import com.garage.demo.config.CustomUserDetails;
import com.garage.demo.model.MyCommande;
import com.garage.demo.model.PieceTest;
import com.garage.demo.repository.uploadRepository;
import com.garage.demo.service.MyCommandeService;
import com.garage.demo.service.PieceTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Controller
public class TestImageController {

    @Autowired
    private uploadRepository uploadRepo;

    @Autowired
    private PieceTestService pieceService;

    @Autowired
    private MyCommandeService myPieceService;

    @GetMapping("/gestpiece")
    public String gestpiece() {
        return "AjoutPieceTest";
    }


    @GetMapping("/shop")
    public String index(Model m) {

        List<PieceTest> list = uploadRepo.findAll();

        m.addAttribute("list", list);

        return "shopT";
    }

    @PostMapping("/imageUpload")
    public String imageUpload(@ModelAttribute PieceTest b,@RequestParam MultipartFile img, HttpSession session) {

        PieceTest im = new PieceTest();
        im.setImageName(img.getOriginalFilename());
        im.setName(b.getName());
        im.setDescription(b.getDescription());
        im.setPrice(b.getPrice());


        PieceTest uploadImg = uploadRepo.save(im);


        if (uploadImg != null) {
            try {

                File saveFile = new ClassPathResource("static/img").getFile();

                Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + img.getOriginalFilename());
                //System.out.println(path);
                Files.copy(img.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        session.setAttribute("msg", "Image Upload Sucessfully");

        return "redirect:/list_piece";
    }

    @GetMapping("/list_piece")
    public String shopAdmin(Model m) {

        List<PieceTest> list = uploadRepo.findAll();

        m.addAttribute("list", list);

        return "PieceList";
    }


    @GetMapping("/my_Commade")
    public String getMyBooks(Model model) {
        List<MyCommande> list = myPieceService.getAllMyBooks();
        model.addAttribute("pieces", list);
        return "MyCommande";
    }

   /* @RequestMapping("/mylist/{id}")
    public String getMyList(@PathVariable("id") int id) {
        PieceTest b=pieceService.getPieceById(id);
        MyCommande mb=new MyCommande(b.getId(),b.getName(),b.getDescription(),b.getPrice(),b.getImageName());
        myPieceService.saveMyBooks(mb);
        return "redirect:/my_Commade";
    }*/

    @RequestMapping("/mylist/{id}")
    public String addToCart(@PathVariable("id") int id, Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            Object principal = authentication.getPrincipal();

            if (principal instanceof CustomUserDetails) {
                CustomUserDetails customUserDetails = (CustomUserDetails) principal;

                PieceTest piece = pieceService.getPieceById(id);

                MyCommande commande = new MyCommande();
                commande.setName(piece.getName());
                commande.setDescription(piece.getDescription());
                commande.setPrice(piece.getPrice());
                commande.setImageName(piece.getImageName());
                commande.setUser(customUserDetails.getUserDtls());

                myPieceService.saveMyBooks(commande);
            }
        }

        return "redirect:/my_Commade";
    }










    @RequestMapping("/deleteMyList/{id}")
    public String deleteMyList(@PathVariable("id") int id) {
        myPieceService.deleteById(id);
        return "redirect:/my_Commade";
    }

}
