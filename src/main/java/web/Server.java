/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import dao.DbManageProducts;
import dao.ProductsCollectionDAOInterface;
import java.util.concurrent.CompletableFuture;
import org.jooby.Jooby;
import org.jooby.json.Gzon;

/**
 *
 * @author wiljo912
 */
public class Server extends Jooby {
    
    private DbManageProducts db = new DbManageProducts();

    public Server() {
        port(8080);
        //get("/", () -> "Hello World");
        get("/api/products", () -> db.getProducts());
        get("/api/products/:id", (req) -> {
            String id = req.param("id").value();
            return db.getThroughID(id);
        });
        
        use(new ProductModule(db));
        use(new Gzon());
    }
    

    public static void main(String[] args) throws Exception {
        System.out.println("\nStarting Server.");
        Server server = new Server();
        CompletableFuture.runAsync(() -> {
            server.start();
        });
        server.onStarted(() -> {
            System.out.println("\nPress Enter to stop the server.");
        });
        // wait for user to hit the Enter key
        System.in.read();
        System.exit(0);
    }
}