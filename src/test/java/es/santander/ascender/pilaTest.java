package es.santander.ascender;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class pilaTest {
    @Test
    void testAdd() {
        Pila pila = new Pila();


        pila.add("primera");
        pila.add("segunda");
        pila.add("tercera");

        // String siguiente = null;
        // int cuenta = 0;
        // while((siguiente = pila.get()) != null) {
        //     cuenta++;
        // }
        // assertEquals(3, cuenta);

        assertEquals("tercera", pila.get());
        assertEquals("segunda", pila.get());
        assertEquals("primera", pila.get());
        assertNull(pila.get());

    }
}
