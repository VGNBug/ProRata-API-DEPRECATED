package com.prorata.api.rest.controller;

import com.prorata.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Daniel Pawsey on 9/12/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)   // 1
@SpringApplicationConfiguration(classes = Application.class)   // 2
@WebAppConfiguration   // 3
@IntegrationTest("server.port:0")   // 4
public class ProrataUserControllerIntegrationTest {

    final RestTemplate template = new RestTemplate();
    final ProrataUserRestController controller = new ProrataUserRestController();

    @Test
    public static void testCreate()
    {
        // TODO implement
    }

    @Test
    public static void testRead()
    {
        // TODO implement
    }

    @Test
    public static void testUpdate()
    {
        // TODO implement
    }

    @Test
    public static void testDelete()
    {
        // TODO implement
    }
}
