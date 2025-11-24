package com.yuko;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Names;

public class YukoModule extends AbstractModule {

    @Override
    protected void configure() {
        // JDBC URL для SQLite (файл буде у target/yuko.db)
        bind(String.class).annotatedWith(Names.named("JDBC URL"))
                .toInstance("jdbc:sqlite:target/yuko.db");

        // Ім'я рибалки для інжекції (можеш змінити або додати інші binding-и)
        bind(String.class).annotatedWith(Names.named("fisherman.name"))
                .toInstance("Діма");
    }

    @Provides
    @Singleton
    Connection provideConnection(@com.google.inject.name.Named("JDBC URL") String url) {
        try {
            Connection connection = DriverManager.getConnection(url);
            createTableIfNotExists(connection);
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException("Не вдалося створити підключення до БД", e);
        }
    }

    private void createTableIfNotExists(Connection connection) {
        String sql = "CREATE TABLE IF NOT EXISTS catches (" +
                     "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                     "fisherman TEXT, " +
                     "fish TEXT, " +
                     "weight REAL, " +
                     "caught_at TEXT)";
        try (Statement st = connection.createStatement()) {
            st.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException("Не вдалося створити таблицю catches", e);
        }
    }
}
