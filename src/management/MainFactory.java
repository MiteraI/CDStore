package management;

import factory.AudioDiskFactory;
import factory.VideoDiskFactory;
import factory.ifactory.IDiskFactory;
import list.CDList;
import service.Creator;
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
    final static CDList initList() {
        return new CDList();
    }
    public final static IDiskFactory newAudioDiskFactory() {
        return new AudioDiskFactory();
    }
    public final static IDiskFactory newVideoDiskFactory() {
        return new VideoDiskFactory();
    }
}
