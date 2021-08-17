package com.xxxx.server.config.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Jwt Token工具类
 */
@Component
public class JwtTokenUtil {
    //荷载claim的名称
    private static final String CLAIM_KEY_USERNAME = "sub";
    //荷载的创建时间
    private static final String CLAIM_KEY_CREATED = "created";
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private Long expiration;

    /**
     * 根据载荷生成token
     * @param claims
     * @return String
     */
    private String generateToken(Map<String,Object> claims){
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS256,secret)
                .compact();
    }

    /**
     * 根据token生成载荷
     * @param token
     * @return Claims
     */
    private Claims getClaimsFromToken(String token){
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return claims;
    }

    /**
     * 判断token是否失效
     * @param token
     * @return
     */
    public boolean isTokenExpired(String token){
        Claims claims = getClaimsFromToken(token);
        Date expireDate =  claims.getExpiration();
        //如果token有效的时间在当前时间之前就表示实效
        return expireDate.before(new Date());
    }

    /**
     * 根据token和用户信息判断token是否有效
     * @param token
     * @param userDetails
     * @return
     */
    public Boolean validateToken(String token,UserDetails userDetails){
        String username = getUserNameFromToken(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    /**
     * 判断token是否可以被刷新
     * @param token
     * @return
     */
    public Boolean canRefresh(String token){
        return !isTokenExpired(token);
    }

    /**
     * 刷新token
     * @param token
     * @return
     */
    public String refreshToken(String token){
        Claims claims = getClaimsFromToken(token);
        claims.put(CLAIM_KEY_CREATED,new Date());
        return generateToken(claims);
    }

    /**
     * 设置token 过期时间
     * @return Date
     */
    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis()+expiration * 1000);
    }

    /**
     * 根据用户获取token
     * @param userDetails
     * @return
     */
    public String generateToken(UserDetails userDetails){
        Map<String,Object> map = new HashMap<>();
        map.put(CLAIM_KEY_USERNAME,userDetails.getUsername());
        map.put(CLAIM_KEY_CREATED,new Date());
        return generateToken(map);
    }

    /**
     * 根据token获取用户
     * @param token
     * @return
     */
    public String getUserNameFromToken(String token){
        String username=null;
        Claims claims = getClaimsFromToken(token);
        try {
            username = claims.getSubject();
        } catch (Exception e) {
            username = null;
        }
        return username;
    }

}
