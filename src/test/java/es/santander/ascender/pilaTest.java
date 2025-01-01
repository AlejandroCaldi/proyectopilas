package es.santander.ascender;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class pilaTest {
    @Test
    void testAddyGeT() {
        Pila pila = new Pila();


        pila.add("primera");
        pila.add("segunda");
        pila.add("tercera");

        assertEquals("tercera", pila.get());
        assertEquals("segunda", pila.get());
        assertEquals("primera", pila.get());
        assertNull(pila.get());

    }
}
