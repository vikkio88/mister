package tests.com.mister.lib.helpers;

import com.mister.lib.helpers.RandomFiller;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RandomFillerTest {
    @Test
    public void itReturnsARandomNumberWithinALimit() {
        int times = 20;
        int high = 100;
        for (int i = 0; i < times; i++) {
            Assert.assertTrue(RandomFiller.rand(high) < high);
        }
    }

    @Test
    public void itReturnsARandomNumberWithinARange() {
        int times = 20;
        int high = 100;
        int low = 80;
        for (int i = 0; i < times; i++) {
            Assert.assertTrue(RandomFiller.rand(low, high) <= high);
            Assert.assertTrue(RandomFiller.rand(low, high) >= low);
        }
    }

    @Test
    public void chanceReturnsValidOutput() {
        int times = 100;
        for (int i = 0; i < times; i++) {
            Assert.assertTrue(RandomFiller.chance(100));
        }
    }
}
