package factory;

import entities.GameAudioDisk;
import entities.MovieAudioDisk;
import entities.MusicAudioDisk;
import entities.ientities.ICompactDisk;
import factory.ifactory.IDiskFactory;
import tools.ParseMethod;

public class AudioDiskFactory implements IDiskFactory {

    @Override
    public ICompactDisk addGameDisk(String id, String title, String publishYear, String price) {
        return new GameAudioDisk(id,title,publishYear,ParseMethod.parseDouble(price));
    }

    @Override
    public ICompactDisk addMusicDisk(String id, String title, String publishYear, String price) {
        return new MusicAudioDisk(id,title,publishYear,ParseMethod.parseDouble(price));
    }

    @Override
    public ICompactDisk addMovieDisk(String id, String title, String publishYear, String price) {
        return new MovieAudioDisk(id,title,publishYear,ParseMethod.parseDouble(price));
    }
}
