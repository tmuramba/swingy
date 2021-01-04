package com.app.views;

import com.app.model.*;

public class Style {
    public static  void print(String x){
        System.out.println(x);
    }

    public static void menu() {
        System.out.println("Do You Wish To Create A New Hero?");
        System.out.println("1. - New Hero?");
        System.out.println("2. - Load Previous Hero?");
        System.out.println("3. - Exit?");
    }

    public static void selectHero() {
        System.out.println("Choose Hero Class?");
        System.out.println("1. - Wizard?");
        System.out.println("2. - Tank?");
        System.out.println("3. - Samurai?");
    }

    public static void invalidSelection() {
        System.out.println("Please a valid option!");
    }

    public static void pressEnter() {
        System.out.print("\n" + "Please Press Enter!\n");
    }

    public static void menu2() {
        System.out.println("Please Select A Option?");
        System.out.println("1. - Start Game?");
        System.out.println("2. - Stats?");
        System.out.println("3. - Artifact?");
        System.out.println("4. - Save?");
        System.out.println("5. - Exit?");
    }

    public static void gameMenu2() {
        System.out.println("Please Select A Option?");
        System.out.println("1. - Start Game?");
        System.out.println("2. - Stats?");
        System.out.println("3. - Exit?");
    }

    public static void quiting() {
        System.out.println("Quitting!!!!!...");
    }

    public static void quit() {
        System.out.println("Do You Still Wish To Quit? Y/N");
    }

    public static void getDirection() {
        System.out.println("Which Direction Do You Wish To Move?");
        System.out.println("Left?");
        System.out.println("Right?");
        System.out.println("Up?");
        System.out.println("Down?");
    }

    public static void won() {
        System.out.println("!!!!!You Have Won!!!!");
    }

    public static void levelUp() {
        System.out.println("You Have Leveled Up!!!");
    }

    public static void lost() {
        System.out.println("You lost! Try Again Y/N?");
    }

    public static void display(Hero hero){
        if(hero.getArtifact() != 0){
            if(hero.getArtifact() == 1){
                System.out.println("Artifact:  Weapon + 10");
                System.console().readLine();
            }else if(hero.getArtifact() == 2){
                System.out.println("Artifact:  Armor + 15");
                System.console().readLine();
            }else {
                System.out.println("Artifact:  Helm + 12");
                System.console().readLine();
            }
        }else {
            System.out.println("No Artifacts Present");
            System.console().readLine();
        }
    }

    public static void stats(Hero hero) {
        System.out.println("Hero name:  " + hero.getName());
        System.out.println("Class:      " + hero.getHeroClass());
        System.out.println("Level:      " + hero.getLevel());
        System.out.println("Attack:     " + hero.getAtt());
        System.out.println("Defense:    " + hero.getDef());
        System.out.println("Health:     " + hero.getHp());
        System.out.println("Experience: " + hero.getExp());
    }

    public static void getName() {
        System.out.println("Enter Hero Name?");
    }

    public static void welcome() {
        System.out.println("!!!!! Welcome To The World Of Adventure !!!!");
    }

    public static void equip() {
        System.out.println("Do You Wish To Equip item ? # NOTE:: Items Do Not Add To Each Other!!!#");
        System.out.println("Y/N?");
    }

    public static void dropped(int val) {
        if (val == 1)
            System.out.println("Monster Dropped A Weapon!!");
        else if (val == 2)
            System.out.println("Monster Dropped A Armor!!");
        else
            System.out.println("Monster Dropped A Helm!!");
    } 

    public static void checkSave() {
        System.out.println("Please Make Sure You Have Saved!");
    }

    public static void encounter(int val) {
        if (val == 1) {
            System.out.println("You Have Met An Enemy");
            System.out.println("Do You Wish To Fight? Y/N");
        }
        else
            System.out.println("No Enemy Found!");
    }

    public static void run(int val) {
        if (val == 1)
            System.out.println("You Have Successfully Ran Away");
        else
            Style.print("Sorry You Can Not Run");
    }

    public static void mapCleared() {
        System.out.println("!!!!You Have Cleared This Map!!!!");
        System.out.println("Do You Still Wish To Play? Y/N?");
    }

    public static void loaded() {
        System.out.println("Load Complete!");
    }

    public static void fileError(int val) {
        if (val == 1)
            System.err.println("Oops! Please check for the presence of file in the path specified.");
        else
            System.err.println("Oops! Unable to read the file.");
    }

    public static void selectHeroClass() {
        System.out.println("!Please Select Class Of The Hero!");
    }

    public static void loading(int j, String[] data) {
        System.out.println(j + ". - " + data[0] + " " + data[1]);
    }
}