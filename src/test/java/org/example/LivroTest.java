package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LivroTest {

    @Test
    public void testGetTitulo() {
        Livro livro = new Livro("Java Programming", "Autor A", true);
        assertEquals("Java Programming", livro.getTitulo());
    }

    @Test
    public void testGetAutor() {
        Livro livro = new Livro("Java Programming", "Autor A", true);
        assertEquals("Autor A", livro.getAutor());
    }

    @Test
    public void testIsDisponivel() {
        Livro livro = new Livro("Java Programming", "Autor A", true);
        assertTrue(livro.isDisponivel());
    }

    @Test
    public void testEmprestarLivro() {
        Livro livro = new Livro("Java Programming", "Autor A", true);
        livro.emprestar();
        assertFalse(livro.isDisponivel());
    }

    @Test
    public void testDevolverLivro() {
        Livro livro = new Livro("Java Programming", "Autor A", false);
        livro.devolver();
        assertTrue(livro.isDisponivel());
    }
}