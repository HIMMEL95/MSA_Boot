package com.per.msa_login.auth;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.per.msa_login.bizservice.BizApiClient;
import com.per.msa_login.bizservice.BizConstants;
import com.per.msa_login.bizservice.BizServiceInfo;

@Service("authService")
public class AuthService {
    @Autowired
    private BizApiClient bizClient;
    private BizServiceInfo authServiceInfo;

    public AuthService() {
        authServiceInfo = new BizServiceInfo(BizConstants.AUTH, "AuthService");
    }

    public Map<String, Object> selectLoginProccess(Map<String, Object> map) throws Exception {
        return bizClient.requestApi(authServiceInfo, "selectLoginProccess", map, Map.class);
    }

    public List<Map<String, Object>> selectAuthority(Map<String, Object> map) throws Exception {
        return bizClient.requestApi(authServiceInfo, "selectAuthority", map, List.class);
    }

    public Map<String, Object> regenAccessToken(String refreshToken) throws Exception {
        return bizClient.requestApi(authServiceInfo, "regenAccessToken", refreshToken, Map.class);
    }

    public int updatePassword(Map<String, Object> map) throws Exception {
        return bizClient.requestApi(authServiceInfo, "updatePassword", map, int.class);
    }

    // 로그인 히스토리
    public void insertLoginHistory(Map<String, Object> map) throws Exception {
        bizClient.requestApi(authServiceInfo, "insertLoginHistory", map);
    }
}
