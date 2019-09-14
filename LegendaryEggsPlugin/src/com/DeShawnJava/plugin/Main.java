package com.DeShawnJava.plugin;

import org.bukkit.Bukkit;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEggThrowEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

    private EntityType higherType = EntityType.CHICKEN;
    private byte numHatches = 0;
    private boolean willHatch = false;


    @Override
    public void onDisable() {
        super.onDisable();
    }

    @Override
    public void onEnable() {
        super.onEnable();

        Bukkit.getPluginManager().registerEvents(this,this); // This has to be coded in order from events to be registered and EventsHandler to be ran.
    }

    @EventHandler
    public void onThrow(PlayerEggThrowEvent eggThrow) {

        Player player = eggThrow.getPlayer(); // This line create variable "player", such that "player" is the user who threw the egg
        setEggHatchEvent();
        eggThrow.setHatching(willHatch);
        eggThrow.setHatchingType(higherType);
        eggThrow.setNumHatches(numHatches);

    }

    private void setEggHatchEvent() {

        int randomBoundary2 = randomNum2(); // This upper portion of this method can be separated into its own method
        this.numHatches = 0;
        int numMobs = 0;

        if (randomBoundary2 > 0 && randomBoundary2 <= 80) {
            numMobs = 0;
        }
        if (randomBoundary2 > 80 && randomBoundary2 <= 86) {
            numMobs = 1;
        }
        if (randomBoundary2 > 86 && randomBoundary2 <= 91) {
            numMobs = 2;
        }
        if (randomBoundary2 > 91 && randomBoundary2 <= 95) {
            numMobs = 3;
        }
        if (randomBoundary2 > 95 && randomBoundary2 <= 98) {
            numMobs = 4;
        }
        if (randomBoundary2 > 98 && randomBoundary2 <= 100) {
            numMobs = 5;
        }

        //--------------------------------------------------------------------

        if (numMobs > 0) {
            byte amountOfType = (byte) numHatches;

            if (numMobs == 5) { //This category represents 2% of all egg throws
                hatchEntity(EntityType.PARROT, 0, 25);
                hatchEntity(EntityType.SPLASH_POTION,25,50);
                hatchEntity(EntityType.ENDERMITE,50,75);
                hatchEntity(EntityType.EXPERIENCE_ORB,75,100);
            }
            if (numMobs == 4) { //This category represents 3% of all egg throws
                hatchEntity(EntityType.BAT, 0, 33);
                hatchEntity(EntityType.SLIME, 33, 66);
                hatchEntity(EntityType.EGG, 66, 100);
                hatchEntity(EntityType.RABBIT,75,100);
            }
            if (numMobs == 3) { //This category represents 4% of all egg throws
                hatchEntity(EntityType.PARROT, 0, 20);
                hatchEntity(EntityType.PHANTOM, 20, 40);
                hatchEntity(EntityType.FOX, 40, 60);
                hatchEntity(EntityType.CAT, 60, 80);
                hatchEntity(EntityType.VILLAGER, 80, 100);

            }
            if (numMobs == 2) { //This category represents 5% of all egg throws
                hatchEntity(EntityType.VILLAGER, 0, 20);
                hatchEntity(EntityType.WOLF, 20, 30);
                hatchEntity(EntityType.HORSE, 30, 40);
                hatchEntity(EntityType.WANDERING_TRADER, 40, 60);
                hatchEntity(EntityType.PANDA, 60, 70);
                hatchEntity(EntityType.WITCH, 70, 75);
                hatchEntity(EntityType.EVOKER,75,77);
                hatchEntity(EntityType.HORSE, 80, 90); // Second code for Horse
                hatchEntity(EntityType.PIG_ZOMBIE, 90, 95);
                hatchEntity(EntityType.PILLAGER,95,100);
            }
            if (numMobs == 1) { //This category represents 6% of all egg throws
                hatchEntity(EntityType.IRON_GOLEM, 0, 11);
                hatchEntity(EntityType.LEASH_HITCH, 11, 25);
                hatchEntity(EntityType.RAVAGER, 25, 28);
                hatchEntity(EntityType.MULE, 28, 35);
                hatchEntity(EntityType.VILLAGER, 35, 45);
                hatchEntity(EntityType.SKELETON_HORSE,45, 50);
                hatchEntity(EntityType.CHICKEN, 50, 99);
                hatchEntity(EntityType.GIANT,99,100);
            }

            this.numHatches = (byte) numMobs;
        }
        else {
            this.numHatches = (byte) numMobs;
            this.willHatch = false;
        }
    }

    private static int randomNum() {
        double randomNum = Math.random() * 100;
        int choiceNum = (int) randomNum;
        return choiceNum;

    }

    private static int randomNum2() {
        double randomNum2 = Math.random() * 100;
        int choiceNum2 = (int) randomNum2;
        return choiceNum2;
    }

    private void hatchEntity(EntityType inputType, int min, int max) {
        if (randomNum() > min && randomNum() <= max) {
            this.higherType = inputType;
            this.willHatch = true;
        }
    }

    public static void main(String[] args) {

    }
}
