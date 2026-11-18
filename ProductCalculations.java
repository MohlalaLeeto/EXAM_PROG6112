/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.datalogger;

/**
 *
 * @author leeto
 */
public class ProductCalculations implements IProductCalculations {

    // 15% and 5% of prices
    private static final double VAT_RATE = 0.15;         
    private static final double COMMISSION_RATE = 0.05;  

    
    private final double price;
    public ProductCalculations(double price) {
        this.price = price;
    }
    

    @Override
    public double GetVat() {
        return price * VAT_RATE;
    }

    @Override
    public double GetCommission() {
        return price * COMMISSION_RATE;
    }

    // Total Sale Amount = Price + VAT + Commission
    @Override
    public double GetTotal() {
        return price + GetVat() + GetCommission();
    }
}
