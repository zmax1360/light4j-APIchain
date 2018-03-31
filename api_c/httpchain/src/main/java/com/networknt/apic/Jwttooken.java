package com.networknt.apic;

import com.networknt.security.JwtHelper;
import org.jose4j.jwt.JwtClaims;

import java.util.Arrays;
import java.util.List;

public class Jwttooken {

    public static void main(String[] rgs) throws Exception {

        longLivedAPICJwt();
    }
    public static void longLivedAPICJwt() throws Exception {
        JwtClaims claims = getTestClaims("Steve", "EMPLOYEE", "f7d42348-c647-4efb-a52d-4c5787421e72", Arrays.asList("api_a.w", "api_b.w", "api_c.w", "api_d.w", "server.info.r"));
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
