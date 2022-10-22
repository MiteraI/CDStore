package service.iservice;

import list.CDList;

public interface IPrinter {
    void printList(CDList list);
    void printAudioDisk(CDList list);
    void printVideoDisk(CDList list); 
}
