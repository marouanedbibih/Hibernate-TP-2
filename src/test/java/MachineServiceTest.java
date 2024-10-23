import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.marouane.models.Machine;
import org.marouane.models.Salle;
import org.marouane.services.MachineServiceImpl;
import org.marouane.services.SalleServiceImpl;

public class MachineServiceTest {

    private MachineServiceImpl machineService;
    private Machine machine;
    private SalleServiceImpl salleService;
    private Salle salle;

    @Before
    public void setUp() {
        machineService = new MachineServiceImpl();
        machine = new Machine();
        machine.setRef("Machine 1");
        machine.setDateAchat(new Date());

        salleService = new SalleServiceImpl();
        salle = new Salle();
        salle.setCode("LI 41");

        salleService.create(salle);
        machine.setSalle(salle);
        machineService.create(machine);
    }

    @After
    public void tearDown() {
        Machine foundMachine = machineService.findById(machine.getId());
        if (foundMachine != null) {
            machineService.delete(foundMachine);
        }
        Salle foundSalle = salleService.findById(salle.getId());
        if (foundSalle != null) {
            salleService.delete(foundSalle);
        }
    }

    // Test create method
    @Test
    public void testCreate() {
        assertNotNull("Machine is not created", machine.getId());
    }

    // Test find machine by id
    @Test
    public void testFindById() {
        Machine foundMachine = machineService.findById(machine.getId());
        assertNotNull("Machine is not found", foundMachine);
        assertEquals("Machine is not found", machine.getRef(), foundMachine.getRef());
    }

    // Test update machine
    @Test
    public void testUpdate() {
        machine.setRef("Machine 2");
        boolean isUpdated = machineService.update(machine);
        assertTrue("Machine is not updated", isUpdated);
        Machine updatedMachine = machineService.findById(machine.getId());
        assertEquals("Machine ref is not updated", machine.getRef(), updatedMachine.getRef());
    }

    // Test delete machine
    @Test
    public void testDelete() {
        boolean isDeleted = machineService.delete(machine);
        assertTrue("Machine is not deleted", isDeleted);
        Machine foundMachine = machineService.findById(machine.getId());
        assertEquals("Machine is not deleted", null, foundMachine);
    }

    // Test find all machines
    @Test
    public void testFindAll() {
        List<Machine> machines = machineService.findAll();
        assertNotNull("Machines are not found", machines);
        assertTrue("Machines are not found", machines.size() > 0);
    }

    // Test find machine between two dates
    @Test
    public void testFindBetweenDate() {
        @SuppressWarnings("deprecation")
        List<Machine> machines = machineService.findBetweenDate(new Date(124, 0, 1), new Date());
        assertNotNull("Machines are not found", machines);
        assertTrue("Machines are not found", machines.size() > 0);
    }

}
