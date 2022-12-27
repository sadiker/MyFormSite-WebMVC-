package com.sadiker.MyFormSite.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.sadiker.MyFormSite.models.Konu;
import com.sadiker.MyFormSite.models.Yorum;
import com.sadiker.MyFormSite.repository.KonuRepository;
import com.sadiker.MyFormSite.repository.YorumRepository;

@Controller
public class HomeController {


    //github yorum satırı
    @Autowired
    KonuRepository konuRepository;

    @Autowired
    YorumRepository yorumRepository;

    @GetMapping(path = { "/", "", "/home" })
    public String showAll(ModelMap map) {

        List<Konu> tumkonular = konuRepository.findAll();
        List<Konu> konular = new ArrayList<Konu>();
        forRandomMethodKonu(tumkonular, konular);
        map.addAttribute("konular", konular);

        List<Yorum> tumyorumlar = yorumRepository.findAll();
        List<Yorum> yorumlar = new ArrayList<Yorum>();
        forRandomMethodYorum(tumyorumlar, yorumlar);
        map.addAttribute("yorumlar", yorumlar);
        return "home";
    }

    public static void forRandomMethodYorum(List<Yorum> tumyorumlar, List<Yorum> yorumlar) {
        Random rand = new Random();
        if (tumyorumlar.size() >= 4) {
            int r1 = rand.nextInt(0, tumyorumlar.size());
            int r2 = rand.nextInt(0, tumyorumlar.size());
            int r3 = rand.nextInt(0, tumyorumlar.size());
            int r4 = rand.nextInt(0, tumyorumlar.size());

            yorumlar.add(tumyorumlar.get(r4));
            yorumlar.add(tumyorumlar.get(r3));
            yorumlar.add(tumyorumlar.get(r2));
            yorumlar.add(tumyorumlar.get(r1));
        }

    }

    public static void forRandomMethodKonu(List<Konu> tumkonular, List<Konu> konular) {

        Random rand = new Random();
        if (tumkonular.size() >= 3) {
            int r1 = rand.nextInt(0, tumkonular.size());
            int r2 = rand.nextInt(0, tumkonular.size());
            int r3 = rand.nextInt(0, tumkonular.size());

            konular.add(tumkonular.get(r3));
            konular.add(tumkonular.get(r2));
            konular.add(tumkonular.get(r1));
        }

    }

}
