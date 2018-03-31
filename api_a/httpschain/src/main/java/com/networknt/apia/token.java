package com.networknt.apia;

import com.networknt.security.JwtHelper;
import org.jose4j.jwt.JwtClaims;

import java.util.Arrays;
import java.util.List;

public class token {
    public static void main (String[] args) throws Exception {
        longLivedAPICJwt();
    }
    public static void longLivedAPICJwt() throws Exception {
        JwtClaims claims = getTestClaims("Steve", "EMPLOYEE", "2b5f158d-1e86-4e44-bf1d-ca6612af624d", Arrays.asList("api_a.r", "api_b.r", "api_c.r", "api_d.r","api_a.w", "api_b.w", "api_c.w", "api_d.w", "server.info.r"));
        claims.setExpirationTimeMinutesInTheFuture(5256000);
        String jwt = JwtHelper.getJwt(claims);
        System.out.println("***LongLived APIC JWT***: " + jwt);
    }
    private static JwtClaims getTestClaims(String userId, String userType, String clientId, List<String> scope) {
        JwtClaims claims = JwtHelper.getDefaultJwtClaims();
        claims.setClaim("user_id", userId);
        claims.setClaim("user_type", userType);
        claims.setClaim("client_id", clientId);
        claims.setStringListClaim("scope", scope); // multi-valued claims work too and will end up as a JSON array
        return claims;
    }
}
