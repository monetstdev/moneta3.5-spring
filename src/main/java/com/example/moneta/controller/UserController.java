package com.example.moneta.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @GetMapping({"/", "/top"})
    public String top(Model model) {
        model.addAttribute("login_id", "");
        model.addAttribute("password", "");
        model.addAttribute("content", "users/top");
        return "users/top"; // templates/users/top.html を表示
    }

    @PostMapping("/login")
    public String login(
        @RequestParam("login_id") String loginId,
        @RequestParam("password") String password,
        HttpSession session,
        Model model
    ) {
        // ★ 画面遷移テスト用に入力無視・testユーザー固定
        session.setAttribute("user_id", "test");
        return "redirect:/mypage";
    }

    @GetMapping("/mypage")
    public String mypage(Model model) {
        Map<String, Object> user = new HashMap<>();
        user.put("kanjiName", "画面てすと");
        model.addAttribute("user", user);
        return "users/mypage";
    }

    @GetMapping("/kouza")
    public String kouza(Model model) {
        List<Map<String, Object>> kouzaList = new ArrayList<>();

        // ★ ダミーデータ複数件
        kouzaList.add(Map.of("id", 1, "bank_bangou", "0001", "shiten_bangou", "001", "bangou", "1035", "zandaka", 2001));
        kouzaList.add(Map.of("id", 2, "bank_bangou", "0001", "shiten_bangou", "002", "bangou", "9294", "zandaka", -1050));
        kouzaList.add(Map.of("id", 3, "bank_bangou", "0001", "shiten_bangou", "003", "bangou", "8660", "zandaka", 0));
        kouzaList.add(Map.of("id", 4, "bank_bangou", "0001", "shiten_bangou", "002", "bangou", "4733", "zandaka", 0));
        kouzaList.add(Map.of("id", 5, "bank_bangou", "0001", "shiten_bangou", "002", "bangou", "2974", "zandaka", 2000));
        kouzaList.add(Map.of("id", 6, "bank_bangou", "0001", "shiten_bangou", "002", "bangou", "0165", "zandaka", -2376));

        // Bank, Shiten 定義（簡易マップ）
        Map<String, Map<String, String>> Bank = Map.of(
            "0001", Map.of("kanji_name", "もねた銀行")
        );

        Map<String, Map<String, String>> Shiten = Map.of(
            "001", Map.of("kanji_name", "ふたご座支店"),
            "002", Map.of("kanji_name", "れちくる座支店"),
            "003", Map.of("kanji_name", "てんびん座支店")
        );

        model.addAttribute("kouzaList", kouzaList);
        model.addAttribute("Bank", Bank);
        model.addAttribute("Shiten", Shiten);
        model.addAttribute("content", "users/kouza");

        return "users/kouza";
    }

    @GetMapping("/logoff")
    public String logoff(Model model) {
        return "users/logoff";
    }

    @GetMapping("/users/new")
    public String newUser(Model model) {
        return "users/new";
    }

    @PostMapping("/users")
    public String createUser(Model model) {
        return "users/kekka";
    }
}
