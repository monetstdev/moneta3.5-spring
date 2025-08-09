package com.example.moneta.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/futsu_yokin")
public class FutsuYokinController {

    @GetMapping("/new")
    public String newFutsuYokin(Model model) {
        Map<String, Map<String, String>> shitens = new LinkedHashMap<>();

        // ★ダミーデータ（支店番号001、ふたご座支店）
        Map<String, String> shitenDetails = new LinkedHashMap<>();
        shitenDetails.put("kanji_name", "ふたご座支店");

        shitens.put("001", shitenDetails);

        // モデルに渡す
        model.addAttribute("shitens", shitens);
        model.addAttribute("content", "futsu_yokin/new");

        return "futsu_yokin/new";
    }

    @PostMapping
    public String createAccount(Model model) {
        // ダミーデータをセット（kekkaと同様）
        Map<String, Object> kouza = new HashMap<>();
        kouza.put("bank_bangou", "0001");
        kouza.put("shiten_bangou", "001");
        kouza.put("bangou", "1234567");
        kouza.put("zandaka", 500000);

        Map<String, Map<String, String>> Bank = new HashMap<>();
        Map<String, String> bankInfo = new HashMap<>();
        bankInfo.put("kanji_name", "もねた銀行");
        Bank.put("0001", bankInfo);

        Map<String, Map<String, String>> Shiten = new HashMap<>();
        Map<String, String> shitenInfo = new HashMap<>();
        shitenInfo.put("kanji_name", "渋谷支店");
        Shiten.put("001", shitenInfo);

        model.addAttribute("kouza", kouza);
        model.addAttribute("Bank", Bank);
        model.addAttribute("Shiten", Shiten);

        return "futsu_yokin/kekka";
    }

    @GetMapping("/kekka/{id}")
    public String kekka(Model model) {
        return "futsu_yokin/kekka";
    }

}
