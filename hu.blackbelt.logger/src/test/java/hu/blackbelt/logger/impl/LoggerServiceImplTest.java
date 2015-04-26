package hu.blackbelt.logger.impl;

import org.junit.Before;
import org.junit.Test;

public class LoggerServiceImplTest {

    private LoggerServiceImpl target;

    @Before
    public void setUp() throws Exception {
        target = new LoggerServiceImpl();
    }

    @Test
    public void testInfo() throws Exception {
        System.out.println("sdf");
        target.info("safd");
    }

    @Test
    public void testWarning() throws Exception {

    }

    @Test
    public void testError() throws Exception {

    }

    @Test
    public void testDebug() throws Exception {

    }
}