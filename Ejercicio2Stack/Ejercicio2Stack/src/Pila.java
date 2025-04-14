import java.util.Stack;

public class Pila {
    private Stack<String> coleccion;

    public Pila(){
        coleccion=new Stack<String>();
    }

    public void insertar(String dato){
        coleccion.push(dato);
    }

    public String extraer() throws Exception {

        if (coleccion.isEmpty())
            throw new Exception("Error en metodo extraer, pila vacia");
        return coleccion.pop();
    }

    public String cima(){
        return coleccion.peek();
    }

    @Override
    public String toString() {
        StringBuilder lista=new StringBuilder();
        for(int i=coleccion.size()-1; i>=0; i--){
            lista.append(coleccion.get(i)+"\n");
        }
        return lista.toString();
    }

    public int size (){
        return coleccion.size();
    }

    public boolean esVacia(){
        if (coleccion.isEmpty())
            return true;
        return false;
    }


}
