package factory;

import entities.GameVideoDisk;
import entities.MovieVideoDisk;
import entities.MusicVideoDisk;
import entities.ientities.ICompactDisk;
import factory.ifactory.IDiskFactory;

public class VideoDiskFactory implements IDiskFactory {

    @Override
    public ICompactDisk createGameDisk() {
        // TODO Auto-generated method stub
        return new GameVideoDisk();
    }

    @Override
    public ICompactDisk createMusicDisk() {
        // TODO Auto-generated method stub
        return new MusicVideoDisk();
    }

    @Override
    public ICompactDisk createMovieDisk() {
        // TODO Auto-generated method stub
        return new MovieVideoDisk();
    }
    
}
