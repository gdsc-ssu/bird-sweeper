package com.gdsc.birdsweeper.security.jwt;

import com.gdsc.birdsweeper.domain.User;
import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class JwtTokenProvider {

    @Value("${spring.jwt.secretKey}")
    private String secretKey;
    private long tokenValidTime = 1000L * 60 * 60 * 24 * 30;    // 30days

    private final UserDetailsService userDetailsService;

    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    public String generateToken(User user) {
        JwtBuilder jwtBuilder = Jwts.builder()
                .setSubject(user.getUsername())
                .setHeader(createHeader())
                .setClaims(createClaims(user))
                .setExpiration(createExpireDate())
                .signWith(SignatureAlgorithm.HS256, secretKey);

        return jwtBuilder.compact();
    }

    public Authentication getAuthentication(String token) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(getUsername(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    public String getUsername(String token) {
        try {
            return (String) Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().get("username");
        } catch(ExpiredJwtException e) {
            return e.getClaims().getSubject();
        }
    }

    public String resolveToken(HttpServletRequest req) {
        return req.getHeader("X-AUTH-TOKEN");
    }

    public boolean validateTokenExpiration(String token) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    public boolean validateTokenExceptExpiration(String token) {
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return !claims.getBody().getExpiration().before(new Date());
        } catch(Exception e) {
            return false;
        }
    }

    private Map<String, Object> createHeader() {
        Map<String, Object> header = new HashMap<>();

        header.put("typ", "JWT");
        header.put("alg", "HS256");
        header.put("regDate", System.currentTimeMillis());

        return header;
    }

    private Map<String, Object> createClaims(User user) {
        Map<String, Object> claims = new HashMap<>();

        claims.put("username", user.getUsername());
        claims.put("role", user.getRole());

        return claims;
    }

    private Date createExpireDate() {
        Date now = new Date();

        return new Date(now.getTime() + tokenValidTime);
    }
}
