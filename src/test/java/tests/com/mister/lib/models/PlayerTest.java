package tests.com.mister.lib.models;


import com.mister.lib.model.Player;
import com.mister.lib.model.enums.Nationality;
import org.junit.Assert;
import org.junit.Test;


public class PlayerTest {
    private String name = "Name";
    private String surname = "Surname";
    private int age = 21;
    private Nationality nationality = Nationality.IT;

    @Test
    public void itHasExpectedFields() {
        Player player = getPlayer();

        Assert.assertEquals(name, player.getName());
        Assert.assertEquals(surname, player.getSurname());
        Assert.assertEquals(age, player.getAge());
        Assert.assertEquals(nationality.getNationName(), player.getNationality().getNationName());
    }

    @Test
    public void itSetAverageSkillOnTheRightRange() {
        int validValue = 50;
        Player testPlayer = getPlayer();
        testPlayer.setSkill(150);
        Assert.assertEquals(100, testPlayer.getSkill());
        testPlayer.setSkill(1);
        Assert.assertEquals(30, testPlayer.getSkill());
        testPlayer.setSkill(validValue);
        Assert.assertEquals(validValue, testPlayer.getSkill());
    }

    private Player getPlayer() {
        return new Player(
                name,
                surname,
                age,
                nationality
        );
    }
}
