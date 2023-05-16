package com.per.msa_login.login;

import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("loginService")
public class LoginService {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Resource(name = "loginDAO")
    private LoginDAO loginDAO;

    public Map<String, Object> selectLoginProccess(LoginDTO dto) throws Exception {
        return loginDAO.selectLoginProccess(dto);
    }
}
