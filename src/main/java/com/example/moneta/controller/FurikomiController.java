package com.example.moneta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/furikomi")
public class FurikomiController {

    @GetMapping("/select_moto_kouza")
    public String selectMotoKouza(Model model) {
        return "furikomi/select_moto_kouza";
    }

    @PostMapping("/set_moto_kouza")
    public String setMotoKouza(Model model) {
        return "redirect:/furikomi/select_bank";
    }

    @GetMapping("/select_bank")
    public String selectBank(Model model) {
        return "furikomi/select_bank";
    }

    @PostMapping("/set_bank")
    public String setBank(Model model) {
        return "redirect:/furikomi/select_shiten";
    }

    @GetMapping("/select_shiten")
    public String selectShiten(Model model) {
        return "furikomi/select_shiten";
    }

    @PostMapping("/set_shiten")
    public String setShiten(Model model) {
        return "redirect:/furikomi/select_saki_kouza";
    }

    @GetMapping("/select_saki_kouza")
    public String selectSakiKouza(Model model) {
        return "furikomi/select_saki_kouza";
    }

    @PostMapping("/set_saki_kouza")
    public String setSakiKouza(Model model) {
        return "redirect:/furikomi/input_kingaku";
    }

    @GetMapping("/input_kingaku")
    public String inputKingaku(Model model) {
        return "furikomi/input_kingaku";
    }

    @PostMapping("/set_kingaku")
    public String setKingaku(Model model) {
        return "redirect:/furikomi/kakunin";
    }

    @GetMapping("/kakunin")
    public String kakunin(Model model) {
        return "furikomi/kakunin";
    }

    @PostMapping("/jikkou")
    public String jikkou(Model model) {
        return "redirect:/furikomi/kekka";
    }

    @GetMapping("/kekka")
    public String kekka(Model model) {
        return "furikomi/kekka";
    }
}
