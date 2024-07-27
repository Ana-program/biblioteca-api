package me.dio.domain.service;

import me.dio.domain.model.Livro;
import me.dio.domain.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public List<Livro> listarTodos(){
        return livroRepository.findAll();
    }
    public Livro encontrarPorId(Long id){
        return livroRepository.findById(id).orElse(null);
    }
    public Livro salvar(Livro livro){
        return livroRepository.save(livro);
    }
    public void deletar(Long id){
        livroRepository.deleteById(id);
    }
}
