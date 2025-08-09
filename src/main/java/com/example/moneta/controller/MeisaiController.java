package com.example.moneta.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/meisai")
public class MeisaiController {

	@GetMapping("/{kouza_id}")
	public String index(@PathVariable("kouza_id") int kouzaId, Model model) {
	    // 仮データ（口座情報）
	    Map<String, Object> kouza = new HashMap<>();
	    kouza.put("bank_bangou", "0001");
	    kouza.put("shiten_bangou", "001");
	    kouza.put("bangou", "1035");
	    kouza.put("zandaka", 2001);
	    model.addAttribute("kouza", kouza);

	    // 仮データ（明細リスト）
	    List<Map<String, Object>> meisaiList = new ArrayList<>();
	    meisaiList.add(Map.of(
	        "created_at", "2024-08-26",
	        "kubun", "入金",
	        "kingaku", 0,
	        "saishozandaka", 0,
	        "tekiyou", "新規開設"
	    ));
	    meisaiList.add(Map.of(
	        "created_at", "2024-08-26",
	        "kubun", "出金",
	        "kingaku", 1000,
	        "saishozandaka", -2000,
	        "tekiyou", "てすとへの振込"
	    ));
	    meisaiList.add(Map.of(
	        "created_at", "2024-08-26",
	        "kubun", "出金",
	        "kingaku", 50,
	        "saishozandaka", -1050,
	        "tekiyou", "貸越利息"
	    ));
	    model.addAttribute("meisai", meisaiList);

	    // 定数マップ
	    Map<String, Map<String, String>> Bank = Map.of("0001", Map.of("kanji_name", "もねた銀行"));
	    Map<String, Map<String, String>> Shiten = Map.of("001", Map.of("kanji_name", "本店"));
	    model.addAttribute("Bank", Bank);
	    model.addAttribute("Shiten", Shiten);

	    model.addAttribute("content", "meisai/index");
        return "meisai/index";
    }
}
