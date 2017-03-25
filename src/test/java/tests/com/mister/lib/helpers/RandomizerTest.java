package tests.com.mister.lib.helpers;

import com.mister.lib.helpers.Randomizer;
import org.junit.Assert;
import org.junit.Test;

public class RandomizerTest {
    @Test
    public void itReturnsARandomNumberWithinALimit() {
        int times = 1000;
        int high = 100;
        for (int i = 0; i < times; i++) {
            Assert.assertTrue(Randomizer.intVal(high) < high);
        }
    }

    @Test
    public void itReturnsARandomNumberWithinARange() {
        int times = 20;
        int high = 100;
        int low = 80;
        for (int i = 0; i < times; i++) {
            Assert.assertTrue(Randomizer.intVal(low, high) <= high);
            Assert.assertTrue(Randomizer.intVal(low, high) >= low);
        }
    }

    @Test
    public void chanceReturnsValidOutput() {
        int times = 100;
        for (int i = 0; i < times; i++) {
            Assert.assertTrue(Randomizer.chance(100));
        }
    }
}
