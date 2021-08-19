///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package Util;
//
//import Model.Employee;
//import View.DeleteEmployeeUI;
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.nio.file.Paths;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
///**
// *
// * @author david
// */
//public class DeleteProcess {
//
//    public boolean removeFileLine(String lineToRemove) throws FileNotFoundException, IOException {
//        
//        String basePathString = Paths.get("").toAbsolutePath().toString();
//        final String README = basePathString + "\\src\\main\\java\\Demo\\README.txt";
//        File inputFile = new File(README);
//        File tempFile = new File("TempFile.txt");
//
//        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
//        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
//
//        String currentLine;
//
//        while ((currentLine = reader.readLine()) != null) {
//            // trim newline when comparing with lineToRemove
//            if (currentLine.contains(lineToRemove)) {
//                continue;
//            }
//            writer.write(currentLine + "\n");
//        }
//
//        writer.close();
//
//        reader.close();
//        boolean successful = tempFile.renameTo(inputFile);
//        
//        return successful;
//    }
//
//}
