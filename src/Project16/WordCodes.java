package Project16;/*
 * Copyright Clint Staley 2015
 */

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCodes {
    public static void main(String[] args) throws Exception {
        Scanner in;
        String cmd, line, word, code, translated;
        // Declare and initialize your data structures here.
        Map<String, String> encoder = new HashMap<String, String>();
        Map<String, String> decoder = new HashMap<String, String>();

        in = new Scanner(new FileInputStream(args[0]));
        while (in.hasNext()) {
            // Build the codes correctly.
            word = in.next();
            code = in.next();

            encoder.put(word, code);
            decoder.put(code, word);
        }
        in.close();
        in = new Scanner(System.in);

        while (in.hasNext()) {
            cmd = in.next();
            line = in.nextLine();

            // Fill out the block below to encode or decode line
            translated = "";
            if (cmd.contains("encode")) {
                for (String w : line.split("\\s+")) {
                    if (encoder.containsKey(w)){
                        translated = translated.concat(encoder.get(w));
                    } else {
                        translated += w;
                    }
                    translated += " ";
                }



            } else {

                for (String w : line.split("\\s+")) {
                    if (decoder.containsKey(w)){
                        translated = translated.concat(decoder.get(w));
                    } else {
                        translated += w;
                    }
                    translated += " ";
                }


            }

            System.out.println(translated);
        }
    }
}