package data;

import list.CDList;

public interface IFileHandler {
    public void loadCDFromFile(CDList list);
    public void saveToFile(CDList list);
}
