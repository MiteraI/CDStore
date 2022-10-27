package service.iservice;

import list.CDList;

public interface IPrinter {
    static final String type = "[Audio/Video - A/V]";
    static final String collection = "[Game/Music/Film - G/M/F]";
    void printList(CDList list);
    void printByTitle(CDList list);
    void printByType(CDList list); 
}
