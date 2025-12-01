package com.example.nuvemjava.controller;


import com.example.nuvemjava.model.Usuario;
import com.example.nuvemjava.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<String> criarUsuario(@RequestBody Usuario usuario) {
        try {
            String id = usuarioService.salvar(usuario);
            return ResponseEntity.ok("Usuário salvo com sucesso! ID: " + id);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Erro ao salvar usuário.");
        }
    }
}