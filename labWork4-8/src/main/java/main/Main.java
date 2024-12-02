package main;

import Interface.UserInterface;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Commands.Command;

public class Main {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Command.class);

        try{
            int a = 1 / 0;
            UserInterface ui = new UserInterface();
            ui.start();
            //throw new Exception("Симульована критична помилка в main");
        } catch (Exception e){
            logger.error("Виникла критична помилка", e);
        }
    }
}
