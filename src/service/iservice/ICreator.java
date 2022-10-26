package service.iservice;

import list.CDList;

public interface ICreator {
    static final String YEAR_FORMAT = "^(197\\d{1}|198\\d{1}|199\\d{1}|200\\d{1}|201\\d{1}|202\\d{1})";
    static final String ID_FORMAT = "\\d{3}";
    static final String type = "[Audio/Video - A/V]";
    static final String collection = "[Game/Music/Film - G/M/F]";

    public void addDisk(CDList list);
}
