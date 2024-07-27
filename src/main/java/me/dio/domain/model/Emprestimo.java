package me.dio.domain.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "tb_card")
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "leitor_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "livro_id")
    private Livro livro;

    private LocalDate dataEmprestimo;
    private LocalDate DataDevolução;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUser() {
        return usuario;
    }

    public void setUser(Usuario usuario) {
        this.usuario = usuario;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataDevolução() {
        return DataDevolução;
    }

    public void setDataDevolução(LocalDate dataDevolução) {
        DataDevolução = dataDevolução;
    }
}
