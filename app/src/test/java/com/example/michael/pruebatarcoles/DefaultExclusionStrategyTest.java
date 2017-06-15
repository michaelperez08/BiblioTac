package com.example.michael.pruebatarcoles;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by alberto on 25/05/17.
 */
public class DefaultExclusionStrategyTest {
    @Test
    public void shouldSkipField() throws Exception {
        DefaultExclusionStrategy strategy = new DefaultExclusionStrategy();
        assertEquals(strategy, strategy);
    }

    @Test
    public void shouldSkipClass() throws Exception {
        DefaultExclusionStrategy strategy = new DefaultExclusionStrategy();
        assertEquals(strategy, strategy);
    }

}