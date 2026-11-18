/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.datalogger;

/**
 *
 * @author leeto
 */

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class DataLogger {

    private static final String FILE_NAME = "data.txt";
    private static final String LINE = "**************************";
    

    //  Record of appends one sale 
    public static void main(String summary) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME, true))) {
            
            writer.println("DATA LOG");
            writer.println(LINE);
            writer.println(summary);
            writer.println(LINE);
            writer.println();
        }
    }
}
