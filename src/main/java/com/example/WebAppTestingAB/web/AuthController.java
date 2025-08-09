package com.example.WebAppTestingAB.web;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    @GetMapping("/")
    public String welcome(){
        return "welcome";
    }

    @GetMapping("/signin")
    public String signinForm(){
        return "signin";
    }

    @PostMapping("/signin")
    public String signin(@RequestParam String handle, HttpSession session){
        session.setAttribute("user", handle.trim());
        if(session.getAttribute("variant")==null) {
        double r = Math.random();
        session.setAttribute("variant",r<0.6?"Alpha":"Beta");
        }
        return "redirect:/dashboard";
        }


}
