/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agi.billpayment;

import com.agi.billpayment.Tagihan; 
import java.util.ArrayList;
import java.util.List; 

/**
 *
 * @author Agi
 */
public class User { 
    
    public String nama;
    public List<Tagihan> listTagihan; 
    
    public User() { 
        nama = "";
        listTagihan = new ArrayList<>();
    }
    public User(String Name) {
        this.nama = Name;
        listTagihan = new ArrayList<>();
    }
    
    public User(int Amount, String Name, Product product) {
        this.nama = Name;
        for (int i = 0; i < Amount; i++) {
            listTagihan.add(new Tagihan(product, new Tools().randomInt(100000, 1000000)));
        }
    }
    
    public void AddTagihan(Product product){ 
        listTagihan.add(new Tagihan(product, new Tools().randomInt(100000, 1000000)));
    }
}
