package es.santander.ascender;

public class Nodo {
    private String valor;
    private Nodo anterior;

    public Nodo(String valor) {
        this.valor = valor;
    }

    public void pedirLaVez(String mensaje) {
        if (anterior == null) {
            anterior = new Nodo(mensaje);
        } else {
            this.anterior.pedirLaVez(mensaje);
        }
    }

    public String getValor() {
        return valor;
    }
    public void setValor(String valor) {
        this.valor = valor;
    }
    public Nodo getAnterior() {
        return anterior;
    }
    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }
}
