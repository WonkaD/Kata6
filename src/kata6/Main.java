package kata6;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        String nameFile = "emails.txt";
        ArrayList<Person> mailArray = MailListReader.read(nameFile);
        
        HistogramBuilder<Person> builder = new HistogramBuilder<>(mailArray);
        Histogram<String> domains = builder.build((Person item) -> item.getMail().substring(item.getMail().indexOf("@")));
        Histogram<Character> letters = builder.build((Person item) -> item.getMail().charAt(0));
        
        new HistogramDisplay(letters, "Letras").execute();
        new HistogramDisplay(domains, "Dominios").execute();
        
    }


}
