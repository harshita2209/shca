package com.hms.User.jwt;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {

    private static final Long JWT_TOKEN_VALIDITY=5*60*60L;

    private static final String SECRET="3684aa168f9f88b051f1b9f4e16c83e949061f5dda9ca6597988464d1cc8656af360c14f461862f3bccd772e0110c51d810edb65361718f493c5a5ae2dec7360"; 

    
    public String genetateToken(UserDetails userDetails){
        Map<String, Object> claims=new  HashMap<>();
        CustomUserDetail user=(CustomUserDetail) userDetails;
        claims.put("id",user.getId());
        claims.put("email", user.getEmail());
        claims.put("role", user.getRole());
        claims.put("name", user.getName());
        return deGenerateToken(claims, user.getUsername());
    }

    @SuppressWarnings("deprecation")
    public String deGenerateToken(Map<String,Object> claims,String subject){
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(new Date(System.currentTimeMillis()+JWT_TOKEN_VALIDITY*1000)).signWith(SignatureAlgorithm.HS512,SECRET).compact();
    }


    
}
