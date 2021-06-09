/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.*;
import java.util.Date;
import java.util.Arrays;


/**
 *
 * @author Blaine Simpson
 * assginment3
 *  218020171
 * 
 * 
 */
public class Run {
 private String id, name, surname, birth, age;
 private ArrayList<Customer> cust = new ArrayList();
 private ArrayList<Supplier> sup = new ArrayList(); 
 private FileInputStream fr;
 private ObjectInputStream br;
 private BufferedWriter bw;
 private FileWriter fw;
 
 public void open(){
     try
     {
     fr = new FileInputStream("stakeholder.ser");
     br = new ObjectInputStream(fr);
     }
     catch(IOException fnfe)
             {
                 System.out.println("Not found");
                 System.out.println(fnfe);
                 System.exit(1);
             }
 }
     
     public void read()
     {
         try{
             Stakeholder stake;
             while(true){
                stake = (Stakeholder) br.readObject();
                if(stake instanceof Customer){
                    cust.add((Customer) stake);
                    
                }else if(stake instanceof Supplier){
                    sup.add((Supplier) stake);
             }
             }
         }catch(IOException | ClassNotFoundException io){
             System.out.println(io);
         }
         finally{
             close();
         }
        
     }
     
     public void close(){
     
     try{
         br.close(); 
     } 
     catch(IOException ieo)
     {
         System.out.println(ieo);
     } 
    }
     
     
     
    public void SortCustomer(){
     String[] SortCust = new String [cust.size()];
     ArrayList<Customer> Array = new ArrayList<Customer>();
     int length = cust.size();
     for (int i = 0; i < length; i++) {
         SortCust[i] = cust.get(i).getStHolderId();   
        }
        Arrays.sort(SortCust);
        for (int i = 0; i < length; i++) {
        if (SortCust[i].equals(cust.get(i).getStHolderId())){
        Array.add(cust.get(i));
        }
                
        }
       cust.clear();
       cust = Array;
       for(int i = 0;i<cust.size();i++){
           System.out.println(cust.get(i));  
       }
    }
     
    public void printlist(){
        
        
    System.out.println("============================CUSTOMERS==========================");
        System.out.println("Id               Name        Surname             Date of birth      Age           ");
        System.out.println("===============================================================");
        for (int i=0; i<cust.size(); i++){
            System.out.println(cust.get(i));
        }
           
       
        System.out.println("Number of customers who can rent:      ");
        System.out.println("Number of customers who cannot rent: ");
          
        
        System.out.println("");
       
        System.out.println("============================Suppliers==========================");
        System.out.println("Id      Name                Prod Type            Description           ");
        System.out.println("===============================================================");
        
        for (int i=0; i<sup.size(); i++)
            System.out.println(sup.get(i));
         
     }
    
   // public void textfile() {
     //   File File = new File ("CustomerOutFile.txt");
       // try{
         //   FileWriter fw = new FileWriter("CustomerOutFile.txt", true);
           // PrintWriter pw = new PrinterWriter(fw);
           // pw.println("============================CUSTOMERS==========================");
      //      pw.println("Id               Name        Surname             Date of birth      Age           ");
        //    pw.println("===============================================================");
         //   FileOutputStream fos = new FileOutputStream(file);
           // ObjectOutputStream oos = new ObjectOutputStream(fos);
           
            
          //  oos.writeObject (cust);
          //  out1.close
            //pw.close();
          //  System.out.println("customer print");
        //} 
        //catch(IOExeption e){
           
          //  e.printStackTrace();
        
        //}
    //}
   
    
   //public void rent(){
   //    for (int i = 0; i <boolArray.length; i++) {
           
   //    }
       
     

   
    
  public String Dateformat(Customer dob){
       LocalDate DateB = LocalDate.parse(dob.getDateOfBirth());
      DateTimeFormatter changeFormat = DateTimeFormatter.ofPattern("dd MMM yyyy");
      return DateB.format(changeFormat);
   }  
    
  public static void main(String[] args)
     {
         
    Run create = new Run();
    create.open();
    create.read();
    create.close();
  //  create.SortCustomer();
    create.printlist();
    
      
      
	}
      
    
  
     
   
         
    }
 

 
 


