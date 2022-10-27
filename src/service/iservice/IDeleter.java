package service.iservice;

import list.CDList;

public interface IDeleter {
    static final String ID_FORMAT = "[A-Za-z]{2}\\d{3}";
    public void deleteDisk(CDList list);
}
