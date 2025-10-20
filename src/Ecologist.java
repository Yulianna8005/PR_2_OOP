/**
 * Клас, що представляє еколога
 */
public class Ecologist {
    private String name;

    /**
     * Конструктор для створення нового еколога
     */
    public Ecologist(String name) {
        this.name = name;
        System.out.println("Зареєстровано нового еколога: " + name);
    }

    /**
     * Отримання звіту про стан водойми
     */
    public void getWaterConditionReport(Sensor sensor) {
        String sensorData = sensor.getSensorData();
        System.out.println("Еколог " + name + " отримав звіт про стан водойми:");
        System.out.println(sensorData);
    }

    /**
     * Аналіз екологічного стану
     */
    public void analyzeEnvironment(String location) {
        System.out.println("Еколог " + name + " аналізує екологічний стан водойми в локації: " + location);
    }
}