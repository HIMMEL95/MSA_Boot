package com.per.msa.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    
    @PostMapping("/api/loginProcess")
    public String process() throws Exception {
        System.out.println("etets");
        return "tetsinfg";
    }
}
