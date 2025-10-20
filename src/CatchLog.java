import java.util.ArrayList;
import java.util.List;

/**
 * Клас для ведення журналу вилову
 */
public class CatchLog {
    private List<String> entries;

    /**
     * Конструктор для створення нового журналу
     */
    public CatchLog() {
        this.entries = new ArrayList<>();
        System.out.println("Створено новий журнал вилову");
    }

    /**
     * Додавання запису про вилов
     */
    public void addEntry(String fish, double weight) {
        String entry = "Риба: " + fish + ", Вага: " + weight + " кг";
        entries.add(entry);
        System.out.println("Додано новий запис до журналу: " + entry);
    }

    /**
     * Отримання всіх записів
     */
    public List<String> getEntries() {
        System.out.println("Отримано всі записи з журналу");
        return entries;
    }
}