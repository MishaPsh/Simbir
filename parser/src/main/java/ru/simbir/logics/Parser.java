package ru.simbir.logics;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class Parser {
    public String parse(String name) throws IOException {
        BufferedReader in = null;
        String inputLine = "";
        try {
            String httpURL = name;
            URL myURL = new URL(httpURL);
            HttpsURLConnection con = (HttpsURLConnection) myURL.openConnection();
            con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:63.0) Gecko/20100101 Firefox/63.0");
            InputStream ins = con.getInputStream();
            InputStreamReader isr = new InputStreamReader(ins, "UTF-8");
            in = new BufferedReader(isr);
            while (in.readLine() != null) {
                inputLine = inputLine+in.readLine();
                // System.out.println(inputLine);
            }
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        } finally {
            in.close();
        }
        return inputLine;
    }
}
