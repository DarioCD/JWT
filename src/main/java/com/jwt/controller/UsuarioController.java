package com.jwt.controller;

import com.jwt.entity.Usuario;
import com.jwt.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
