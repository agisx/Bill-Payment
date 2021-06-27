/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agi.billpayment;

import java.util.*;

/**
 *
 * @author Agi
 */
public class BillManagement {
    public List<Product> productsList;
    public List<User> userList;
    int Amount;
    
    public BillManagement(int Amount) {
        if(productsList == null){ productsList = new ArrayList<>();}
        if(userList == null){ userList = new ArrayList<>();}
        
        for (int i = 0; i < Amount; i++) {
            Product product = new Product(ProductGenerator(i));
            productsList.add(product);
        }
        
        for (int i = 0; i < Amount; i++) {
            //sad 
            int randomTagihan = new Tools().randomInt(0, 3);
            
            User user = new User(NamesList(i));
            for (int j = 0; j < randomTagihan; j++) {
                user.AddTagihan(productsList.get(new Tools().randomInt(0, 3)));
            }
            userList.add(user);
        }
        this.Amount = Amount;
    }
    
    public List<Product> GetProductsList(){
        return productsList != null ? productsList : null;
    }
    
    public List<Product> SearchProducts(String ProductName){
        if(productsList.isEmpty()) return null;
        
        List<Product> products = new ArrayList<Product>();
        List<Integer> indexProducts = new ArrayList<>();
        for (int i = 0; i < productsList.size();i++) { 
            
            String product = productsList.get(i).nama.toLowerCase();
            ProductName.toLowerCase();
            
            boolean searchByProductName = product.contains(ProductName);
            if(searchByProductName){ 
                indexProducts.add(i);
                //System.out.println("Ditemukan");
                //System.out.println(entry.getKey().toString() + ":" + entry.getValue().nama);
            }
        }
        Collections.sort(indexProducts);
        
        for (int index : indexProducts) {  
            products.add(productsList.get(index)); 
        }
        
        return products;
    } 
    
    public int GetIndexProduct(Product Product){
        boolean emptyOrNot = productsList.isEmpty() || productsList != null;
        return emptyOrNot ? 0 : productsList.indexOf(Product);
    }
    
    public Product GetProductInformation(String ProductName){ 
        if(productsList.isEmpty()) return null;
        
        Product product = new Product();
        for (int i = 0; i < productsList.size();i++) {  
            boolean searchByProductName = productsList.get(i).nama == ProductName;
            if(searchByProductName){ 
                product = productsList.get(i);
                //System.out.println("Ditemukan");
                //System.out.println(entry.getKey().toString() + ":" + entry.getValue().nama);
            }
        }
        return product;
    }
    
    public User SearchUserOne(String UserName){ 
        if(userList.isEmpty()) return null;
        
        for (User user : userList) {  
            boolean searchByUserName = user.nama.contains(UserName);
            if(searchByUserName){  
                return user;
            }
        }
        return null;
    }
    
    public Product SearchProductOne(String ProductName){
        if(productsList.isEmpty()) return null; 
        
        for (Product product : productsList) {  
            boolean searchByProductName = product.nama.contains(ProductName);
            if(searchByProductName){  
                return product;
            }
        }
        return null;
    }
    
    public User GetTagihanByCode(String Code){ 
        for (int i = 0; i < userList.size(); i++) { 
            for (int j = 0; j < userList.get(i).listTagihan.size(); j++) {
                
                if(userList.get(i).listTagihan.get(j).kode.equals(Code)){
                    User user = new User(); 
                    
                    user.nama = userList.get(i).nama;
                    user.listTagihan.add(userList.get(i).listTagihan.get(j));
                    
                    return user;
                }
            }
        }
        return new User();
    }
    
    //public boolean  
    
    private String NameGenerator(){
        String [] names = {
            "Makara Suwarno", 
            "Lurhur Mandala", 
            "Padmi Safitri", 
            "Febi Hariyah", 
            "Amelia Haryanti", 
            "Arta Rajata", 
            "Ella Wahyuni", 
            "Prima Natsir", 
            "Eluh Ardianto", 
            "Tira Kusmawati" 
        };
        return names[new Tools().randomInt(0, 10)];
    }
    private String NamesList(int Index){
        String [] names = {
            "Makara Suwarno", 
            "Lurhur Mandala", 
            "Padmi Safitri", 
            "Febi Hariyah", 
            "Amelia Haryanti", 
            "Arta Rajata", 
            "Ella Wahyuni", 
            "Prima Natsir", 
            "Eluh Ardianto", 
            "Tira Kusmawati" 
        }; 
        return Index > names.length - 1 ? "" : names[Index];
    }
    
    private String ProductGenerator(int Index){
        String [] products = {
            "PLN", 
            "Marketpedia", 
            "Bukatoko", 
            "Pulsa", 
            "Paketan", 
            "Token Listrik",  
            "PBJS", 
            "Speedy", 
            "SPP Kuliah",
            "PDAM"
        };
        return Index > products.length - 1 ? "" : products[Index];
    }
}
