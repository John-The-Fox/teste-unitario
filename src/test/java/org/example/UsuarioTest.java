package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class UsuarioTest {

    @Test
    public void testGetNome() {
        Usuario usuario = new Usuario("João");
        assertEquals("João", usuario.getNome());
    }

    @Test
    public void testAlugarLivro() {
        Livro livro = new Livro("Java Programming", "Autor A", true);
        Usuario usuario = new Usuario("João");
        usuario.alugarLivro(livro);
        assertFalse(livro.isDisponivel());
        assertEquals(1, usuario.contarLivrosAlugados());
    }

    @Test
    public void testDevolverLivro() {
        Livro livro = new Livro("Java Programming", "Autor A", false);
        Usuario usuario = new Usuario("João");
        usuario.alugarLivro(livro);
        usuario.devolverLivro(livro);
        assertTrue(livro.isDisponivel());
    }

    @Test
    public void testContarLivrosAlugados() {
        Usuario usuario = new Usuario("João");
        assertEquals(0, usuario.contarLivrosAlugados());
    }

    @Test
    public void testPodeAlugarMais() {
        Usuario usuario = new Usuario("João");
        assertTrue(usuario.podeAlugarMais());
    }
}