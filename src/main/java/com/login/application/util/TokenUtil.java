package com.login.application.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.auth0.jwt.interfaces.Verification;
import org.springframework.stereotype.Component;

@Component
public class TokenUtil {
    private static final String TOKEN_SECRET="Warlock";
    public String createToken(int id){
        try{
            //to set Algorithm
            Algorithm algorithm= Algorithm.HMAC256(TOKEN_SECRET);

            String token= JWT.create()
                    .withClaim("user_id",id)
                    .sign(algorithm);
            return token;
        } catch (JWTCreationException exception){
            exception.printStackTrace();
        } catch (IllegalArgumentException exception){
            exception.printStackTrace();
        }
        return null;
    }

    public int decodeToken(String token){
        int userid;
        //for Verification Algorithm
        Verification verification=null;
        try{
            verification=JWT.require(Algorithm.HMAC256(TOKEN_SECRET));
        } catch (IllegalArgumentException e){
            e.printStackTrace();
        }
        JWTVerifier jwtVerifier=verification.build();
        //to decode Token
        DecodedJWT decodedjwt=jwtVerifier.verify(token);

        Claim claim=decodedjwt.getClaim("user_id");
        userid=claim.asInt();
        return userid;
    }
}