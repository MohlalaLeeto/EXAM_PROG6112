/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.main;

/**
 *
 * @author leeto
 */
import java.util.Scanner;

public class SalesReportApp {
    
 
    private static final String[] PRODUCT_NAMES = {
        "Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"
    };
    private static final int MONTHS = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] sales = new int[PRODUCT_NAMES.length][MONTHS];
        

        // Capturing sales for every product and month
        for (int p = 0; p < PRODUCT_NAMES.length; p++) {
            for (int m = 0; m < MONTHS; m++) {
                sales[p][m] = readSales(scanner, m + 1, PRODUCT_NAMES[p]);
            }
            System.out.println();
        }

        // Calculating and displaying a report
        PrintProduct rep = new PrintProduct(new Product(PRODUCT_NAMES, sales));
        System.out.println("======= SALES REPORT=======");
        rep.printTotalProductSales();
        rep.printAverageProductSales();
        rep.printMostPopularProduct();
    }

    // Prompting until a valid positive whole number is entered
    private static int readSales(Scanner scanner, int month, String productName) {
        while (true) {
            System.out.print("Enter number of sales for month " + month + " for " + productName + " mattress: ");
            String text = scanner.nextLine().trim();
            try {
                int value = Integer.parseInt(text);
                if (value >= 0) {
                    return value;
                }
            } catch (NumberFormatException e) {
                
            }
            System.out.println("Invalid input. Please enter a whole number of 0 or more.");
        }
    }
}


    
    

