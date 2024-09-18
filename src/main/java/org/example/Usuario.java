package org.example;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nome;
    private List<Livro> livrosAlugados;
    private static final int maxLivrosAlugados = 5;

    public Usuario(String nome) {
        this.nome = nome;
        this.livrosAlugados = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void alugarLivro(Livro livro) {
        if (this.podeAlugarMais() & livro.isDisponivel()){
            livrosAlugados.add(livro);
            livro.emprestar();
            System.out.println("Livro alugado com sucesso.");
        }else{
            if (!livro.isDisponivel()) {
                System.out.println("Erro: O livro não está disponível para aluguel.");
            } else {
                System.out.println("Erro: Limite de livros alugados atingido.");
            }
        }
    }

    public int contarLivrosAlugados() {
        return livrosAlugados.size();
    }

    public void devolverLivro(Livro livro) {
        if (livrosAlugados.contains(livro)) {
            livrosAlugados.remove(livro);
            livro.devolver();
            System.out.println("Livro devolvido com sucesso.");
        } else {
            System.out.println("Erro: O usuário não possui esse livro.");
        }
    }

    public boolean podeAlugarMais() {
        return livrosAlugados.size() < maxLivrosAlugados;
    }
}
