package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class MyFileWriter {

    public static void writeToFileV1(String text, String file) {
        try (FileWriter fw = new FileWriter(file);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(text);
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }

    public static String readFromFile(String file) throws Exception {
        try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {
            StringBuilder content= new StringBuilder();
            String line;
            while ((line= br.readLine())!=null){

                 content.append(line);
            }
            return content.toString();
        }
    }

    public static void writeToFileV2(String text, String file) throws IOException {

        Files.write(Paths.get(file), text.getBytes(), StandardOpenOption.WRITE);
    }

    public static void writeObjectToFile(Object obj, String file) {

        try (FileOutputStream f = new FileOutputStream(file);
             ObjectOutputStream o = new ObjectOutputStream(f)) {
            o.writeObject(obj);

        } catch (Exception ex) {
            System.out.println("File not found");
        }

    }

    public static Object readObjectfromFile(String file) {

        try (FileInputStream fi = new FileInputStream(file);
             ObjectInputStream oi = new ObjectInputStream(fi)) {
            return oi.readObject();

        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return null;
    }
}

