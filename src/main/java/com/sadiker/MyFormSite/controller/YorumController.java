package com.sadiker.MyFormSite.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sadiker.MyFormSite.models.Konu;
import com.sadiker.MyFormSite.models.User;
import com.sadiker.MyFormSite.models.Yorum;
import com.sadiker.MyFormSite.repository.KonuRepository;
import com.sadiker.MyFormSite.repository.UserRepository;
import com.sadiker.MyFormSite.repository.YorumRepository;

@Controller
public class YorumController {
    public Long konuId;
    @Autowired
    KonuRepository konuRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    YorumRepository yorumRepository;
    

    @GetMapping("/createYorum/{id}")
    public String createYorum(ModelMap map,@PathVariable("id") Long id
    ) {
        konuId=id;
        Yorum yorum = new Yorum();
        map.addAttribute("yeniYorum", yorum);
        return "yorum/createYorum";
    }

    @PostMapping("/saveYorum")
    public String saveYorum(@ModelAttribute("yeniYorum") Yorum yorum,
            Principal principal
           ) {
        Konu konu = konuRepository.findById(konuId).get();
        User user = userRepository.findByUsername(principal.getName());
        yorum.setUser(user);
        yorum.setKonu(konu);
        yorumRepository.save(yorum);
        return "redirect:/showAllKonu";
    }

    @GetMapping("/deleteYorum/{id}")
    public String deleteYorum(@PathVariable("id") Long id ) {
        Yorum yorum = yorumRepository.findById(id).get();
        yorumRepository.delete(yorum);
        return "redirect:/showAllKonu";
    }

}
