package com.jwt.controller;

import com.jwt.entity.Contacto;
import com.jwt.repository.ContactoRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("contactos")
@AllArgsConstructor
public class ContactoController {

    private final ContactoRepository contactoRepository;

    @GetMapping
    public List<Contacto> listContacto () {
        return contactoRepository.findAll();
    }

    @GetMapping("/register")
    public List<Contacto> listContactos () {
        return contactoRepository.findAll();
    }
}
