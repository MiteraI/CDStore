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
    private ICompactDisk cdUpdate;

    @Override
    public void updateDisk(CDList list) {
        boolean exist = false;
        cdUpdate = null;
        if (list.isEmpty()) {
            System.out.println("Empty list!");
            return;
        }
        this.id = ParseMethod.readPattern("Enter disk's id: ", ID_FORMAT);
        for (ICompactDisk compactDisk : list) {
            if (compactDisk.getId().equalsIgnoreCase(id)) {
                exist = true;
                cdUpdate = compactDisk;
                break;
            }
        }
        if (exist == false) {
            System.out.println("No disk with this id exist!");
            return;
        } else {
            if (!addDisk(list)) {
                System.out.println("Quit updating!");
                return;
            }
            if (ParseMethod.readBool("Are you sure to change the disk's information? ")) {
                list.remove(cdUpdate);
                return;
            } else {
                list.remove(list.size() - 1);
                return;
            }
        }
    }

    private boolean addDisk(CDList list) {
        boolean choice;
        boolean success;
        String message;
        do {
            choice = false;
            success = true;
            message = "New CD type " + ICreator.type + " (leave blank to skip): ";
            char type = ParseMethod.readChar(message, true, cdUpdate.getType().charAt(0));
            switch (type) {
                case 'V' -> {
                    message = "New collection name " + ICreator.collection + " (leave blank to skip): ";
                    char collection = ParseMethod.readChar(message, true, cdUpdate.getCollect().charAt(0));
                    switch (collection) {
                        case 'G' -> {
                            addDiskInfo(list);
                            list.add(videoDiskFactory.addGameDisk("VG" + id, title, publishYear, price));
                        }
                        case 'F' -> {
                            addDiskInfo(list);
                            list.add(videoDiskFactory.addMovieDisk("VF" + id, title, publishYear, price));
                        }
                        case 'M' -> {
                            addDiskInfo(list);
                            list.add(videoDiskFactory.addMusicDisk("VM" + id, title, publishYear, price));
                        }
                        default -> {
                            choice = ParseMethod.readBool("Unsuccessful. Try again? ");
                            success = choice;
                        }
                    }
                }
                case 'A' -> {
                    message = "New collection name " + ICreator.collection + " (leave blank to skip): ";
                    char collection = ParseMethod.readChar(message, true, cdUpdate.getCollect().charAt(0));
                    switch (collection) {
                        case 'G' -> {
                            addDiskInfo(list);
                            list.add(videoDiskFactory.addGameDisk("AG" + id, title, publishYear, price));
                        }
                        case 'F' -> {
                            addDiskInfo(list);
                            list.add(videoDiskFactory.addMovieDisk("AF" + id, title, publishYear, price));
                        }
                        case 'M' -> {
                            addDiskInfo(list);
                            list.add(videoDiskFactory.addMusicDisk("AM" + id, title, publishYear, price));
                        }
                        default -> {
                            choice = ParseMethod.readBool("Unsuccessful. Try again? ");
                            success = choice;
                        }
                    }
                }
                default -> {
                    choice = ParseMethod.readBool("Unsuccessful. Try again? ");
                    success = choice;
                }
            }
        } while (choice);
        return success;
    }

    private void addDiskInfo(CDList list) {
        String message = "New title (leave blank to skip): ";
        this.title = ParseMethod.readPattern(message, ParseMethod.REGEX_ANY);
        if (title.isEmpty())
            title = cdUpdate.getTitle();

        message = "New publish year (leave blank to skip): ";
        this.publishYear = ParseMethod.readPattern(message, YEAR_FORMAT + "|" + ParseMethod.REGEX_BLANK);
        if (publishYear.isEmpty())
            publishYear = cdUpdate.getPublishYear();

        message = "New unit price (leave blank to skip): ";
        this.price = Double.toString(ParseMethod.readRangeDouble(message, 0, 50, true, cdUpdate.getPrice()));
    }
}
