package es.santander.ascender;

public class ListaEncadenada {

    private Nodo raiz;
    private Nodo cima;

    public void addUltimo(String mensaje) {
        Nodo nodo = new Nodo(mensaje);

        if (cima == null) {
            cima = nodo;
            raiz = nodo;
        } else {
            nodo.setAnterior(cima);
            cima.setSiguiente(nodo);
            cima = nodo;
        }
    }

    public void addPrimero(String mensaje) {
        Nodo nodo = new Nodo(mensaje);
        if (raiz == null) {
            cima = nodo;
            raiz = nodo;
        } else {
            nodo.setSiguiente(raiz);
            raiz.setAnterior(nodo);
            raiz = nodo;
        }
    }

    public void addIndex(int index, String mensaje) throws Exception {
        Nodo siguienteViejo = new Nodo("");
        if (index == 0) {
            this.addPrimero(mensaje);

        } else {

            int contador = 1;
            Nodo nodo = raiz;
            
            while (contador <= index) {
                nodo = nodo.getSiguiente();
                if (nodo == null) {
                    throw new Exception("Fuera de indice");
                }
                siguienteViejo = nodo.getSiguiente();
                contador++;
            }
            Nodo nuevoNodo = new Nodo(mensaje);
            nuevoNodo.setAnterior(nodo);
            nuevoNodo.setSiguiente(siguienteViejo);

            nodo.setSiguiente(nuevoNodo);
            nuevoNodo.getSiguiente().setAnterior(nuevoNodo);

        }
    }

    public void borrarIndex(int index) throws Exception {
        Nodo siguienteViejo = new Nodo("");
        Nodo anteriorViejo = new Nodo("");
        if (index == 0) {
            this.peekPrimero();

        } else {

            int contador = 1;
            Nodo nodo = raiz;
            
            while (contador <= index) {
                nodo = nodo.getSiguiente();
                if (nodo == null) {
                    throw new Exception("Fuera de indice");
                }
                anteriorViejo = nodo.getAnterior();
                siguienteViejo = nodo.getSiguiente();
                contador++;
            }

            nodo.getAnterior().setSiguiente(siguienteViejo);
            nodo.getSiguiente().setAnterior(anteriorViejo);
            System.gc();

        }
    }

    public void borrarLista() {
        this.cima = null; 
        this.raiz = null;
        System.gc();
        
    }

    public String pollPrimero() { // el método estandar de java usa Poll como lectura e inmediato borrado
        if (raiz == null) {
            return null;
        }
        String valor = raiz.getValor();
        raiz = raiz.getSiguiente();
        System.gc();
        return valor;
    }

    public String peekPrimero() { // el método estandar de java usa Peek como lectura
        if (raiz == null) {
            return null;
        }
        return raiz.getValor();
    }

    public String pollUltimo() { // el método estandar de java usa Poll como lectura e inmediato borrado
        if (cima == null) {
            return null;
        }
        String valor = cima.getValor();
        cima = cima.getAnterior();
        System.gc();
        return valor;
    }

    public String peekUltimo() { // el método estandar de java usa Poll como lectura e inmediato borrado
        if (cima == null) {
            return null;
        }
        return cima.getValor();
    }

    public void listar() {

        Nodo nodo = raiz;
        while (nodo!=null) {
            System.out.println(nodo.getValor());
            nodo = nodo.getSiguiente();
        }
    }

    public int tamanoLista() {
        int contador = 0;
        Nodo nodo = raiz;
        while (nodo!=null) {
            contador++;
            nodo = nodo.getSiguiente();
        }
        return contador;
    }
}
