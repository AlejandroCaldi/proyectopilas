package es.santander.ascender;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ListaEncadenadaTest {

    ListaEncadenada lista = new ListaEncadenada();
    ListaEncadenada listaInvertida = new ListaEncadenada();

    @BeforeEach
    public void setUp() {
        

        lista.addUltimo("primera");
        lista.addUltimo("segunda");
        lista.addUltimo("tercera");

        listaInvertida.addPrimero("primera");
        listaInvertida.addPrimero("segunda");
        listaInvertida.addPrimero("tercera");
        
    }


    @Test
    public void testAddUltimoPollUltimo() {
    
        assertEquals("tercera", lista.pollUltimo());
        assertEquals("segunda", lista.pollUltimo());
        assertEquals("primera", lista.pollUltimo());
        assertNull(lista.pollUltimo());

    }

    @Test
    void testAddUltimoypollPrimero() {
    
        assertEquals("primera", lista.pollPrimero());
        assertEquals("segunda", lista.pollPrimero());
        assertEquals("tercera", lista.pollPrimero());
        assertNull(lista.pollPrimero());

    }

    @Test
    void testAddPrimeroypollPrimero() {
    
        assertEquals("tercera", listaInvertida.pollPrimero());
        assertEquals("segunda", listaInvertida.pollPrimero());
        assertEquals("primera", listaInvertida.pollPrimero());
        assertNull(listaInvertida.pollPrimero());

    }

    @Test
    void testAddPrimeroypollUltimo() {
    
        assertEquals("primera", listaInvertida.pollUltimo());
        assertEquals("segunda", listaInvertida.pollUltimo());
        assertEquals("tercera", listaInvertida.pollUltimo());
        assertNull(listaInvertida
        .pollUltimo());

    }

    @Test
    void testAddIndex() throws Exception {
    
        lista.addIndex(1, "segunda2");

        lista.listar();
        assertEquals("primera", lista.pollPrimero());
        assertEquals("segunda", lista.pollPrimero());
        assertEquals("segunda2", lista.pollPrimero());
        assertEquals("tercera", lista.pollPrimero());
        assertNull(lista.pollPrimero());

    }

    @Test
    void testAddIndexUltimo() throws Exception {
    
        lista.addIndex(2, "segunda2");

        lista.listar();
        assertEquals("primera", lista.pollPrimero());
        assertEquals("segunda", lista.pollPrimero());
        assertEquals("tercera", lista.pollPrimero());
        assertEquals("segunda2", lista.pollPrimero());
        assertNull(lista.pollPrimero());

    }

    @Test
    void testAddIndexNegativo() throws Exception {
    
        // lista.addIndex(2, "segunda2");

        // lista.listar();
        // assertEquals("primera", lista.pollPrimero());
        // assertEquals("segunda", lista.pollPrimero());
        // assertEquals("tercera", lista.pollPrimero());
        // assertEquals("segunda2", lista.pollPrimero());
        // assertNull(lista.pollPrimero());

    }

    @Test
    void testPeekPrimero() throws Exception {
    
        lista.addIndex(1, "segunda2");

        lista.listar();
        assertEquals("primera", lista.peekPrimero());
        assertEquals("primera", lista.pollPrimero());
        assertEquals("segunda", lista.peekPrimero());
        assertEquals("segunda", lista.pollPrimero());
        assertEquals("segunda2", lista.peekPrimero());
        assertEquals("segunda2", lista.pollPrimero());
        assertEquals("tercera", lista.peekPrimero());
        assertEquals("tercera", lista.pollPrimero());
        assertNull(lista.pollPrimero());
    }

    @Test
    void testPeekPrimeroFueraRango() throws Exception {
    
        Exception exception = assertThrows(Exception.class, () -> {
            lista.addIndex(5, "segunda5");
        });

        String texto = exception.getMessage();
        assertTrue(texto.contains("Fuera de indice"));
    }

    @Test
    void testBorrarIndex() throws Exception {
    
        lista.borrarIndex(1);

        lista.listar();
        assertEquals("primera", lista.pollPrimero());
        assertEquals("tercera", lista.pollPrimero());
        assertNull(lista.pollPrimero());
    }

    // Agregar texts de negativos y último valor de indice
    
    @Test
    void testBorrarIndexFueraRango() throws Exception {
    
        Exception exception = assertThrows(Exception.class, () -> {
            lista.borrarIndex(5);
        });

        String texto = exception.getMessage();
        assertTrue(texto.contains("Fuera de indice"));

        lista.listar();
    }

    @Test
    void testBorrarLista() throws Exception {
    
        assertTrue(lista.tamanoLista()==3);

        lista.borrarLista();

        lista.listar();

        lista.borrarLista();

        assertTrue(lista.tamanoLista()==0);

    }

}
