package entities;

import entities.ientities.IAudioDisk;

public class GameAudioDisk implements IAudioDisk {
    private String id;
    private String title;
    private String publishYear;
    private double price;
    private String type = "AUDIO";
    private String collect = "GAME";

    public GameAudioDisk() {
    }

    public GameAudioDisk(String id, String title, String publishYear, double price) {
        this.id = id;
        this.title = title;
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
        return this.id + SEPARATOR + this.type + SEPARATOR + this.collect + SEPARATOR + this.title.toUpperCase()
                + SEPARATOR + this.publishYear + SEPARATOR + this.price;
    }

    @Override
    public String toTable() {
        return String.format(FORMAT_STRING, this.id,this.type,this.collect,this.title.toUpperCase(),this.publishYear,this.price);
    }
}
