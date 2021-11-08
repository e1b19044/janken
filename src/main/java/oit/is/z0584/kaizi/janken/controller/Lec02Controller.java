package oit.is.z0584.kaizi.janken.controller;

import java.security.Principal;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import oit.is.z0584.kaizi.janken.model.Entry;
import oit.is.z0584.kaizi.janken.model.User;
import oit.is.z0584.kaizi.janken.model.UserMapper;

@Controller
@RequestMapping("/lec02")
public class Lec02Controller {

  @Autowired
  private Entry entry;
  UserMapper userMapper;

    /**
   *
   * @param model
   * @param prin
   * @return
   */

  @GetMapping
  public String lec04(ModelMap model,Principal prin) {
    String loginUser = prin.getName();
    this.entry.addUser(loginUser);
    //ArrayList<User> users = userMapper.selectAll();
    model.addAttribute("login_user", loginUser);
    model.addAttribute("entry", this.entry);
    //model.addAttribute("users4", users);
    return "lec02.html";
  }

  @GetMapping("/lec04")
  public String sample52(ModelMap model,Principal prin) {
    String loginUser = prin.getName();
    this.entry.addUser(loginUser);
    model.addAttribute("login_user", loginUser);
    model.addAttribute("entry", this.entry);
    ArrayList<User> users = userMapper.selectAllUsers();
    model.addAttribute("users4", users);
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
