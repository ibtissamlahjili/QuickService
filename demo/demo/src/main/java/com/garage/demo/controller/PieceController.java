
package com.garage.demo.controller;

import com.garage.demo.model.Piece;
import com.garage.demo.model.PieceTest;
import com.garage.demo.repository.PieceRepository;
import com.garage.demo.repository.uploadRepository;
import com.garage.demo.service.PieceService;
import com.garage.demo.service.PieceTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class PieceController {
    @Autowired
    private PieceRepository pieceRepository;
    @Autowired
    private PieceService pieceService;

    @Autowired
    private uploadRepository pieceRepositoryT;
    @Autowired
    private PieceTestService pieceServiceT;



    /*@GetMapping("/ap")
    public String ap(){
        return "PieceAjout";
    }

*/

    /*@PostMapping("/upload")
    public String uploadpiece(@RequestParam("file") MultipartFile file,
                              @RequestParam("name") String name,
                              @RequestParam("description") String description,
                              @RequestParam("price") double price) {
        // Vérifiez si le fichier est vide
        if (file.isEmpty()) {
            // Gérer le cas où aucun fichier n'a été sélectionné
            return "redirect:/error";
        }

        // Créez une instance de l'entité Piece
        Piece piece = new Piece();
        piece.setName(name);
        piece.setDescription(description);
        piece.setPrice(price);
        piece.setImage(file.getOriginalFilename());

        // Enregistrez l'image de la pièce dans la base de données
        pieceRepository.save(piece);

        // Redirigez vers une page de succès
        return "redirect:/list_piece";
    }*/
    /*@PostMapping("/upload")

    public String addBook(@ModelAttribute Piece b) {
        pieceService.savePiece(b);
        return "redirect:/list_piece";
    }*/

    @PostMapping("/upload")
    public String addBook(@ModelAttribute Piece b, @RequestParam("file") MultipartFile imageFile) {
        if (!imageFile.isEmpty()) {
            try {
                byte[] imageBytes = imageFile.getBytes();
                b.setImage(imageBytes);
            } catch (IOException e) {
                // Gérer les exceptions liées à la lecture du fichier
                e.printStackTrace();
            }
        }

        pieceService.savePiece(b);
        return "redirect:/list_piece";
    }

    /*@GetMapping("/list_piece")
    public ModelAndView getPieces() {
        List<Piece> list = pieceService.getAllPieces();
        List<Piece> pieceDTOList = new ArrayList<>();

        for (Piece piece : list) {
            Piece pieceDTO = new Piece();
            pieceDTO.setId(piece.getId());
            pieceDTO.setName(piece.getName());
            pieceDTO.setDescription(piece.getDescription());
            pieceDTO.setPrice(piece.getPrice());

            // Vérifier si l'image n'est pas nulle avant de l'encoder en Base64
            if (piece.getImage() != null) {
                pieceDTO.setImage(Base64.getEncoder().encode(piece.getImage()));
            }

            pieceDTOList.add(pieceDTO);
        }

        ModelAndView modelAndView = new ModelAndView("PieceList");
        modelAndView.addObject("pieces", pieceDTOList);

        return modelAndView;
    }*/
    @RequestMapping("/deletePiece/{id}")
    public String deletePiece(@PathVariable("id")long id) {
        pieceServiceT.deletePieceById(id);
        return "redirect:/list_piece";
    }
    @RequestMapping("/editPiece/{id}")
    public String editPiece(@PathVariable("id") long id, Model model) {
        PieceTest b=pieceServiceT.getPieceById(id);
        model.addAttribute("pieces",b);
        return "PieceEdit";
    }







    //pour le client

    /*@GetMapping("/shop")
    public String showShopPage(Model model) {
        Iterable<Piece> pieces = pieceRepository.findAll();
        model.addAttribute("pieces", pieces);
        return "shop";
    }*/




    //TEST test test shop

}
