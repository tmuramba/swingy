package com.app.main;
import com.app.controller.*;

public class Play {
    public static void main(String args[]) {
        game game = new game();

        while (true)
            game.menu();
    }

}