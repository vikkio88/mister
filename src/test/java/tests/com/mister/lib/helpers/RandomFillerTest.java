package tests.com.mister.lib.helpers;

import com.mister.lib.helpers.RandomFiller;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RandomFillerTest {
    RandomFiller randomFiller;

    @Before
    public void setUp() {
        randomFiller = new RandomFiller();
    }

    @Test
    public void itReturnsARandomNumberWithinARange() {
        int times = 20;
        int high = 100;
        for (int i = 0; i < times; i++) {
            Assert.assertTrue(randomFiller.rand(high) < high);
        }
    }
}
