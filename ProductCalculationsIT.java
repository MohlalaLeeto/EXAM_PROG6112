/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.datalogger;

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
class ProductCalculationsTest {

    private IProductCalculations calculate;

    @BeforeEach
    void setUp() {
        calculate = new ProductCalculations(3500);
    }

    @Test
    void GetVat_WithValidData_ReturnsCorrectValue() {
        assertEquals(525.0, calculate.GetVat(), 0.001);
    }

    @Test
    void GetCommission_WithValidData_ReturnsCorrectValue() {
        assertEquals(175.0, calculate.GetCommission(), 0.001);
    }

    @Test
    void GetTotal_WithValidData_ReturnsCorrectValue() {
        assertEquals(4200.0, calculate.GetTotal(), 0.001);
    }
}
