import java.io.IOException;
import java.io.OutputStream;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class Soma implements HttpHandler{
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        try {
            String[] partes = exchange.getRequestURI().getPath().split("/");
            if (partes[(partes.length-1)].equals("java")) {
                byte[] resposta = "Tu que eh".getBytes();
                exchange.sendResponseHeaders(200, resposta.length);
                exchange.getResponseBody().write(resposta);
                return;
            } else {
                byte[] resposta = "A Bianca que eh".getBytes();
                exchange.sendResponseHeaders(200, resposta.length);
                exchange.getResponseBody().write(resposta);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            exchange.close();
        }
    }
    
}