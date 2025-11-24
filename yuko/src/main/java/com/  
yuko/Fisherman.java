package com.yuko;

import com.google.inject.Inject;
import com.google.inject.name.Named;
/**
 * Клас, що представляє рибалку
 */
public class Fisherman {
    private String name;
    private String location;
    private CatchLog catchLog;
    private CatchLogService catchLogService;


    @Inject
    public void setCatchLogService(CatchLogService catchLogService) {
        this.catchLogService = catchLogService;
    }

    /**
     * Конструктор для створення нового рибалки
     */
    @Inject
    public Fisherman(@Named("fisherman.name") String name, CatchLogService catchLogService) {
        this.name = name;
        this.catchLog = new CatchLog(); // композиція
        this.catchLogService = catchLogService;
        System.out.println("Створено нового рибалку: " + name);
    }

    /**
     * Перевірка карти глибин
     */
    public void checkDepthMap() {
        System.out.println("Рибалка " + name + " перевіряє карту глибин");
    }

    /**
     * Перевірка точок кльову
     */
    public void checkFishingSpots() {
        System.out.println("Рибалка " + name + " перевіряє точки кльову");
    }

    /**
     * Реєстрація вилову в журналі
     */
    public void logCatch(String fish, double weight) {
        catchLog.addEntry(fish, weight);
        catchLogService.saveCatch(this.name, fish, weight);
        System.out.println("Рибалка " + name + " зареєстрував вилов: " + fish + ", вага: " + weight + " кг");
    }

    /**
     * Вихід на воду
     */
    public void startFishing(String location) {
        this.location = location;
        System.out.println("Рибалка " + name + " виходить на воду в локації: " + location);
    }
}