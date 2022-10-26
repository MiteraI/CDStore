package factory.ifactory;

import entities.ientities.ICompactDisk;

public interface IDiskFactory {
    public ICompactDisk addGameDisk(String id, String title, String publishYear, String price);
    public ICompactDisk addMusicDisk(String id, String title, String publishYear, String price);
    public ICompactDisk addMovieDisk(String id, String title, String publishYear, String price);

}
