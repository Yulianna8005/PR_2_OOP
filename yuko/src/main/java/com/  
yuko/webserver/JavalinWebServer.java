package com.yuko.webserver;

import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.staticfiles.Location;

/**
 * Реалізація абстрактного WebServer на основі Javalin.
 */
public class JavalinWebServer extends WebServer {
    private final Javalin app;

    public JavalinWebServer() {
        this.app = Javalin.create(config -> {
            config.showJavalinBanner = false;

            // ВИПРАВЛЕННЯ ПОМИЛКИ 1 (cannot find symbol method add)
            // Використовуємо .directory, що коректно для Javalin 5.x.
            config.staticFiles.add(staticFiles -> {
                staticFiles.directory("src/main/resources", Location.EXTERNAL);
            });

            // КОНФІГУРАЦІЯ CORS (для доступу з локального index.html)
            config.plugins.enableCors(cors -> {
                cors.add(it -> {
                    it.anyHost(); // Дозволити запити з будь-якого джерела
                });
            });
        });
    }

    @Override
    public void start(int port) {
        app.start(port);
        System.out.println("──────────────────────────────────────────────");
        System.out.println("Yuko Web Server запущено!");
        System.out.println("REST API: http://localhost:" + port);
        System.out.println("Endpoint:");
        System.out.println("   GET  /api/catches - перегляд записів");
        System.out.println("──────────────────────────────────────────────");
    }

    // ВИПРАВЛЕННЯ ПОМИЛКИ 2 (method does not override or implement)
    @Override
    public void stop() {
        app.stop();
    }

    @Override
    public void before(RequestHandler handler) {
        app.before(context -> handler.handle(new JavalinHttpContext(context)));
    }

    @Override
    public void options(String path, RequestHandler handler) {
        app.options(path, context -> handler.handle(new JavalinHttpContext(context)));
    }

    @Override
    public void get(String path, RequestHandler handler) {
        app.get(path, context -> handler.handle(new JavalinHttpContext(context)));
    }

    @Override
    public void post(String path, RequestHandler handler) {
        app.post(path, context -> handler.handle(new JavalinHttpContext(context)));
    }
}