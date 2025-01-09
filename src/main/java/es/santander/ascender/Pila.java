package es.santander.ascender;

public class Pila {

    private Nodo topePila;

    public void add(String mensaje) {
        if (topePila == null) {
            this.topePila = new Nodo(mensaje);
        } else {
            Nodo nodo = new Nodo(mensaje);
            nodo.setAnterior(topePila);
            topePila = nodo;
        }
    }

    public String get() {
        if (topePila == null) {
            return null;
        } 
        String valor = topePila.getValor();
        topePila = topePila.getAnterior();
        System.gc();
        return valor;

    }
}
