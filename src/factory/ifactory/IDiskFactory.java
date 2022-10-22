package factory.ifactory;

import entities.ientities.ICompactDisk;

public interface IDiskFactory {
    public ICompactDisk createGameDisk();
    public ICompactDisk createMusicDisk();
    public ICompactDisk createMovieDisk();
}
