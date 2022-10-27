package service.iservice;

import list.CDList;

public interface IPrinter {
    void printList(CDList list);
    void printByTitle(CDList list);
    void printByType(CDList list); 
}
