/**
 * Клас, що представляє рибалку
 */
public class Fisherman {
    private String name;
    private String location;
    private CatchLog catchLog;

    /**
     * Конструктор для створення нового рибалки
     */
    public Fisherman(String name) {
        this.name = name;
        this.catchLog = new CatchLog();
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