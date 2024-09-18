package org.example;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class UsuarioTest {

    private static Usuario usuario;
    private static Livro livro;
    @BeforeAll
    static void setUp(){
        usuario = new Usuario("João");
        livro = new Livro("Java Programming", "Autor A", true);
    }

    @Test
    public void testGetNome() {
        assertEquals("João", usuario.getNome());
    }

    @Test
    public void testAlugarLivro() {
        usuario.alugarLivro(livro);
        assertFalse(livro.isDisponivel());
        assertEquals(1, usuario.contarLivrosAlugados());
    }

    @Test
    public void testDevolverLivro() {
        usuario.alugarLivro(livro);
        usuario.devolverLivro(livro);
        assertTrue(livro.isDisponivel());
    }

    @Test
    public void testAlugarLivro2() {
        Livro livro1 = new Livro("Java Programming0", "Autor Z", true);
        Livro livro2 = new Livro("Java Programming2", "Autor B", true);
        Livro livro3 = new Livro("Java Programming3", "Autor C", true);
        Livro livro4 = new Livro("Java Programming4", "Autor D", true);
        Livro livro5 = new Livro("Java Programming5", "Autor E", true);
        usuario.devolverLivro(livro);
        usuario.alugarLivro(livro1);
        usuario.alugarLivro(livro2);
        usuario.alugarLivro(livro3);
        usuario.alugarLivro(livro4);
        usuario.alugarLivro(livro5);
        usuario.alugarLivro(livro);
        assertTrue(livro.isDisponivel());
        assertEquals(5, usuario.contarLivrosAlugados());
        usuario.devolverLivro(livro1);
        usuario.devolverLivro(livro2);
        usuario.devolverLivro(livro3);
        usuario.devolverLivro(livro4);
        usuario.devolverLivro(livro5);
    }

    @Test
    public void testAlugarLivro3() {
        Usuario usuario2 = new Usuario("Pedro");
        usuario.devolverLivro(livro);
        assertTrue(livro.isDisponivel());
        usuario.alugarLivro(livro);
        assertFalse(livro.isDisponivel());
        usuario2.alugarLivro(livro);
        assertEquals(1, usuario.contarLivrosAlugados());
        assertEquals(0, usuario2.contarLivrosAlugados());
    }

    @Test
    public void testContarLivrosAlugados() {
        assertEquals(0, usuario.contarLivrosAlugados());
    }

    @Test
    public void testPodeAlugarMais() {
        assertTrue(usuario.podeAlugarMais());
    }
}