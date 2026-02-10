package es.iesquevedo.dao;

import es.iesquevedo.modelo.Socio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class JsonSocioDaoImplTest {

    @TempDir
    Path tempDir;

    @Test
    void testRemoveSocio() {

        // 1️⃣ Crear archivo temporal
        String filePath = tempDir
                .resolve("socios.json")
                .toFile()
                .getAbsolutePath();

        JsonSocioDaoImpl dao = new JsonSocioDaoImpl(filePath);

        // 2️⃣ Crear socio ficticio (Mockito)
        Socio socioMock = mock(Socio.class);
        when(socioMock.getDni()).thenReturn("123");

        // 3️⃣ Guardar socio
        dao.save(socioMock);

        List<Socio> sociosAntes = dao.findAll();
        assertEquals(1, sociosAntes.size());

        // 4️⃣ Eliminar socio
        dao.remove(socioMock);

        // 5️⃣ Comprobar que ya no está
        List<Socio> sociosDespues = dao.findAll();
        assertTrue(
                sociosDespues.stream()
                        .noneMatch(s -> s.getDni().equals("123"))
        );
    }
}

