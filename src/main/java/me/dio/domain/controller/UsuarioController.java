package me.dio.domain.controller;

import me.dio.domain.model.Usuario;
import me.dio.domain.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> listarTodos(){
        return usuarioService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> encontrarPorId(@PathVariable Long id){
        Usuario usuario = usuarioService.encontrarPorId(id);
        if (usuario != null){
            return ResponseEntity.ok(usuario);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Usuario salvar(@RequestBody Usuario usuario){
        return usuarioService.salvar(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        usuarioService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}