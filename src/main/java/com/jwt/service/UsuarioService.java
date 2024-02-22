package com.jwt.service;

import com.jwt.entity.Usuario;
import com.jwt.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UsuarioService {

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
}
