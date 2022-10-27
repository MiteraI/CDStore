package service;

import entities.ientities.ICompactDisk;
import list.CDList;
import service.iservice.IDeleter;
import tools.ParseMethod;

public class Deleter implements IDeleter {
    private String id;

    @Override
    public void deleteDisk(CDList list) {
        if (list.isEmpty()) {
            System.out.println("Empty list!");
            return;
        }
        this.id = ParseMethod.readPattern("Enter disk's id: ", ID_FORMAT);
        for (ICompactDisk disk : list) {
            if (!disk.getId().equals(id.toUpperCase())) {
                System.out.println("No disk with this id exist!");
                return;
            }
            list.remove(disk);
        }
    }
}
