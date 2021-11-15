package ru.simbir.logics;

import java.util.*;

public class Delimiter {

    public Map<String, Integer> map_text;

    public void divider (String inputHtmlPage) {
        try {
            StringTokenizer st = new StringTokenizer(inputHtmlPage,
                    " ',''.''!''?'';'':''''['']''('')''\n''\r''\t''//''<''>''--''='" +
                            "'#''||''}''{''+''@''-''*''_''__''\"''0''1''2''3''4'" +
                            "'5''6''7''8''9''&&''«''»''©'");
            //-------------------------------------------------------------------------------------
            List<String> array_text = new ArrayList<>();
            while (st.hasMoreTokens()) {
                array_text.add(st.nextToken());
            }
            //-------------------------------------------------------------------------------------
            map_text = new HashMap<>();
            for (String word : array_text) {
                map_text.put(word, map_text.containsKey(word) ? map_text.get(word) + 1 : 1);
            }
            for (Map.Entry<String, Integer> entry : map_text.entrySet()) {
                System.out.println(entry.getKey()
                        + " - " + entry.getValue());
            }
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }
}
