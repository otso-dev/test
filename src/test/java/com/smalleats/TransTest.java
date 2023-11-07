package com.smalleats;

import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

public class TransTest {
    @Test
    @Transactional
    public void test(){
        System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
    }
}
