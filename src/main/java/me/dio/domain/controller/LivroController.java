package me.dio.domain.controller;

import me.dio.domain.model.Livro;
import me.dio.domain.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping
    public List<Livro> listarTodos(){
        return livroService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> encontrarPorId(@PathVariable Long id){
        Livro livro = livroService.encontrarPorId(id);
        if (livro != null){
            return ResponseEntity.ok(livro);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public Livro salvar(@RequestBody Livro livro){
        return livroService.salvar(livro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        livroService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}