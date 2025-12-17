package com.yuko;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.yuko.webserver.WebServer; // Клас, який був скопійований з прикладу
import com.yuko.webserver.HttpContext;

/**
 * Клас-вигляд, який реалізовує веб-інтерфейс відображення даних.
 * Використовує WebServer (Javalin) та CatchController. (Аналог PayrollWebView)
 */
@Singleton
public class CatchWebView {

    private final WebServer webServer;
    private final CatchController catchController;

    @Inject
    public CatchWebView(WebServer webServer, CatchController catchController) {
        this.webServer = webServer;
        this.catchController = catchController;
    }

    public void start(int port) {
        webServer.start(port);
        setupRoutes();
    }

    private void setupRoutes() {
        // Додаємо REST API endpoint для отримання записів вилову
        // Коли приходить GET-запит на /api/catches, викликається метод getAllCatches
        webServer.get("/api/catches", this::getAllCatches);
    }

    /**
     * Обробник запиту GET /api/catches.
     * Повертає список об'єктів CatchEntry у форматі JSON.
     */
    private void getAllCatches(HttpContext ctx) {
        // Отримуємо дані від контролера
        ctx.json(catchController.getAllCatches());
    }
}