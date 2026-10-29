package src.java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

//  Lines of file: map,HS,WR,KD,perfScore 


class Agent{
    protected User user;
    String name;
    double HS;
    double WR;
    double KD;
    int perfScore;
    int gamesPlayed;
    Path agentPath;

    public Agent(String name, User user){
        this.user = user;
        this.name = name;
        try {
            this.agentPath = Files.createDirectories(Path.of(user.getName() + "/agents/" + name));
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

    public String ReadFile(Path path){
    try {
        String content = Files.readString(path);
        return content;
    } catch (IOException e) {
        e.printStackTrace();
        return null;
    }
}

    public void addData(Path path){
        String content = ReadFile(path);
        String[] lines = content.split("\n");
        for (String line : lines) {
            String[] stats = line.split(",");
            double tempHS = this.HS * gamesPlayed;
            double tempWR = this.WR * gamesPlayed;
            double tempKD = this.KD * gamesPlayed;
            int perfScore = this.perfScore * gamesPlayed;
            gamesPlayed++;
            this.HS = (tempHS + Double.parseDouble(stats[1])) / gamesPlayed;
            this.WR = (tempWR + Double.parseDouble(stats[2])) / gamesPlayed;
            this.KD = (tempKD + Double.parseDouble(stats[3])) / gamesPlayed;
            this.perfScore = (perfScore + Integer.parseInt(stats[4]));
            if (this.perfScore < 0) {
                this.perfScore = 0;
            } else if (this.perfScore > 500) {
                this.perfScore = 500;
            }
            

        }
    } 
}

class Sentinel extends Agent{
    public Sentinel(String name, User user){
        super(name, user);
    }
}
class Duelist extends Agent{
    public Duelist(String name, User user){
        super(name, user);
    }
}
class Initiator extends Agent{
    public Initiator(String name, User user){
        super(name, user);
    }
}
class Controller extends Agent{
    public Controller(String name, User user){
        super(name, user);
    }
}