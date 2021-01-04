package com.app.controller;
import com.app.model.*;
import java.io.*;
import java.text.*;
import java.util.*;
import com.app.views.*;

public class GamePlay {
    Hero hero;
    int map[][];
    int k;

    public GamePlay(Hero hero){
        this.hero = hero;
    }

    public static int rando(int min, int max){
        int randnum;
        Random rand = new Random();
        randnum = rand.nextInt((max - min) + 1) + min;
        return randnum;
    }

    public void run(){
        int i = rando(1, 10);
        if(i <= 5){
            Style.run(2);
            Style.pressEnter();
            System.console().readLine();
            fight();
        }else{
            Style.run(1);
            Style.pressEnter();
            System.console().readLine();
            map[hero.getY()][hero.getX()] = 0;
            enemy();
        }

    }

    public void enemy(){
        if(hero.getX() < 0 || hero.getY() < 0 || hero.getX() >= k || hero.getY() >= k){
            Style.mapCleared();
            String ans = System.console().readLine();
            if(ans.equalsIgnoreCase("y"))
                map();
            else if(ans.equalsIgnoreCase("n")){
                menu2();
            }
        }
        if(map[hero.getY()][hero.getX()] == 1) {
            Style.encounter(1);
            String s = System.console().readLine().toLowerCase();
            if(s.equalsIgnoreCase("y")){
                fight();
            }else if(s.equalsIgnoreCase("n"))
                run();
            else{
                Style.invalidSelection();
                System.console().readLine();
                enemy();
            }
        }else{
            Style.encounter(2);
            Style.pressEnter();
            System.console().readLine();
        }
    }

    public void map(){
        int i = 0;
        int j;
        int rand;
        int level = hero.getLevel();
        k = (level - 1) * 5 + 10 - (level % 2);
        map = new int[k][k];
        while (i < k){
            j = 0;
            while (j < k){
                rand = rando(0, 4);
                if(rand == 3)
                    map[i][j] = 1;
                else
                    map[i][j] = 0;
                j++;
            }
            i++;
        }
        hero.setX(k / 2);
        hero.setY(k / 2);
        move();
    }


    public void move(){
        String side;
        if(map[hero.getY()][hero.getX()] == 1){
            enemy();
        }
        while (true && hero.getX() < k && hero.getY() < k && hero.getY() >= 0 && hero.getX() >= 0){
            Style.getDirection();
            side = System.console().readLine();
            if(side.equalsIgnoreCase("left")){
               hero.setX(hero.getX() - 1);
               enemy();
            }else if(side.equalsIgnoreCase("right")){
                hero.setX(hero.getX() + 1);
                enemy();
            }else if(side.equalsIgnoreCase("up")){
                hero.setY(hero.getY() - 1);
                enemy();
            }else if(side.equalsIgnoreCase("down")){
                hero.setY(hero.getY() + 1);
                enemy();
            }else {
                Style.invalidSelection();
                Style.pressEnter();
                System.console().readLine();
            }
        }
    }

    public void fight(){
        int i = 0;
        int j;
        int Hstats;
        int Mstats;
        Mstats = rando(190, 215);
        Mstats = Mstats + i;
        Hstats = hero.getAtt() + hero.getDef() + hero.getHp();
        if(hero.getArtifact() != 0)
            Hstats = Hstats + equip();
        Style.stats(hero);
        if(Hstats >= Mstats){
            Style.won();
            map[hero.getY()][hero.getX()] = 0;
            hero.setExp(hero.getExp() + 300 / hero.getLevel());
            j = (int) (hero.getLevel() * 1000 + Math.pow(2, (hero.getLevel() - 1)) * 450);
            int rand = rando(1, 10);
            if(rand >= 5) {
                Artifact();
            }
            if(hero.getExp() >= j) {
                Style.levelUp();
                hero.setLevel(hero.getLevel() + 1);
                hero.setAtt(hero.getAtt() + 10);
                hero.setHp(hero.getHp() + 10);
                hero.setDef(hero.getDef() + 10);
                i = i + 30;
                Style.pressEnter();
                System.console().readLine();
                move();
            }
            else
                move();;
        }else{
            Style.lost();
            String s = System.console().readLine().toLowerCase();
            if(s.equalsIgnoreCase("y")){
                move();
            }else {
                Style.quiting();
                menu2();
            }
        }
    }

    public void Artifact(){
        int rand = rando(1, 3);
        if(rand == 1){
            Style.dropped(1);
            Style.equip();
            String s = System.console().readLine();
            if(s.equalsIgnoreCase("y")){
                hero.setArti(1);
            }else if(s.equalsIgnoreCase("n")){

            }else {
                Style.invalidSelection();
                Artifact();
            }
        }else if(rand == 2){
            Style.dropped(2);
            Style.equip();
            String s = System.console().readLine();
            if(s.equalsIgnoreCase("y")){
                hero.setArti(2);
            }else if(s.equalsIgnoreCase("n")){

            }else {
                Style.invalidSelection();
                Artifact();
            }
        }else {
            Style.dropped(3);
            Style.equip();
            String s = System.console().readLine();
            if(s.equalsIgnoreCase("y")){
                hero.setArti(3);
            }else if(s.equalsIgnoreCase("n")) {

            }else {
                Style.invalidSelection();
                Artifact();
            }
        }
    }

    public int equip(){
        int send = 0;
        if(hero.getArtifact() == 1)
            send = 10;
        else if(hero.getArtifact() == 2)
            send = 15;
        else
            send = 12;
        return send;
    }

    public void menu2(){
        Style.menu2();
        int line = Integer.parseInt(System.console().readLine());
        if(line == 1){
            Style.welcome();
            System.console().readLine();
            map();
        }else if(line == 2){
            Style.stats(hero);
            Style.pressEnter();
            menu2();
        }else if(line == 3){
            Style.display(hero);
            menu2();
        }else if(line == 4){
            try {
                save();
            } catch (IOException e) {
                e.printStackTrace();
            }
            menu2();
        }else if(line == 5){
            Style.checkSave();
            Style.quit();
            String s = System.console().readLine();
            if(s.equalsIgnoreCase("y")){
                System.exit(0);
            }else if(s.equalsIgnoreCase("n")){
                menu2();
            }else {
                Style.invalidSelection();
                System.console().readLine();
                menu2();
            }
        }else {
            Style.invalidSelection();
            System.console().readLine();
            menu2();
        }
    }

    public void save() throws IOException {
        String data;
        if(hero.getName()!= null){
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            String now = formatter.format(date);
            data = hero.getName() + "," + now + "," + hero.getHeroClass() + "," + hero.getLevel() + "," + hero.getExp() + "," + hero.getAtt() + "," +
            hero.getDef() + "," + hero.getHp() + "," + hero.getArtifact();
            FileWriter fileWriter = new FileWriter("text.txt" , true);
            PrintWriter writer = new PrintWriter(fileWriter);
            writer.println(data);
            writer.close();
            System.console().readLine();
        }
    }
}
