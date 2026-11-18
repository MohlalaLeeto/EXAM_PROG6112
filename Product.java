/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author leeto
 */


public class Product implements IProduct {

    private final String[] productNames;
    private final int[][] monthlySales;

    public Product(String[] productNames, int[][] monthlySales) {
        this.productNames = productNames;
        this.monthlySales = monthlySales;
    }

    //Adding three mothns of one product sales
    private int getSalesForProduct(int productIndex) {
        int sum = 0;
        for (int sales : monthlySales[productIndex]) {
            sum = sum + sales;
        }
        return sum;
    }

    
    // Units of all products sold on all the months
    @Override
    public int GetTotalProductsSold() {
        int total = 0;
        for (int p = 0; p < productNames.length; p++) {
            total = total + getSalesForProduct(p);
        }
        return total;
    }

    //The Average units sold per product 
    @Override
    public double GetAverageProductSold() {
        
        return (double) GetTotalProductsSold() / productNames.length;
    }

    // Product with the highest total sales over the three months
    @Override
    public String GetMostPopularProduct() {
        int bestIndex = 0;
        for (int p = 1; p < productNames.length; p++) {
            if (getSalesForProduct(p) > getSalesForProduct(bestIndex)) {
                bestIndex = p;
            }
        }
        return productNames[bestIndex];
    }
}
