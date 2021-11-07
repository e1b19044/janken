package oit.is.z0584.kaizi.janken.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import oit.is.z0584.kaizi.janken.model.Entry;

@Controller
@RequestMapping("/lec02")
public class Lec02Controller {

  @Autowired
  private Entry entry;

    /**
   *
   * @param model Thymeleafにわたすデータを保持するオブジェクト
   * @param prin  ログインユーザ情報が保持されるオブジェクト
   * @return
   */
  @GetMapping
  public String lec03(ModelMap model, Principal prin){
    String loginUser = prin.getName(); // ログインユーザ情報
    this.entry.addUser(loginUser);
    model.addAttribute("login_user", loginUser);
    model.addAttribute("entry", this.entry);
    return "lec02.html";
  }

    /**
   *
   * @param hand
   * @param model
   * @return
   */
  @GetMapping("janken")
  public String lec02_2(@RequestParam String hand,ModelMap model){
    String result = "a";
    String cpuHand = "Gu";
    if(hand.equals("Gu")){
      result = "Drow";
    }else if(hand.equals("Choki")){
      result = "You Lose...";
    }else if(hand.equals("Pa")){
      result = "You Win!";
    }
    model.addAttribute("Yourhand", hand);
    model.addAttribute("CPUhand", cpuHand);
    model.addAttribute("Result", result);
    return "lec02.html";
  }
}
