package com.yuko;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList; 
import java.util.List; 

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class CatchLogService {
    private final Connection connection;


    /**
     * Конструктор з впровадженням залежності від драйвера бази даних.
     *
     * @param connection з'єднання з базою даних
     */

    @Inject
    public CatchLogService(Connection connection) {
        this.connection = connection;
    }




    /**
     * Зберегти запис про вилов у таблицю catches
     */
    public void saveCatch(String fisherman, String fish, double weight) {
        String sql = "INSERT INTO catches (fisherman, fish, weight, caught_at) VALUES (?, ?, ?, datetime('now'))";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, fisherman);
            ps.setString(2, fish);
            ps.setDouble(3, weight);
            ps.executeUpdate();
            System.out.println("Збережено запис у БД: " + fisherman + " - " + fish + " (" + weight + " кг)");
        } catch (SQLException e) {
            throw new RuntimeException("Не вдалося зберегти запис у базу", e);
        }
    }

    public List<CatchEntry> getAllCatches() {
        List<CatchEntry> catches = new ArrayList<>();
        // SQL-запит для читання всіх даних
        String sql = "SELECT id, fisherman, fish, weight, caught_at FROM catches ORDER BY caught_at DESC";
        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                catches.add(new CatchEntry(
                    rs.getInt("id"),
                    rs.getString("fisherman"),
                    rs.getString("fish"),
                    rs.getDouble("weight"),
                    rs.getString("caught_at")
                ));
            }
            System.out.println("Прочитано " + catches.size() + " записів вилову з бази даних.");
            return catches;

        } catch (SQLException e) {
            throw new RuntimeException("Не вдалося прочитати записи вилову з бази", e);
        }
    }
}
