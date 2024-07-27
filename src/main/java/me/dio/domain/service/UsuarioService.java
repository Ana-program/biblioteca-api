package me.dio.domain.service;

import me.dio.domain.model.Usuario;
import me.dio.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listarTodos(){
        return usuarioRepository.findAll();
    }
    public Usuario encontrarPorId(Long id){
        return usuarioRepository.findById(id).orElse(null);
    }
    public Usuario salvar(Usuario usuario){
        return usuarioRepository.save(usuario);
    }
    public void deletar(Long id){
        usuarioRepository.deleteById(id);
    }


}
