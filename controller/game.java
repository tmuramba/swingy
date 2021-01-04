package com.app.controller;
import java.io.*;
import com.app.views.*;
import com.app.model.*;

public class game {
    GamePlay gamePlay;
    Hero hero = new Hero();

    public game() {}

    public void menu() {
        Style.menu();
        int line = Integer.parseInt(System.console().readLine());
        if(line == 1) {
            creat();
        } else if(line == 2) {
            try {
                load();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else if(line == 3) {
            Style.quiting();
            System.exit(0);
        } else {
            Style.invalidSelection();
            menu();
        }
    }

    public void creat(){
        String name;
        Style.getName();
        name = System.console().readLine();
        while (true) {
            Style.selectHero();
            int type = Integer.parseInt(System.console().readLine());
            hero.setvalue(name, type);
            menu2();
            if (hero.setSuccess == true)
                break;
        }
        creat();

    }
    public void load() throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader("text.txt"));
        BufferedReader br = new BufferedReader(new FileReader("text.txt"));
        String line;
        String player;
        int j = 1;
        int k = 0;
        int num;
        try {
            while( (line = reader.readLine()) != null){
                String [] data = line.split(",");
                Style.loading(j, data);
                j++;
            }
            num = Integer.parseInt(System.console().readLine());
            num = num - 1;
            while ((player = br.readLine()) != null){
                if(k == num){
                    String [] info = player.split(",");
                    if(info.length == 9){
                        hero.setName(info[0]);
                        hero.setHeroClass(info[2]);
                        hero.setLevel(Integer.parseInt(info[3]));
                        hero.setExp(Integer.parseInt(info[4]));
                        hero.setAtt(Integer.parseInt(info[5]));
                        hero.setDef(Integer.parseInt(info[6]));
                        hero.setHp(Integer.parseInt(info[7]));
                        hero.setArti(Integer.parseInt(info[8]));
                        Style.loaded();
                        System.console().readLine();
                        menu2();
                    }
                }
                k++;
            }
        } catch (FileNotFoundException e) {
            Style.fileError(1);
            e.printStackTrace();
        } catch (IOException e) {
            Style.fileError(2);
            e.printStackTrace();
        }
        System.exit(0);
    }

    public void menu2(){
        Style.gameMenu2();
        int line = Integer.parseInt(System.console().readLine());
        if(line == 1){
            Style.welcome();
            System.console().readLine();
            gamePlay = new GamePlay(hero);
            gamePlay.map();
        }else if(line == 2){
            Style.stats(hero);
            Style.pressEnter();
            menu2();
        } else if(line == 3){
            System.exit(0);
        }
    }


}
