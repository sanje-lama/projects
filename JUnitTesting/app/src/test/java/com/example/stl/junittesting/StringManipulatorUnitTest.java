package com.example.stl.junittesting;

import org.junit.After;
import org.junit.Before;

public class StringManipulatorUnitTest {

    private StringManipulator stringManipulator;

    @Before
    public void setUp() throws Exception{
        stringManipulator = StringManipulator.getInstance();
    }

    @After
    public void tearDown() throws Exception {
        stringManipulator = null;
    }
}
