package menus;

import entities.*;
import util.Scanner;
import util.SingletonEntityManager;

public class MainMenu {

    Scanner sc = new Scanner();
    public void run(){
        Scanner sc = new Scanner();
        MainMenuHelper helper = new MainMenuHelper();
        int command;
        do {
            System.out.println("1)show the most payed coach\n" +
                    "2)show the most payed players per season\n" +
                    "3)show the each city and its team counts\n" +
                    "4)show each teams point per season\n" +
                    "5)show the champion per season\n" +
                    "6)exit");
            command = sc.getInt();
            switch (command){
                case 1:
                    helper.showMostPayedCoach();
                    break;
                case 2:
                    helper.showMostPayedPlayersPerSeason();
                    break;
                case 3:
                    helper.showCityAndTeams();
                    break;
                case 4:
                    System.out.println("enter year:");
                    helper.showTeamPoints(sc.getInt());
                    break;
                case 5:
                    System.out.println("enter year:");
                    helper.showChampion(sc.getInt());
                    break;
                case 6:
                    System.out.println("bye!");
                    SingletonEntityManager.close();
                    break;
                default:
                    System.out.println("invalid command");
            }
        }while (command!=6);
    }


}
