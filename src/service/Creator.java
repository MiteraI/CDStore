package service;

import factory.ifactory.IDiskFactory;
import list.CDList;
import management.MainFactory;
import service.iservice.ICreator;

public class Creator implements ICreator{
    IDiskFactory AudioDiskFactory = MainFactory.newAudioDiskFactory();
    IDiskFactory VideoDiskFactory = MainFactory.newVideoDiskFactory();
    @Override
    public void addDisk(CDList list) {
        list.add(AudioDiskFactory.createGameDisk());
        list.add(VideoDiskFactory.createGameDisk());
        // TODO Auto-generated method stub
        
    }
    
}
