package service;

import data.FileHandler;
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
        // TODO Auto-generated method stub
        boolean choice = false;
        do {
            char type = ParseMethod.readType("Type of CD to add ", ICreator.type);
            switch (type) {
                case 'V' -> {
                    char collection = ParseMethod.readType("Collection of CD to add ", ICreator.collection);
                    switch (collection) {
                        case 'G' -> {
                            addDiskInfo();
                            list.add(videoDiskFactory.addGameDisk("VG" + id, title, publishYear, price));
                        }
                        case 'F' -> {
                            addDiskInfo();
                            list.add(videoDiskFactory.addMovieDisk("VF" + id, title, publishYear, price));
                        }
                        case 'M' -> {
                            addDiskInfo();
                            list.add(videoDiskFactory.addMusicDisk("VM" + id, title, publishYear, price));
                        }
                        default -> {
                            choice = ParseMethod.readBool("Unsuccessful. Want to try again? ");
                        }
                    }
                }
                case 'A' -> {
                    char collection = ParseMethod.readType("Collection of CD to add ", ICreator.collection);
                    switch (collection) {
                        case 'G' -> {
                            addDiskInfo();
                            list.add(videoDiskFactory.addGameDisk("AG" + id, title, publishYear, price));
                        }
                        case 'F' -> {
                            addDiskInfo();
                            list.add(videoDiskFactory.addMovieDisk("AF" + id, title, publishYear, price));
                        }
                        case 'M' -> {
                            addDiskInfo();
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

    private void addDiskInfo() {
        this.id = ParseMethod.readPattern("Enter disk's id: ", ICreator.ID_FORMAT);
        this.title = ParseMethod.readNonBlank("Enter disk's title: ");
        this.publishYear = ParseMethod.readPattern("Enter disk's publish year: ", ICreator.YEAR_FORMAT);
        this.price = Double.toString(ParseMethod.readRangeDouble("Enter disk's unit price: ", 0, 50));
    }

    public static void main(String[] args) {
        CDList list = new CDList();
        ICreator creator = new Creator();
        creator.addDisk(list);
        for (Object stuff:list) System.out.println(stuff.toString());
        FileHandler fh = new FileHandler();
        fh.saveToFile(list);
    }
}
