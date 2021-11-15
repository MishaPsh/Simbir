package ru.simbir.main;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.simbir.data.HibernateUtil;
import ru.simbir.logics.Delimiter;
import ru.simbir.logics.Parser;
import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {


        String httpUrl = "https://www.simbirsoft.com";

        Parser parser = new Parser();
        String htmlpage = parser.parse(httpUrl);

        Delimiter delimiter = new Delimiter();
        delimiter.divider(htmlpage);

        HibernateUtil hibernateUtil = new HibernateUtil();
        hibernateUtil.hibUtil();
    }

}
