import java.io.IOException;
import java.io.OutputStream;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class OperacaoSoma implements HttpHandler {
    public void handle(HttpExchange exchange) throws IOException {
        try {
            String[] partes = exchange.getRequestURI().getPath().split("/");
            for (int i = 0; i < (partes.length-1); i++) {
                byte[] resposta = partes[i].getBytes();
            }
            
            //OutputStream corpoResposta = exchange.getResponseBody();
            //exchange.sendResponseHeaders(200, resposta.length);
            //corpoResposta.write(resposta);
            /* for(int i = 1; i <= partes.length; i++) {
                int soma = 0;
                if(i == partes.length) {
                    soma = soma + Integer.parseInt(partes[i-1]);
                    soma = soma + Integer.parseInt(partes[i]);
                    String somaString = Integer.toString(soma);
                    byte[] resposta = somaString.getBytes();
                    exchange.sendResponseHeaders(200, resposta.length);
                    exchange.getResponseBody().write(resposta);
                    return;
                }
            }*/
            return;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            exchange.close();
        }
    }
}
