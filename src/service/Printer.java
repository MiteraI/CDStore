/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.ArrayList;

import entities.ientities.ICompactDisk;
import list.CDList;
import service.iservice.IPrinter;
import tools.ParseMethod;;

/**
 *
 * @author Huynh Anh Kiet
 */
public class Printer implements IPrinter {

    @Override
    public void printList(CDList list) {
        for (ICompactDisk disk : list) {
            System.out.println(disk.toString());
        }

    }

    @Override
    public void printByTitle(CDList list) {
        ArrayList<String> infoList = new ArrayList<>();
        String searchStr = ParseMethod.readNonBlank("Enter name to find: ");
        boolean nameFound = false;
        for (ICompactDisk disk : list) {
            if ((disk.getTitle()).contains(searchStr)) {
                System.out.println(searchStr + " is found at disk's id: " + disk.getId());
                nameFound = true;
                infoList.add(disk.toString());
            }
        }
        if (!nameFound) {
            System.out.print("\nName not in list\n");
            return;
        }
        System.out.println(infoList);
    }

    @Override
    public void printByType(CDList list) {
        // TODO Auto-generated method stub

    }

}
