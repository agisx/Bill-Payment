/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agi.billpayment;

import com.agi.billpayment.Product;

/**
 *
 * @author Agi
 */
public class Tagihan {
    public int total;
    public Product product;
    public String kode; 
    public String status;
    public Tagihan(Product Product, int Total) {
        product = Product;
        total = Total;
        kode = String.valueOf(new Tools().randomInt(100000, 999999999));
        status = "Belum Lunas";
    }
}
