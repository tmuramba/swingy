package com.app.model;

import com.app.views.*;

public class Hero {

    String name;
    String heroclass;
    public Boolean setSuccess = true;
    int level;
    int exp;
    int att;
    int def;
    int hp;
    int x;
    int y;
    int aritifact;

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    } 

    public int getArtifact() {
        return this.aritifact;
    }

    public int getLevel() {
        return this.level;
    }

    public int getAtt() {
        return this.att;
    }

    public int getDef() {
        return this.def;
    }

    public int getHp() {
        return this.hp;
    }

    public int getExp() {
        return this.exp;
    }

    public String getName() {
        return this.name;
    }

    public String getHeroClass() {
        return this.heroclass;
    }

    public void setvalue(String name, int type) {
        setSuccess = true;
        if (type == 1) {
            this.name = name;
            this.heroclass = "Wizard";
            this.att = 60;
            this.def = 50;
            this.hp = 100;
            this.level = 1;
            this.exp = 0;
        }
        else if (type == 2) {
            this.name = name;
            this.heroclass = "Tank";
            this.att = 20;
            this.def = 60;
            this.hp = 140;
            this.level = 1;
            this.exp = 0;
        }
        else if (type == 3) {
            this.name = name;
            this.heroclass = "Samurai";
            this.att = 80;
            this.def = 25;
            this.hp = 110;
            this.level = 1;
            this.exp = 0;
        }
        else {
            Style.selectHeroClass();
            setSuccess = false;
        }
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAtt(int att) {
        this.att = att;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setArti(int arti) {
        this.aritifact = arti;
    }

    public void setHeroClass(String cls) {
        this.heroclass = cls;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }
}
