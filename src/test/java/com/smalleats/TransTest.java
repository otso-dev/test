package com.smalleats;

import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

public class TransTest {
    @Test
    @Transactional
    public void test(){
        if(!TransactionSynchronizationManager.isActualTransactionActive()){
            System.out.println(true);
        }
    }
}
