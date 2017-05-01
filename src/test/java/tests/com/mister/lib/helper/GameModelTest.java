package tests.com.mister.lib.helper;

import com.mister.lib.helpers.GameModel;
import com.mister.lib.helpers.RandomFiller;
import com.mister.lib.model.Team;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.List;

public class GameModelTest {
    private static final String FILE_SAMPLE = "fileSample.data";

    @After
    public void tearDown() {
        new File(FILE_SAMPLE).delete();
    }

    @Test
    public void saveAndLoadSingleTeamData() {
        Team generatedTeam = RandomFiller.getTeam();
        GameModel.save(generatedTeam, FILE_SAMPLE);
        Team loadedTeam = GameModel.loadOne(FILE_SAMPLE);
        Assert.assertFalse(loadedTeam == null);
        Assert.assertEquals(generatedTeam.getName(), loadedTeam.getName());
        Assert.assertEquals(generatedTeam.getRoster().size(), loadedTeam.getRoster().size());
    }

    @Test
    public void saveAndLoadMultipleTeamsData() {
        List<Team> generatedTeams = RandomFiller.getTeams(5);
        GameModel.save(generatedTeams, FILE_SAMPLE);
        List<Team> loadedTeams = GameModel.loadMany(FILE_SAMPLE);
        Assert.assertFalse(loadedTeams == null);
        Assert.assertEquals(generatedTeams.size(), loadedTeams.size());
        for (int i = 0; i < generatedTeams.size(); i++) {
            Assert.assertEquals(generatedTeams.get(i).getName(), loadedTeams.get(i).getName());
        }
    }
}
