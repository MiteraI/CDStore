package factory;

import entities.GameAudioDisk;
import entities.MovieAudioDisk;
import entities.MusicAudioDisk;
import entities.ientities.ICompactDisk;
import factory.ifactory.IDiskFactory;

public class AudioDiskFactory implements IDiskFactory {

    @Override
    public ICompactDisk createGameDisk() {
        // TODO Auto-generated method stub
        return new GameAudioDisk() ;
    }

    @Override
    public ICompactDisk createMusicDisk() {
        // TODO Auto-generated method stub
        return new MusicAudioDisk();
    }

    @Override
    public ICompactDisk createMovieDisk() {
        // TODO Auto-generated method stub
        return new MovieAudioDisk();
    }
    
}
