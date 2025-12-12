package com.hms.GatewayMS.filter;



import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class TokenFilter extends AbstractGatewayFilterFactory<TokenFilter.Config>{

    private static final String SECRET="3684aa168f9f88b051f1b9f4e16c83e949061f5dda9ca6597988464d1cc8656af360c14f461862f3bccd772e0110c51d810edb65361718f493c5a5ae2dec7360"; 


    public TokenFilter(){
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config){
        return (exchange,chain) ->{
            String path=exchange.getRequest().getPath().toString();
            if(path.equals("/user/login")|| path.equals("/user/register")){
                return chain.filter(exchange);
            }
            HttpHeaders header=exchange.getRequest().getHeaders();
            if(!header.containsKey(HttpHeaders.AUTHORIZATION)){
                throw new RuntimeException("Authorization headr is missing");
            }

            String authHeader=header.getFirst(HttpHeaders.AUTHORIZATION);
            if(authHeader ==  null || !authHeader.startsWith("Bearer")){
                throw new RuntimeException("Authorization header is invalid");
            }
            String token=authHeader.substring(7);
            try{
                
                Claims claims = Jwts.parser()
                        .setSigningKey(SECRET)
                        .build()
                        .parseClaimsJws(token)
                        .getBody();
               
            }catch(Exception ex){
                throw new RuntimeException("Token is invaild");
            }
             return chain.filter(exchange);
        };
    }

    public static class Config { }
}
