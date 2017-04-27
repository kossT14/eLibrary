/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author koss
 */
public class ID {
    
    private static final AtomicInteger ID_COUNTER = new AtomicInteger();

    static int createID() {
        return ID_COUNTER.incrementAndGet();
    }
}
