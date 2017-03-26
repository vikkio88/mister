package tests.com.mister.lib.helper;

import com.mister.lib.helpers.RandomFiller;
import org.junit.Assert;
import org.junit.Test;

public class RandomFillerTest {
    @Test
    public void itReturnsAValidTeamName() {
        String firstTeamName = RandomFiller.getTeamName();
        Assert.assertTrue(!firstTeamName.equals(""));
        String secondTeamName = RandomFiller.getTeamName();
        Assert.assertTrue(!firstTeamName.equals(secondTeamName));

        for (int i = 0; i < 20; i++) {
            System.out.println(RandomFiller.getTeamName());
        }
    }
}
