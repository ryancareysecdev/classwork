/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.util.Random;

/**
 *
 * @author david
 */
public class RandomGenerator {

    private Random random = new Random();
    
    public int generateCredit() {
        return random.nextInt(800 - 500) + 500;
    }
}
