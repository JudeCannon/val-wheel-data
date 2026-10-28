import java.user;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public String ReadFile(path Path){
    try {
        String content = Files.readString(path);
        return content;
    } catch (IOException e) {
        e.printStackTrace();
        return null;
    }
}
class Agent{
    protected user User;
    String name;
    double HS;
    double WR;
    double KD;
    int perfScore;
    static int gamesPlayed;
    Path agentPath;

    public Agent(String name, user User){
        this.user = User;
        this.name = name;
        this.agentPath = Files.createDirectories(Path.of(user.getName() + "/agents/" + name));

        try {
            if (!Files.exists(agentPath)) {
                Files.createFile(agentPath);
            }else{
                System.out.println("Agent file already exists.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally{
            this.HS = 0;
            this.WR = 0;
            this.KD = 0;
            this.perfScore = 0;
            this.gamesPlayed = 0;
        }
    }
    public void addData(path: Path){
        String content = ReadFile(path);
        String[] lines = content.split("\n");
        for (String line : lines) {
            String[] stats = line.split(":");
            double tempHS = this.HS * gamesPlayed;
            double tempWR = this.WR * gamesPlayed;
            double tempKD = this.KD * gamesPlayed;
            int perfScore = this.perfScore * gamesPlayed;
            gamesPlayed++;
            this.HS = (tempHS + stats[1]) / gamesPlayed;
            this.WR = (tempWR + stats[2]) / gamesPlayed;
            this.KD = (tempKD + stats[3]) / gamesPlayed;
            this.perfScore = (perfScore + stats[4]);
            if (this.perfScore < 0) {
                this.perfScore = 0;
            } else if (this.perfScore > 500) {
                this.perfScore = 500;
            }
        }
    } 
}

class Sentinel extends Agent{
    public Sentinel(String name, user: User){
        super(name, user);
    }
}
class Duelist extends Agent{
    public Duelist(String name, user: User){
        super(name, user);
    }
}
class Initiator extends Agent{
    public Initiator(String name, user: User){
        super(name, user);
    }
}
class Controller extends Agent{
    public Controller(String name, user: User){
        super(name, user);
    }
}