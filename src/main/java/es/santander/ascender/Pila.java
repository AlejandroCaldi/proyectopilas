package es.santander.ascender;

public class Pila {

    private Nodo raiz;

    public void add(String mensaje) {
        if (raiz == null) {
            this.raiz = new Nodo(mensaje);
        } else {
            Nodo nodo = new Nodo(mensaje);
            nodo.setAnterior(raiz);
            raiz = nodo;
        }
    }

    public String get() {
        if (raiz == null) {
            return null;
        } 
        String valor = raiz.getValor();
        raiz = raiz.getAnterior();
        System.gc();
        return valor;

    }
}
