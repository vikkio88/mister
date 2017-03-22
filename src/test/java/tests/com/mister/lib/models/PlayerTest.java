package tests.com.mister.lib.models;


import com.mister.lib.helpers.RandomFiller;
import com.mister.lib.models.Player;
import com.mister.lib.models.enums.Nationality;
import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.ThreadLocalRandom;


public class PlayerTest {

    @Test
    public void itHasExpectedFields() {
        String name = "Name";
        String surname = "Surname";
        int age = 21;
        Nationality nationality = Nationality.IT;

        Player player = new Player(
                name,
                surname,
                age,
                nationality
        );

        Assert.assertEquals(name, player.getName());
        Assert.assertEquals(surname, player.getSurname());
        Assert.assertEquals(age, player.getAge());
        Assert.assertEquals(nationality.getNationName(), player.getNationality().getNationName());
    }

    @Test
    public void itSetAverageSkillOnTheRightRange() {
        RandomFiller randomFiller = new RandomFiller();
    }
}
