package com.jwt.service;

import com.jwt.entity.Usuario;
import com.jwt.repository.UsuarioRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UsuarioService {

    private static final String SECRET_KEY ="586E3272357538782F413F4428472B4B6250655368566B597033733676397924";

    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario registerUsuario (Usuario newUsuario) {
        try {
            String bcryptHasgRegex = "\\A\\$2a?\\$\\d\\d\\$[./0-9A-Za-z]{53}";
            boolean isBcryptHash = newUsuario.getPassword().matches(bcryptHasgRegex);
            if (newUsuario.getPassword() != null && newUsuario.getPassword() != "" && !isBcryptHash) {
                newUsuario.setPassword(new BCryptPasswordEncoder().encode(newUsuario.getPassword()));
            }
            return usuarioRepository.save(newUsuario);
        }catch (Exception e) {
            throw e;
        }
    }

    public Claims obtenerClaimsDesdeToken(String token) {
        try {
            if (token.startsWith("Bearer ")) {
                token = token.replaceFirst("Bearer ", "");
            }

            Jws<Claims> jws = Jwts.parserBuilder()
                    .setSigningKey(Keys.hmacShaKeyFor(SECRET_KEY.getBytes()))
                    .build()
                    .parseClaimsJws(token);

            return jws.getBody();
        } catch (Exception e) {
            // Manejar la excepción según tus necesidades (puede ser token inválido, expirado, etc.)
            throw new RuntimeException("No se pudo obtener los claims del token", e);
        }
    }


}
