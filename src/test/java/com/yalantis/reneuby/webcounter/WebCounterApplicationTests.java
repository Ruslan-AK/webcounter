package com.yalantis.reneuby.webcounter;

import com.yalantis.reneuby.webcounter.algorithm.CounterAlgorithm;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class WebCounterApplicationTests {

    @Test
    public void counterTest() {
        CounterAlgorithm algorithm = new CounterAlgorithm();
        String url1 = "/";
        String url2 = "/counter";
        String id1 = "id1";
        String id2 = "id2";
        String id3 = "id3";
//      User with id1 goes to /
        algorithm.doFilter(id1, url1);
//      Second user with id2 goes to /
        algorithm.doFilter(id2, url1);
        Assert.assertTrue("Now must be 0 users on /counter url", algorithm.getCount("/counter") == 0);
//      Third user with id3 goes to /counter
        algorithm.doFilter(id3, url2);
        Assert.assertTrue("Now must be 1 users on /counter url", algorithm.getCount("/counter") == 1);
//      Third user with id3 goes to /
        algorithm.doFilter(id3, url1);
        //User with id1 goes to /counter
        algorithm.doFilter(id1, url2);
//      Second user with id2 goes to /counter
        algorithm.doFilter(id2, url2);
        Assert.assertTrue("Now must be 2 users on /counter url", algorithm.getCount("/counter") == 2);
    }
}
