package service.iservice;

import list.CDList;

public interface IUpdater {
    static final String ID_FORMAT = "[A-Za-z]{2}[0-9]{3}";
    static final String YEAR_FORMAT = "^(197\\d{1}|198\\d{1}|199\\d{1}|200\\d{1}|201\\d{1}|202\\d{1})";
    void updateDisk(CDList list);
}
