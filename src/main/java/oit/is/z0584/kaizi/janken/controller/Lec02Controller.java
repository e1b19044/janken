package oit.is.z0584.kaizi.janken.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class Lec02Controller {

  /**
   *
   * @param kakeru1
   * @param kakeru2
   * @param model
   * @return
   */
  @PostMapping("step1")
  public String lec02(@RequestParam String name,ModelMap model){
    model.addAttribute("login_user", name);
    return "lec02.html";
  }
}
