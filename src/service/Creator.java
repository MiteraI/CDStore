package service;

import entities.ientities.ICompactDisk;
import factory.ifactory.IDiskFactory;
import list.CDList;
import management.MainFactory;
import service.iservice.ICreator;
import tools.ParseMethod;

public class Creator implements ICreator {
    IDiskFactory audioDiskFactory = MainFactory.newAudioDiskFactory();
    IDiskFactory videoDiskFactory = MainFactory.newVideoDiskFactory();
    private String id;
    private String title;
    private String publishYear;
    private String price;

    @Override
    public void addDisk(CDList list) {
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
            this.id = ParseMethod.readPattern("Enter disk's id: ", ICreator.ID_FORMAT);
            exist = checkCode(list, this.id, type);
        } while (exist);
        this.title = ParseMethod.readNonBlank("Enter disk's title: ");
        this.publishYear = ParseMethod.readPattern("Enter disk's publish year: ", ICreator.YEAR_FORMAT);
        this.price = Double.toString(ParseMethod.readRangeDouble("Enter disk's unit price: ", 0, 50));
    }

    private boolean checkCode(CDList list, String id, String type) {
        for (ICompactDisk disk : list) {
            if (disk.getId().equals(type + id)) {
                System.out.println("Duplicated ID. Try again!");
                return true;
            }
        }
        return false;
    }
}
