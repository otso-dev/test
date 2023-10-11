package com.smalleats.jwt;

import com.smalleats.DTO.auth.JwtTokenRespDto;
import com.smalleats.entity.User;
import com.smalleats.repository.UserDAOImpl;
import com.smalleats.security.PrincipalUser;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.security.Key;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class TokenProvider {

    @Autowired
    private UserDAOImpl userDAO;
    private final Key key;
    private final String secretKey = "h0TbPx1JMLd5otoav4BLG33VXAB9g58hzsPZkQYqsMVv6RyFPj44i12C9L4opNec";


    public TokenProvider(){
        this.key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));
    }

    public JwtTokenRespDto generateToken(Authentication authentication){
        StringBuilder builder = new StringBuilder();
        authentication.getAuthorities().forEach(authority ->{
            builder.append(authority.getAuthority() + ",");
        });
        builder.delete(builder.length() - 1, builder.length());
        String authorities = builder.toString();

        Date tokenExpiresDate = new Date(new Date().getTime() +1000 * 60 * 60 *24);

        String acessToken = Jwts.builder()
                .setSubject(authentication.getName())
                .claim("email",authentication.getName())
                .claim("auth",authorities)
                .setExpiration(tokenExpiresDate)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
        return JwtTokenRespDto.builder().grantType("Bearer").accessToken(acessToken).build();
    }

    public String getToken(String token) {
        String type = "Bearer";
        if (StringUtils.hasText(token) && token.startsWith(type)) {
            return token.substring(type.length() + 1);
        }
        return null;
    }

    public Claims getClaims(String token) {
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
    }

    public Authentication getAuthentication(String accessToken) {
        Authentication authentication = null;

        Claims claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(accessToken).getBody();

        String email = claims.get("email").toString();

        User user = userDAO.findUserByEmail(email);

        PrincipalUser principalsUser = user.toPrincipal();
        authentication = new UsernamePasswordAuthenticationToken(principalsUser, null, principalsUser.getAuthorities());
        return authentication;
    }
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (io.jsonwebtoken.security.SecurityException | MalformedJwtException e) {
            System.out.println("잘못된 JWT 서명입니다.");
        } catch (ExpiredJwtException e) {
            System.out.println("만료된 JWT 토큰입니다.");
        } catch (UnsupportedJwtException e) {
            System.out.println("지원하지 않는 JWT 토큰입니다.");
        } catch (IllegalArgumentException e) {
            System.out.println("JWT 토큰이 잘못되었습니다.");
        }
        return false;
    }
}
