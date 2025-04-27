package Spring.Security.restful.api.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {
    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expirationMs}")
    private int jwtEpirationMs;

    // encrypted key
    private Key getSignInKey() {
        byte[] keyBytes = jwtSecret.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    // generate token
    public String generateToken(UserDetails userDetails) {
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtEpirationMs))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }


    // validate token

    public boolean validateToken(String token, UserDetails userDetails) {
    try {
        String username = extractUsername(token);
            return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    } catch (JwtException | IllegalArgumentException e){
        return false;
        }
    }


    // extract username from token

    public String extractUsername(String token) {
       return extractAllClaims(token).getSubject();
    }

    // check if token is expired

    public boolean isTokenExpired(String token) {
        Date expiration = extractAllClaims(token).getExpiration();
            return expiration.before(new Date());
    }

    public Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJwt(token)
                .getBody();
    }









}
