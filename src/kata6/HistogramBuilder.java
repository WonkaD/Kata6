package kata6;

import java.util.ArrayList;

public class HistogramBuilder <T> {
    private final ArrayList <T> lista;

    public HistogramBuilder(ArrayList<T> lista) {
        this.lista = lista;
    }
    
    public <A> Histogram<A> build (Attribute <T,A> attribute){
        Histogram<A> histo = new Histogram<>();
        for (T valor : lista) {
            A value = attribute.get(valor);
            histo.increment(value);
            
        }
        return histo;
    }
}
