package test;

import entities.Salle;
import entities.Machine;
import services.MachineService;
import services.SalleService;
import util.HibernateUtil;

import java.util.Date;


public class Test {
    public static void main(String[] args) {
        SalleService ss = new SalleService();
        MachineService ms = new MachineService();

        // Création et insertion de salles
        Salle salle1 = new Salle("A1");
        Salle salle2 = new Salle("B2");
        ss.create(salle1);
        ss.create(salle2);

        // Création et insertion des machines
        Machine machine1 = new Machine("M123", new Date(), ss.findById(1));
        Machine machine2 = new Machine("M124", new Date(), ss.findById(2));
        ms.create(machine1);
        ms.create(machine2);

        //Affichage des salles et leurs machines
        for (Salle salle : ss.findAll()) {
            System.out.println("Salle: " + salle.getCode());

            for (Machine machine : salle.getMachines()) {
                System.out.println("  Machine: " + machine.getRef());
            }
        }

        // Utilisation de la méthode findBetweenDate
        Date d1 = new Date(110, 0, 1);
        Date d2 = new Date();

        System.out.println("Machines achetées entre " + d1 + " et " + d2 + ":");
        for (Machine machine : ms.findBetweenDate(d1, d2)) {
            System.out.printf("  %s achetée le %s%n", machine.getRef(), machine.getDateAchat());
        }
    }

    }

