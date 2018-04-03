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
        JwtClaims claims = getTestClaims("Steve", "EMPLOYEE", "0ce304c4-34db-494d-b6b4-e333893a1e16", Arrays.asList("api_a.r", "api_a.w"));
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
