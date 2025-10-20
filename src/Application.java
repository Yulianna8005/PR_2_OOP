/**
 * Головний клас програми
 */
public class Application {
    public static void main(String[] args) {
        // Створення об'єктів
        Fisherman fisherman = new Fisherman("Петро");
        Sensor sensor = new Sensor("S001", "Озеро");
        Ecologist ecologist = new Ecologist("Марія");

        // Демонстрація роботи системи
        System.out.println("\n=== Початок риболовлі ===");
        
        // Рибалка перевіряє умови
        fisherman.checkDepthMap();
        fisherman.checkFishingSpots();
        
        // Вихід на воду
        fisherman.startFishing("Озеро");
        
        // Сенсори вимірюють параметри води
        sensor.measureTemperature();
        sensor.measureWaterQuality();
        
        // Еколог отримує дані
        ecologist.getWaterConditionReport(sensor);
        ecologist.analyzeEnvironment("Озеро");
        
        // Рибалка реєструє вилов
        fisherman.logCatch("Короп", 2.5);
        fisherman.logCatch("Щука", 3.0);
        
        System.out.println("\n=== Завершення риболовлі ===");
    }
}