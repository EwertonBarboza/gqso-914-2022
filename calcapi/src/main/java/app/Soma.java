package app;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import io.jooby.annotations.*;
import io.jooby.exception.BadRequestException;

@Path("/soma/{num:\\d+}")
public class Soma {
    
    @GET
    public float calcularSoma(@PathParam List<String> num) {
        try {
            float soma = 0;
            
            for(int i = 0; i < num.size(); i++) {
                soma += Float.parseFloat(num.get(i));
            }

            return soma;
        } catch(NumberFormatException nfe) {
            throw new BadRequestException("Parâmetros inválidos: " + num);
        }
    }
}

/*  mvn jooby:run */