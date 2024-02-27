package com.jwt.controller;

import com.jwt.entity.Usuario;
import com.jwt.service.UsuarioService;
import io.jsonwebtoken.Claims;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/register")
    public Usuario registerUsuario (@RequestBody Usuario usuario) {
        return usuarioService.registerUsuario(usuario);
    }


    @GetMapping("/usuario")
    public Claims getUsuarioToken (@RequestParam (value = "token") String token) {
        return usuarioService.obtenerClaimsDesdeToken(token);
    }
}
