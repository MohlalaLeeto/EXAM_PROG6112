/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author leeto
 * 
 */
public class PrintProduct {

    private final IProduct product;

    public PrintProduct(IProduct product) {
        this.product = product;
    }
    

    public void printTotalProductSales() {
        System.out.println("Total products sold: " + product.GetTotalProductsSold());
    }

    
    public void printAverageProductSales() {
        System.out.printf("Average products sold per product: %.2f%n", product.GetAverageProductSold());
    }
    

    public void printMostPopularProduct() {
        System.out.println("Most popular product: " + product.GetMostPopularProduct());
    }
}
