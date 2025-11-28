package ca.udem.maville;

import io.javalin.Javalin;

import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        int port = Integer.parseInt(
                System.getenv().getOrDefault("PORT", "7000")
        );
        Javalin app = Javalin.create(config -> {
            config.staticFiles.add("/public");
        }).start("0.0.0.0", port);
    }
}
