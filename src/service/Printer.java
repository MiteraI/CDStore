/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import entities.ientities.ICompactDisk;
import list.CDList;
import service.iservice.IPrinter;
import tools.ParseMethod;

/**
 *
 * @author Huynh Anh Kiet
 */
public class Printer implements IPrinter {

    @Override
    public void printList(CDList list) {
        if (list.isEmpty()) {
            System.out.println("Empty list!");
            return;
        }
        System.out.printf(ICompactDisk.FORMAT_HEADER,"  ID","TYPE","COLLECTION","NAME","YEAR","PRICE");
        for (ICompactDisk disk : list) {
            System.out.println(disk.toTable());
        }

    }

    @Override
    public void printByTitle(CDList list) {
        CDList tmpList = new CDList();
        String searchStr = ParseMethod.readNonBlank("Enter name to find: ");
        boolean nameFound = false;
        for (ICompactDisk disk : list) {
            if ((disk.getTitle()).contains(searchStr.toUpperCase())) {
                //System.out.println(searchStr + " is found at disk's id: " + disk.getId());
                nameFound = true;
                tmpList.add(disk);
            }
        }
        if (!nameFound) {
            System.out.print("\nName not in list\n");
            return;
        }
        System.out.printf(ICompactDisk.FORMAT_HEADER, "  ID", "TYPE", "COLLECTION", "NAME", "YEAR", "PRICE");
        for (ICompactDisk disk : tmpList) {
            System.out.println(disk.toTable());
        }
    }

    @Override
    public void printByType(CDList list) {
        if (list.isEmpty()) {
            System.out.println("Empty list!");
            return;
        }
        String message = "Enter type of disk to print " + IPrinter.type + " (leave blank to include all): ";
        char typeInput = ParseMethod.readChar(message, true, ' ');
        message = "Enter collection of disk to search " + IPrinter.collection + " (leave blank to include all): ";
        char collectInput = ParseMethod.readChar(message, true, ' ');
        String find = String.valueOf(typeInput) + String.valueOf(collectInput);
        find.trim();
        boolean exist = false;
        CDList tmpList = new CDList();
        for (ICompactDisk disk : list) {
            if (disk.getId().contains(find.toUpperCase().trim())) {
                tmpList.add(disk);
                exist = true;
            }
        }
        if (!exist) {
            System.out.println("No disk with this type exist!");
            return;
        }
        System.out.printf(ICompactDisk.FORMAT_HEADER, "  ID", "TYPE", "COLLECTION", "NAME", "YEAR", "PRICE");
        for (ICompactDisk disk : tmpList) {
            System.out.println(disk.toTable());
        }

    }

}
