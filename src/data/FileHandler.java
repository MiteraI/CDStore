package data;

import java.util.List;

import factory.ifactory.IDiskFactory;
import list.CDList;
import management.MainFactory;
import tools.FileMethod;

public class FileHandler implements IFileHandler{
    IDiskFactory audioDiskFactory = MainFactory.newAudioDiskFactory();
    IDiskFactory videoDiskFactory = MainFactory.newVideoDiskFactory();

    @Override
    public void loadCDFromFile(CDList list) {
        List<String> lines = FileMethod.readLinesFromFile("Database/Disk.txt");
        for(String line: lines) {
            String[] slice = line.split(";");
            switch(slice[0].charAt(0)) {
                case 'V'-> {
                    switch(slice[0].charAt(1)) {
                        case 'G' -> {
                            list.add(videoDiskFactory.addGameDisk(slice[0], slice[3], slice[4], slice[5]));
                        }
                        case 'F' -> {
                            list.add(videoDiskFactory.addMovieDisk(slice[0], slice[3], slice[4], slice[5]));
                        }
                        case 'M' -> {
                            list.add(videoDiskFactory.addMusicDisk(slice[0], slice[3], slice[4], slice[5]));
                        }
                    }
                }
                case 'A' -> {
                    switch(slice[0].charAt(1)) {
                        case 'G' -> {
                            list.add(audioDiskFactory.addGameDisk(slice[0], slice[3], slice[4], slice[5]));
                        }
                        case 'F' -> {
                            list.add(audioDiskFactory.addMovieDisk(slice[0], slice[3], slice[4], slice[5]));
                        }
                        case 'M' -> {
                            list.add(audioDiskFactory.addMusicDisk(slice[0], slice[3], slice[4], slice[5]));
                        }
                    }
                }
            }
        }
    }

    @Override
    public void saveToFile(CDList list) {
        FileMethod.writeFile("Database/Disk.txt", list);
    }
}
