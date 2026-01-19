
package com.example.rbacdemo.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(@AuthenticationPrincipal UserDetails user, Model model) {
        model.addAttribute("username", user != null ? user.getUsername() : "Guest");
        return "index";
    }

    @GetMapping("/login")
    public String login() { return "login"; }

    @GetMapping("/403")
    public String accessDenied() { return "403"; }
}
