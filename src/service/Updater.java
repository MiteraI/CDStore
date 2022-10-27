/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import factory.ifactory.IDiskFactory;
import entities.ientities.ICompactDisk;
import list.CDList;
import management.MainFactory;
import service.iservice.ICreator;
import service.iservice.IUpdater;
import tools.ParseMethod;

/**
 *
 * @author Huynh Anh Kiet
 */
public class Updater implements IUpdater {
    IDiskFactory audioDiskFactory = MainFactory.newAudioDiskFactory();
    IDiskFactory videoDiskFactory = MainFactory.newVideoDiskFactory();
    private String id;
    private String title;
    private String publishYear;
    private String price;

    @Override
    public void updateDisk(CDList list) {
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
            addDisk(list);
            if (ParseMethod.readBool("Are you sure to change the disk's information? ")) {
                list.remove(disk);
                return;
            } else {
                list.remove(list.size() - 1);
                return;
            }
        }
    }

    private void addDisk(CDList list) {
        boolean choice = false;
        do {
            char type = ParseMethod.readType("Type of CD to add: ", ICreator.type);
            switch (type) {
                case 'V' -> {
                    char collection = ParseMethod.readType("Collection of CD to add: ", ICreator.collection);
                    switch (collection) {
                        case 'G' -> {
                            addDiskInfo(list, "VG");
                            list.add(videoDiskFactory.addGameDisk("VG" + id, title, publishYear, price));
                        }
                        case 'F' -> {
                            addDiskInfo(list, "VF");
                            list.add(videoDiskFactory.addMovieDisk("VF" + id, title, publishYear, price));
                        }
                        case 'M' -> {
                            addDiskInfo(list, "VM");
                            list.add(videoDiskFactory.addMusicDisk("VM" + id, title, publishYear, price));
                        }
                        default -> {
                            choice = ParseMethod.readBool("Unsuccessful. Want to try again? ");
                        }
                    }
                }
                case 'A' -> {
                    char collection = ParseMethod.readType("Collection of CD to add: ", ICreator.collection);
                    switch (collection) {
                        case 'G' -> {
                            addDiskInfo(list, "AG");
                            list.add(videoDiskFactory.addGameDisk("AG" + id, title, publishYear, price));
                        }
                        case 'F' -> {
                            addDiskInfo(list, "AF");
                            list.add(videoDiskFactory.addMovieDisk("AF" + id, title, publishYear, price));
                        }
                        case 'M' -> {
                            addDiskInfo(list, "AM");
                            list.add(videoDiskFactory.addMusicDisk("AM" + id, title, publishYear, price));
                        }
                        default -> {
                            choice = ParseMethod.readBool("Unsuccessful. Want to try again? ");
                        }
                    }
                }
                default -> {
                    choice = ParseMethod.readBool("Unsuccessful. Want to try again? ");
                }
            }
        } while (choice);
    }

    private void addDiskInfo(CDList list, String type) {
        boolean exist = true;
        do {
            this.id = ParseMethod.readPattern("Enter disk's id: ", "\\d{3}");
            exist = checkCode(list, this.id);
        } while (exist);
        this.title = ParseMethod.readNonBlank("Enter disk's title: ");
        this.publishYear = ParseMethod.readPattern("Enter disk's publish year: ", YEAR_FORMAT);
        this.price = Double.toString(ParseMethod.readRangeDouble("Enter disk's unit price: ", 0, 50));
    }

    private boolean checkCode(CDList list, String id) {
        for (ICompactDisk disk : list) {
            if (disk.getId().equals(id.toUpperCase())) {
                System.out.println("Duplicated ID. Try again!");
                return true;
            }
        }
        return false;
    }
}
