package com.per.msa_login.login;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.per.msa_login.datasource.AbstractDAO;

@Repository("loginDAO")
public class LoginDAO extends AbstractDAO {

    @SuppressWarnings("unchecked")
    public Map<String, Object> selectLoginProccess(LoginDTO dto) throws Exception {
        return (Map<String, Object>) selectOne("login.selectLoginProccess", dto);
    }

}
