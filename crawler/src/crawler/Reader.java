/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crawler;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.lang.model.element.Element;
import javax.swing.text.Document;
import org.jsoup.Jsoup;
import java.io.*;
import java.io.BufferedWriter;
/**
 *
 * @author Swappy
 */
public class Reader {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws IOException {
        try {
            Scanner sc = new Scanner(System.in);
            String url = sc.nextLine();
            int number = sc.nextInt();
            org.jsoup.nodes.Document doc = Jsoup.connect(url).get();
            org.jsoup.select.Elements links;
            links = doc.select("a");
            File name =new File("C:\\Users\\Swappy\\Documents\\urls");
            FileWriter fw = new FileWriter(name);
            
                BufferedWriter bf = new BufferedWriter(fw);
            
            int site_count =0;
            for(org.jsoup.nodes.Element e: links){
                if(site_count==50)
                    break;
                String s=e.attr("abs:href");
                bf.write(s);
                ++site_count;
                bf.newLine();
            }
            int f=0;
            BufferedReader br = new BufferedReader(new FileReader(name));
            if(site_count<50){
                url = br.readLine();
                while(url!=null){/*
                    doc = Jsoup.connect(url).get();
                    links = doc.select("a");
                    for(org.jsoup.nodes.Element e : links){
                        if(site_count==50){
                            f=1;
                            break;
                        }
                        String s = e.attr("abs:href");
                        bf.write(s);
                        ++site_count;
                        bf.newLine();
                    }
                    if(f==1)
                        break;*/
                    System.out.println(url);
                    br.readLine();
                }
            }
                bf.close();
                br.close();
                System.out.println("File Written");
            // TODO code application logic here
        } catch (IOException ex) {
            Logger.getLogger(Reader.class.getName()).log(Level.SEVERE, null, ex);
        }
        writer.writer();
    }
    
}
