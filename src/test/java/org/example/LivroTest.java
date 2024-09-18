package org.example;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LivroTest {

    private static Livro livro;

    @BeforeAll
    static void setUp(){
        livro = new Livro("Java Programming", "Autor A", true);
    }

    @Test
    public void testGetTitulo() {
        livro.setTitulo("Java Programming");
        assertEquals("Java Programming", livro.getTitulo());
    }

    @Test
    public void testGetAutor() {
        livro.setAutor("Autor A");
        assertEquals("Autor A", livro.getAutor());
    }

    @Test
    public void testIsDisponivel() {
        assertTrue(livro.isDisponivel());
    }

    @Test
    public void testEmprestarLivro() {
        livro.emprestar();
        assertFalse(livro.isDisponivel());
    }

    @Test
    public void testDevolverLivro() {
        livro.devolver();
        assertTrue(livro.isDisponivel());
    }

    @Test
    public void testSetTitulo(){
        livro.setTitulo("teste");
        assertEquals("teste",livro.getTitulo());
    }

    @Test
    public void testSetAutor(){
        livro.setAutor("teste");
        assertEquals("teste",livro.getAutor());
    }
}