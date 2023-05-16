package com.per.msa_login.login;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.per.msa_login.auth.AuthService;

@Controller
public class LoginController {

    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    @Resource(name = "loginService")
    LoginService loginService;

    @Resource(name = "authService")
    AuthService authService;

    @RequestMapping("/api/loginProcess.do")
    public String loginProcess(LoginDTO dto, HttpServletResponse response) throws Exception {

        // ObjectMapper objectMapper = new ObjectMapper();
        // Map mapResult = objectMapper.convertValue(dto, Map.class);
        // Map<String, Object> result = authService.selectLoginProccess(mapResult);

        return "testing";
    }
}
