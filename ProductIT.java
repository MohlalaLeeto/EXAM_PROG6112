/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.main;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author leeto
 */
class ProductTest {

    private Product product;

    @BeforeEach
    void setUp() {
        String[] names = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
        int[][] sales = {
            {25, 18, 20},   
            {15, 10, 12},   
            {18, 15, 20}    
        };
        product = new Product(names, sales);
    }

    @Test
    void GetTotalProductSales_WithValidData_ReturnsCorrectValue() {
        assertEquals(153, product.GetTotalProductsSold());
    }

    @Test
    void GetAverageSales_WithValidData_ReturnsCorrectValue() {
        assertEquals(51.0, product.GetAverageProductSold(), 0.001);
    }

    @Test
    void GetMostPopularProduct_WithValidData_ReturnsCorrectValue() {
        assertEquals("Cozy Nights Monarch", product.GetMostPopularProduct());
    }
}
