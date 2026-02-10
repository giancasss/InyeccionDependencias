package es.iesquevedo.config;

import es.iesquevedo.dao.JsonSocioDaoImpl;
import es.iesquevedo.dao.JsonSocioDao;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

@ApplicationScoped
public class ConfigProducer {

    @Produces
    public JsonSocioDao produceJsonSocioDao() {
        String path = System.getProperty("socios.file", "socios.json");
        return new JsonSocioDaoImpl(path);
    }
}