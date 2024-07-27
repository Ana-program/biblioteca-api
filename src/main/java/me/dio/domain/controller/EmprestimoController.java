package me.dio.domain.controller;

import me.dio.domain.model.Emprestimo;
import me.dio.domain.service.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

    @Autowired
    private EmprestimoService emprestimoService;

    @GetMapping
    public List<Emprestimo> listarTodos(){
        return emprestimoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Emprestimo> encontrarPorId(@PathVariable Long id){
        Emprestimo emprestimo = emprestimoService.encontrarPorId(id);
        if (emprestimo != null){
            return ResponseEntity.ok(emprestimo);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Emprestimo> salvar(@RequestBody Emprestimo emprestimo){
        Emprestimo novoEmprestimo = emprestimoService.salvar(emprestimo);
        if (novoEmprestimo != null){
            return ResponseEntity.ok(novoEmprestimo);
        }else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        emprestimoService.deletar(id);
        return ResponseEntity.noContent().build();
    }


}