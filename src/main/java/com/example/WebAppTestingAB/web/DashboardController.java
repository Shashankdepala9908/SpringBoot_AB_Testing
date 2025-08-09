package com.example.WebAppTestingAB.web;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model){
    Object user = session.getAttribute("user");
        if(user == null) return "/signin";
        String variant = (String) session.getAttribute("variant");
        model.addAttribute("user", user);
        if(variant.equalsIgnoreCase("Alpha"))  return "Alpha" ;
        return "Beta";
    }
}
