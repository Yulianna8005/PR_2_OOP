package com.yuko;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
