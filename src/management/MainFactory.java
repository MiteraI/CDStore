package management;

import data.FileHandler;
import data.IFileHandler;
import factory.AudioDiskFactory;
import factory.VideoDiskFactory;
import factory.ifactory.IDiskFactory;
import list.CDList;
import service.Creator;
import service.Deleter;
import service.Printer;
import service.Updater;
import service.iservice.*;

public class MainFactory {
    final static ICreator newCreator() {
        return new Creator();
    }
    final static IPrinter newPrinter() {
        return new Printer();
    }
    final static IUpdater newUpdater() {
        return new Updater();
    }
    final static IDeleter newDeleter() {
        return new Deleter();
    }
    final static Menu newMenu() {
        return new Menu();
    }
    final static CDList initList() {
        return new CDList();
    }
    public final static IDiskFactory newAudioDiskFactory() {
        return new AudioDiskFactory();
    }
    public final static IDiskFactory newVideoDiskFactory() {
        return new VideoDiskFactory();
    }
    public final static IFileHandler newFileHandler() {
        return new FileHandler();
    }
}
