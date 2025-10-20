/**
 * Клас, що представляє сенсор для вимірювання параметрів води
 */
public class Sensor {
    private String id;
    private String location;

    /**
     * Конструктор для створення нового сенсора
     */
    public Sensor(String id, String location) {
        this.id = id;
        this.location = location;
        System.out.println("Встановлено новий сенсор " + id + " в локації: " + location);
    }

    /**
     * Вимірювання температури води
     */
    public double measureTemperature() {
        System.out.println("Сенсор " + id + " вимірює температуру води");
        return 20.5; // Імітація вимірювання
    }

    /**
     * Вимірювання якості води
     */
    public String measureWaterQuality() {
        System.out.println("Сенсор " + id + " вимірює якість води");
        return "Хороша"; // Імітація вимірювання
    }

    /**
     * Отримання даних з сенсора
     */
    public String getSensorData() {
        return "Температура: " + measureTemperature() + "°C, Якість води: " + measureWaterQuality();
    }
}