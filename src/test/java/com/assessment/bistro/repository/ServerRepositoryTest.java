package com.assessment.bistro.repository;

import com.assessment.bistro.model.Server;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;
import java.util.Optional;


@SpringBootTest
public class ServerRepositoryTest {

    Server expectedRecord1;
    Server expectedRecord2;

    @Autowired
    private ServerRepository repo;

    @BeforeEach
    void setUp() {

        //Server1
        expectedRecord1 = new Server();
        expectedRecord1.setServerId(2);
        expectedRecord1.setFirstName("Zita");
        expectedRecord1.setLastName("McClintock");
        expectedRecord1.setHireDate(LocalDate.of(2022, 12, 5));
    }

    @Test
    void testGetServerById() {
        Optional<Server> serverWithIdOne = repo.findById(2);
        assertEquals(expectedRecord1.toString(), serverWithIdOne.get().toString());
    }

    @Test
    void testGetAllAvailableServers() {
        int servers = repo.findAll().size();
        assertEquals(22, servers);
    }

    @Test
    void testUpdateServer() {
        Optional<Server> server = repo.findById(1);
        server.get().setFirstName("UpdatedFirstName");
        server.get().setLastName("UpdatedLastName");

        repo.save(server.get());

        Optional<Server> updatedServer = repo.findById(1);
        assertEquals("UpdatedFirstName", updatedServer.get().getFirstName());
        assertEquals("UpdatedLastName", updatedServer.get().getLastName());
    }

    @Test
    void testAddServer() {

            Server newServer = new Server();
            newServer.setFirstName("New");
            newServer.setLastName("Person");
            newServer.setHireDate(LocalDate.of(2022, 12, 13));
            newServer.setTermDate(null);

            Server savedServer = repo.save(newServer);

            assertEquals("New", savedServer.getFirstName());
            assertEquals("Person", savedServer.getLastName());
            assertEquals(LocalDate.of(2022, 2, 13), savedServer.getHireDate());
        }
}
