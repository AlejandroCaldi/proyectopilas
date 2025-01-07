package es.santander.ascender;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class listaTest {
    @Test
    void testAddUltimoPollUltimo() {
        ListaEncadenada lista = new ListaEncadenada();

        lista.addUltimo("primera");
        lista.addUltimo("segunda");
        lista.addUltimo("tercera");

        assertEquals("tercera", lista.pollUltimo());
        assertEquals("segunda", lista.pollUltimo());
        assertEquals("primera", lista.pollUltimo());
        assertNull(lista.pollUltimo());

    }

    @Test
    void testAddUltimoypollPrimero() {
        ListaEncadenada lista = new ListaEncadenada();

        lista.addUltimo("primera");
        lista.addUltimo("segunda");
        lista.addUltimo("tercera");

        assertEquals("primera", lista.pollPrimero());
        assertEquals("segunda", lista.pollPrimero());
        assertEquals("tercera", lista.pollPrimero());
        assertNull(lista.pollPrimero());

    }

    @Test
    void testAddPrimeroypollPrimero() {
        ListaEncadenada lista = new ListaEncadenada();

        lista.addPrimero("primera");
        lista.addPrimero("segunda");
        lista.addPrimero("tercera");

        assertEquals("tercera", lista.pollPrimero());
        assertEquals("segunda", lista.pollPrimero());
        assertEquals("primera", lista.pollPrimero());
        assertNull(lista.pollPrimero());

    }

    @Test
    void testAddPrimeroypollUltimo() {
        ListaEncadenada lista = new ListaEncadenada();

        lista.addPrimero("primera");
        lista.addPrimero("segunda");
        lista.addPrimero("tercera");

        assertEquals("primera", lista.pollUltimo());
        assertEquals("segunda", lista.pollUltimo());
        assertEquals("tercera", lista.pollUltimo());
        assertNull(lista.pollUltimo());

    }

    @Test
    void testAddIndex() throws Exception {
        ListaEncadenada lista = new ListaEncadenada();

        lista.addUltimo("primera");
        lista.addUltimo("segunda");
        lista.addUltimo("tercera");

        lista.addIndex(1, "segunda2");

        lista.listar();
        assertEquals("primera", lista.pollPrimero());
        assertEquals("segunda", lista.pollPrimero());
        assertEquals("segunda2", lista.pollPrimero());
        assertEquals("tercera", lista.pollPrimero());
        assertNull(lista.pollPrimero());

    }

    @Test
    void testPeekPrimero() throws Exception {
        ListaEncadenada lista = new ListaEncadenada();

        lista.addUltimo("primera");
        lista.addUltimo("segunda");
        lista.addUltimo("tercera");

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
        ListaEncadenada lista = new ListaEncadenada();

        lista.addUltimo("primera");
        lista.addUltimo("segunda");
        lista.addUltimo("tercera");

        Exception exception = assertThrows(Exception.class, () -> {
            lista.addIndex(5, "segunda5");
        });

        String texto = exception.getMessage();
        assertTrue(texto.contains("Fuera de indice"));
    }

    @Test
    void testBorrarIndex() throws Exception {
        ListaEncadenada lista = new ListaEncadenada();

        lista.addUltimo("primera");
        lista.addUltimo("segunda");
        lista.addUltimo("tercera");

        lista.borrarIndex(1);

        lista.listar();
        assertEquals("primera", lista.pollPrimero());
        assertEquals("tercera", lista.pollPrimero());
        assertNull(lista.pollPrimero());
    }

    @Test
    void testBorrarIndexFueraRango() throws Exception {
        ListaEncadenada lista = new ListaEncadenada();

        lista.addUltimo("primera");
        lista.addUltimo("segunda");
        lista.addUltimo("tercera");

        Exception exception = assertThrows(Exception.class, () -> {
            lista.borrarIndex(5);
        });

        String texto = exception.getMessage();
        assertTrue(texto.contains("Fuera de indice"));

        lista.listar();
    }

    @Test
    void testBorrarLista() throws Exception {
        ListaEncadenada lista = new ListaEncadenada();

        lista.addUltimo("primera");
        lista.addUltimo("segunda");
        lista.addUltimo("tercera");

        assertTrue(lista.tamanoLista()==3);

        lista.borrarLista();

        lista.listar();

        lista.borrarLista();

        assertTrue(lista.tamanoLista()==0);

    }

}
