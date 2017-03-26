package tests.com.mister.lib.model;


import com.mister.lib.model.Coach;
import com.mister.lib.model.enums.Module;
import com.mister.lib.model.enums.Nationality;
import org.junit.Assert;
import org.junit.Test;


public class CoachTest {
    private String name = "Name";
    private String surname = "Surname";
    private int age = 61;
    private Nationality nationality = Nationality.IT;
    private Module module = Module.M442;

    @Test
    public void itHasExpectedFields() {
        Coach coach = getCoach();

        Assert.assertEquals(name, coach.getName());
        Assert.assertEquals(surname, coach.getSurname());
        Assert.assertEquals(age, coach.getAge());
        Assert.assertEquals(nationality.getNationName(), coach.getNationality().getNationName());
        Assert.assertEquals(module.getName(), coach.getModule().getName());
    }

    public Coach getCoach() {
        return new Coach(
                name,
                surname,
                age,
                nationality,
                module
        );
    }
}
