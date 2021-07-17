//package com.company;
//
//import java.io.BufferedWriter;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.PrintWriter;
//
//public class exp {
//    public static void main(String[] args) {
//
//        try (FileWriter f = new FileWriter("experiment.txt", true);
//             BufferedWriter b = new BufferedWriter(f);
//             PrintWriter p = new PrintWriter(b);) {
//
//            p.println("appending text into file");
//            p.println("Gaura");
//            p.println("Bori");
//            System.out.println("done");
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//    }
//
//}
