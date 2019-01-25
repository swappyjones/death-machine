/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crawler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.validator.UrlValidator;
import org.jsoup.Jsoup;

/**
 *
 * @author Swappy
 */
public class writer {

    public static void writer() throws FileNotFoundException, IOException {
        File crawler_file =new File("C:\\Users\\Swappy\\Documents\\urls");
        
    Scanner sc = new Scanner(System.in);
    BufferedReader bf = new BufferedReader(new FileReader(crawler_file));
    try {
            bf = new BufferedReader(new FileReader(crawler_file));
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }
    int c=1;
    String name = "C:\\Users\\Swappy\\Documents\\website\\"+c+".html";
    File scrapper_file =new File(name);
    if(!scrapper_file.exists()){
      scrapper_file.createNewFile();
    }
    BufferedWriter br = new BufferedWriter(new FileWriter(scrapper_file));
        String url = bf.readLine();
        while(url!=null){
           if(!urlvalidator(url))
            url = bf.readLine();
           else
           {
               org.jsoup.nodes.Document doc = Jsoup.connect(url).get();
               c++;
               String html = doc.toString();
               br.write(html);
               url=bf.readLine();
           }
           name = "C:\\Users\\Swappy\\Documents\\website\\"+c+".html";
           scrapper_file =new File(name);
            if(!scrapper_file.exists()){
      scrapper_file.createNewFile();
            }
    br = new BufferedWriter(new FileWriter(scrapper_file));
            
        }
        bf.close();
        br.close();
    }

    private static boolean urlvalidator(String url) {
        UrlValidator valid = new UrlValidator();
        return valid.isValid(url);
    }
    
    
        

    
}
