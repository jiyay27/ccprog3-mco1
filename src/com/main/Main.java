/*********************************************************************************************************************
This is to certify that this project is our own work, based on our personal efforts in studying and applying the 
concepts learned. We have constructed the methods and their respective algorithms and corresponding code by 
ourselves. The program was run, tested, and debugged by our own efforts. We further certify that we have not copied in 
part or whole or otherwise plagiarized the work of other students and/or persons.
                                                                        
                                                                ARCEGA BEA ALEXIS ADJIE,        DLSU ID# 12209173
                                                                DONATO JOHN JOSEPH DEL ROSARIO, DLSU ID# 12206482
**********************************************************************************************************************/
package com.main;

import com.vendingview.menugui.MenuGui;
import com.vendingcontroller.MenuController;

public class Main {
    public static void main(String[] args) {
        MenuGui menu = new MenuGui();
        MenuController mainMenuController = new MenuController(menu);
        // new MenuGui();
    }
}
