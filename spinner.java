import java.util.Scanner;
import java.util.Random;
// Duelist = 1, Sentinel = 2, Initiator = 3, Controller = 4

public class spinner {
    public String spinning(int role, String[] agentList){
        int agent = 0;
        if (role == 1){
            Random rand = new Random();
            agent = rand.nextInt(8);
        }
        if (role == 2){
            Random rand = new Random();
            agent = rand.nextInt(6);
        }
        if (role == 3){
            Random rand = new Random();
            agent = rand.nextInt(7);
        }
        if (role == 4){
            Random rand = new Random();
            agent = rand.nextInt(7);
        }
        return agentList[agent];
    
    }


    public void main(String[] args) {
        String[] duelistList = {"Phoenix", "Jett", "Reyna", "Raze", "Yoru", "Neon", "Iso", "Waylay"};
        String[] sentinelList = {"Killjoy", "Cypher", "Sage", "Chamber", "Deadlock", "Vyse"};
        String[] initiatorList = {"Sova", "Breach", "Skye", "KAY/O", "Fade", "Gekko", "Tejo"};
        String[] controllerList = {"Brimstone", "Viper", "Omen", "Astra", "Harbor", "Clove", "Miks"};

        Scanner scanner = new Scanner(System.in);

        System.out.print("How many people are you spinning for?");
        int numPeople = scanner.nextInt();

        System.out.print("How many duelists are you spinning for?");
        int numDuelists = scanner.nextInt();

        System.out.print("How many sentinels are you spinning for?");
        int numSentinels = scanner.nextInt();

        System.out.print("How many initiators are you spinning for?");
        int numInitiators = scanner.nextInt();

        System.out.print("How many controllers are you spinning for?");
        int numControllers = scanner.nextInt();

        if (numDuelists + numSentinels + numInitiators + numControllers != numPeople) {
            System.out.println("The total number of agents does not match the number of people.");
            return;
        }
        for (int i = 0; i < numPeople; i++) {
            if (i+1 <= numDuelists) {
                String agent = spinning(1, duelistList);
                System.out.println("Person " + (i + 1) + " is a Duelist: " + agent);
            } else if (i + 1 <= numDuelists + numSentinels) {
                String agent = spinning(2, sentinelList);
                System.out.println("Person " + (i + 1) + " is a Sentinel: " + agent);
            } else if (i + 1 <= numDuelists + numSentinels + numInitiators) {
                String agent = spinning(3, initiatorList);
                System.out.println("Person " + (i + 1) + " is an Initiator: " + agent);
            } else {
                String agent = spinning(4, controllerList);
                System.out.println("Person " + (i + 1) + " is a Controller: " + agent);
            }
        }
    }
}