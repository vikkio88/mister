package tests.com.mister.lib.helper;

import com.mister.lib.helpers.GameModel;
import com.mister.lib.helpers.RandomFiller;
import com.mister.lib.model.Team;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class GameModelTest {
    @Test
    public void saveAGameModelActuallyWritesAnReadFromDisk() {
        Team generatedTeam = RandomFiller.getTeam();
        GameModel.save(generatedTeam);
        Team loadedTeam = GameModel.loadOne(new Team().getSaveFileName());
        Assert.assertFalse(loadedTeam == null);
        Assert.assertEquals(generatedTeam.getName(), loadedTeam.getName());
        Assert.assertEquals(generatedTeam.getRoster().size(), loadedTeam.getRoster().size());
    }
}
