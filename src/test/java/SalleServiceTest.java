import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.marouane.models.Salle;
import org.marouane.services.SalleServiceImpl;

public class SalleServiceTest {

    SalleServiceImpl salleService;
    Salle salle;

    @Before
    public void setUp() {
        salleService = new SalleServiceImpl();
        salle = new Salle();
        salle.setCode("LI 41");

        salleService.create(salle);
    }

    @After
    public void tearDown() {
        Salle foundSalle = salleService.findById(salle.getId());
        if (foundSalle != null) {
            salleService.delete(foundSalle);
        }
    }

    // Test create method
    @Test
    public void testCreate() {
        assertNotNull("Salle is not created", salle.getId());
    }

    // Test find salle by id
    @Test
    public void testFindById() {
        Salle foundSalle = salleService.findById(salle.getId());
        assertNotNull("Salle is not found", foundSalle);
        assertEquals("Salle code is not found", salle.getCode(), foundSalle.getCode());
    }

    // Test update salle
    @Test
    public void testUpdate() {
        salle.setCode("LI 42");
        salleService.update(salle);

        Salle updatedSalle = salleService.findById(salle.getId());
        assertEquals("Salle code is not updated", salle.getCode(), updatedSalle.getCode());
    }

    // Test delete salle
    @Test
    public void testDelete() {
        boolean isDeleted = salleService.delete(salle);
        assertTrue("Salle is not deleted", isDeleted);

        Salle foundSalle = salleService.findById(salle.getId());
        assertEquals("Salle is not deleted", null, foundSalle);
    }

    // Test find all salles
    @Test
    public void testFindAll() {
        List<Salle> salles = salleService.findAll();
        assertNotNull("Salles are not found", salles);
        assertTrue("Salles are not found", salles.size() > 0);
        
    }

}
