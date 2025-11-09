package ca.udem.maville;

import io.javalin.Javalin;

import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {

        Bank bank = new Bank("BanqUdem");
        bank.createAccount(new Account("12345"));
        bank.createAccount(new Account("54321"));

        Javalin app = Javalin.create(config -> {
            config.staticFiles.add("/public");
        }).start(7000);

        app.get("/api/hello_world", context -> {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Hello from the backend!");
            context.json(response);
        });

        app.get("/api/accounts", context -> {
            context.json(bank);
        });

        app.post("/api/transactions", context -> {
            Map<String, Object> data = context.bodyAsClass(Map.class);

            String compte1 = (String) data.get("compte1");
            String compte2 = (String) data.get("compte2");
            int montant = Integer.parseInt(data.get("montant").toString());
            bank.transaction(compte1, compte2, montant);
            context.json(Map.of("status", "ok", "message", "Transfer successful"));
        });

        app.post("/api/accounts", context -> {

        });

        app.get("/api/accounts/{id}", context -> {
        });

        app.delete("/api/accounts/{id}", context -> {

        });

        app.post("/api/operations", context -> {

        });






    }
}