package com.example.quanlive;
import com.example.quanlive.search.Searcher;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;

public class TicketManager {
    private ArrayList<VeMayBay> planeTickets = new ArrayList<>();
    private Searcher searcher;

    TicketManager() {
        File file = new File("src\\main\\resources\\com\\example\\quanlive\\database.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");
                planeTickets.add(new VeMayBay(data[0], Integer.parseInt(data[1]), data[2], data[3], Double.parseDouble(data[4]), data[5], data[6], data[7]));
            }
            scanner.close();
        } catch(Exception e) {
            System.out.println(e);
        }

    }

//    public void write( ArrayList list) {
//
//        Charset charset = Charset.forName("utf-8");
//        try(BufferedWriter bw = Files.newBufferedReader(Paths.get("src\\main\\resources\\com\\example\\quanlive\\database.txt"),charset)){
//            Iterator<String> it = list.iterator();
//            while(it.hasNext()){
//                String string = it.hasNext();
//                bw.append(string);
//                bw.newLine();
//            }}
//            catch(IOException e){
//                System.out.println(e.getMessage());
//            }
//        }
//    }

    // Getter method for plane tickets
    public ArrayList<VeMayBay> getPlaneTickets() {
        return planeTickets;
    }

    /**
     * Add plane ticket.
     * @param planeTicket vé mới
     */
    public void addPlaneTicket(VeMayBay planeTicket) {
        planeTickets.add(planeTicket);
    }

    /**
     * Setter method for searcher.
     */
    public void setSearcher(Searcher searcher) {
        this.searcher = searcher;
    }


    /**
     * Search by specific field.
     */
    public ArrayList<VeMayBay> search(String data) {
        System.out.println(searcher.search(data, planeTickets));
        return searcher.search(data, planeTickets);
    }

}
