package com.sadiker.MyFormSite.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sadiker.MyFormSite.models.Konu;
import com.sadiker.MyFormSite.models.Yorum;
import com.sadiker.MyFormSite.repository.KonuRepository;
import com.sadiker.MyFormSite.repository.UserRepository;
import com.sadiker.MyFormSite.repository.YorumRepository;

@Controller
public class KonuController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    KonuRepository konuRepository;

    @Autowired
    YorumRepository yorumRepository;

    @GetMapping("/showAllKonu")
    public String showAll(ModelMap map) {
        List<Konu> konular = konuRepository.findAll();
        map.addAttribute("konular", konular);
        return "/konu/showAllKonu";
    }

    @GetMapping("/createKonu")
    public String createKonu(ModelMap map) {
        Konu konu = new Konu();
        map.addAttribute("yeniKonu", konu);
        return "/konu/createKonu";
    }

    @PostMapping("/saveKonu")
    public String saveKonu(@ModelAttribute Konu konu, Principal principal) {
        konu.setUser(userRepository.findByUsername(principal.getName()));
        konuRepository.save(konu);
        return "redirect:/showAllKonu";
    }

    @GetMapping("/showKonu/{id}")
    public String showOneKonu(ModelMap map,
            @PathVariable(required = false, value = "id") Long id) {
        Konu konu = konuRepository.findById(id).get();
        List<Yorum> yorumlar = konu.getYorumlar();
        map.addAttribute("yorumlar", yorumlar);
        String konuAdi = konu.getName();
        map.addAttribute("konuAdi", konuAdi);
        return "yorum/showAllYorumByKonu";
    }

    @GetMapping("/deleteKonu/{id}")
    public String deleteKonu(@PathVariable("id") Long id) {
            Konu konu = konuRepository.findById(id).get();
            konuRepository.delete(konu);
            return "redirect:/showAllKonu";
       
       
    }

}
