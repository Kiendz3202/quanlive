package com.example.quanlive.search;

import com.example.quanlive.VeMayBay;

import java.util.ArrayList;

public abstract class Searcher {
    public abstract ArrayList<VeMayBay> search(String data, ArrayList<VeMayBay> ticketlist);
}
