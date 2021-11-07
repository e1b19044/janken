package oit.is.z0584.kaizi.janken.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/lec02")
public class Lec02Controller {

  /**
   *
   * @param name
   * @param model
   * @return
   */
  @PostMapping
  public String lec02(@RequestParam String name,ModelMap model){
    model.addAttribute("login_user", name);
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
