package me.dio.domain.service;

import me.dio.domain.model.Emprestimo;
import me.dio.domain.model.Livro;
import me.dio.domain.repository.EmprestimoRepository;
import me.dio.domain.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmprestimoService {

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @Autowired
    private LivroRepository livroRepository;

    public List<Emprestimo> listarTodos(){
        return emprestimoRepository.findAll();
    }
    public Emprestimo encontrarPorId(Long id){
        return emprestimoRepository.findById(id).orElse(null);
    }
    public Emprestimo salvar(Emprestimo emprestimo) {
        Livro livro = emprestimo.getLivro();
        if (livro.isDisponivel()) {
            livro.setDisponivel(false);
            livroRepository.save(livro);
            return emprestimoRepository.save(emprestimo);
        }
        return null;
    }
    public void deletar(Long id){
        Emprestimo emprestimo = emprestimoRepository.findById(id).orElse(null);
        if (emprestimo != null){
            Livro livro = emprestimo.getLivro();
            livro.setDisponivel(true);
            livroRepository.save(livro);
            emprestimoRepository.deleteById(id);
        }
    }
}