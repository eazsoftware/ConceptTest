package com.eaz.concepttest.utffile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.SortedMap;
import java.nio.charset.StandardCharsets;

public class UTFFile {

    public static void main(String[] args) {

        try {
            SortedMap<String, Charset> sortedMap = Charset.availableCharsets();
            System.out.println("Available keys: [" + sortedMap.keySet().size() + "]");
            for (String key : sortedMap.keySet()) {
                System.out.println("Charset [" + key + "] [" + sortedMap.get(key) + "]");
            }

            Charset defaultCharset = Charset.defaultCharset();
            //StandardCharsets.ISO_8859_1;

            File fileDir = new File("./UTF8.txt");

            Writer out = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(fileDir), Charset.forName("UTF-8")));

            out.append("Website UTF-8").append("\r\n");
            out.append("?? UTF-8").append("\r\n");
            out.append("??????? UTF-8").append("\r\n");

            out.flush();
            out.close();

            //////////////////////////////////////////////////////////////////

            fileDir = new File("./ISO-8859-1.txt");

            out = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(fileDir), Charset.forName("ISO-8859-1")));

            out.append("Website ISO-8859-1").append("\r\n");
            out.append("?? ISO-8859-1").append("\r\n");
            out.append("??????? ISO-8859-1").append("\r\n");

            out.flush();
            out.close();

            //////////////////////////////////////////////////////////////////            
            

            fileDir = new File("./ISO-8859-1B.txt");
//            FileOutputStream fs = new FileOutputStream(file);
//            OutputStreamWriter ow = new OutputStreamWriter(fs);
//            BufferedWriter writer = new BufferedWriter(ow);

            OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(fileDir), Charset.forName("ISO-8859-1"));

            osw.write("Website ISO-8859-1");
            osw.write("\r\n");
            osw.write("?? ISO-8859-1");
            osw.write("\r\n");
            osw.write("??????? ISO-8859-1");
            osw.write("\r\n");

            osw.flush();
            osw.close();

        } catch (UnsupportedEncodingException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}