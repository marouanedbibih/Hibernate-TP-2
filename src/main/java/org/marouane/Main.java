package org.marouane;

import java.util.Date;

import org.marouane.models.Machine;
import org.marouane.models.Salle;
import org.marouane.services.MachineServiceImpl;
import org.marouane.services.SalleServiceImpl;

public class Main {
    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        SalleServiceImpl salleService = new SalleServiceImpl();
        MachineServiceImpl machineService = new MachineServiceImpl();

        // Create Salles
        Salle salle1 = new Salle("Salle 1");
        Salle salle2 = new Salle("Salle 2");
        Salle salle3 = new Salle("Salle 3");
        // Insert Salles
        salleService.create(salle1);
        salleService.create(salle2);
        salleService.create(salle3);

        // Create Machines
        Machine machine1 = new Machine("Machine 1", new Date(),salleService.findById(1L));
        Machine machine2 = new Machine("Machine 2", new Date(),salleService.findById(2L));
        Machine machine3 = new Machine("Machine 3", new Date(),salleService.findById(3L));

        // Insert Machines
        machineService.create(machine1);
        machineService.create(machine2);
        machineService.create(machine3);

        // Display Salles with Machines
        System.out.println("Salles with Machines");
        for (Salle salle : salleService.findAll()) {
            System.out.println(salle.getCode());
            for (Machine machine : salle.getMachines()) {
                System.out.println("\t" + machine.getRef());
            }
        }

        // Display Machines between date 2024-01-01 and today
        System.out.println("Machines between date 2024-01-01 and today");
        for (Machine machine : machineService.findBetweenDate(new Date(124, 0, 1), new Date())) {
            System.out.println(machine.getRef());
        }



    }
}