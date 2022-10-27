package entities;

import entities.ientities.IAudioDisk;

public class GameAudioDisk implements IAudioDisk{
    private String id;
    private String title;
    private String publishYear;
    private double price;
   
    public GameAudioDisk() {}
    public GameAudioDisk(String id, String title, String publishYear, double price) {
        this.id = id;
        this. title = title;
        this.publishYear = publishYear;
        this.price = price;
    }
    /**
     * @return the id
     */
    @Override
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    @Override
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the title
     */
    @Override
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the publishYear
     */
    @Override
    public String getPublishYear() {
        return publishYear;
    }

    /**
     * @param publishYear the publishYear to set
     */
    @Override
    public void setPublishYear(String publishYear) {
        this.publishYear = publishYear;
    }

    /**
     * @return the price
     */
    @Override
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    @Override
    public void setPrice(double price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return this.id +";Audio;Game;"+this.title+";"+this.publishYear+";"+this.price;
    }
}
