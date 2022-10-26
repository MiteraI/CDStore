package factory;

import entities.GameVideoDisk;
import entities.MovieVideoDisk;
import entities.MusicVideoDisk;
import entities.ientities.ICompactDisk;
import factory.ifactory.IDiskFactory;
import tools.ParseMethod;

public class VideoDiskFactory implements IDiskFactory {
    
    @Override
    public ICompactDisk addGameDisk(String id, String title, String publishYear, String price) {
        return new GameVideoDisk(id,title,publishYear,ParseMethod.parseDouble(price));
    }

    @Override
    public ICompactDisk addMusicDisk(String id, String title, String publishYear, String price) {
        return new MusicVideoDisk(id,title,publishYear,ParseMethod.parseDouble(price));
    }

    @Override
    public ICompactDisk addMovieDisk(String id, String title, String publishYear, String price) {
        return new MovieVideoDisk(id,title,publishYear,ParseMethod.parseDouble(price));
    }
    
}
