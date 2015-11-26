package kata6;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        String nameFile = "emails.txt";
        ArrayList<Person1> mailArray = PersonLoader.read();
        HistogramBuilder<Person1> builder = new HistogramBuilder<>(mailArray);
        
        Histogram<Float> peso = builder.build((Person1 item) -> item.getPeso());
        Histogram<String> dominios = builder.build((Person1 item) -> item.getMail().split("@")[1]);
        Histogram<Character> genero = builder.build((Person1 item) -> item.getGenero().charAt(0));
        
        new HistogramDisplay(peso, "peso").execute();
        new HistogramDisplay(dominios, "Dominios").execute();
        new HistogramDisplay(genero, "Generos").execute();
        
        
        
    }


}
