package entities;

import entities.ientities.IVideoDisk;

public class MovieVideoDisk implements IVideoDisk {
    private String id;
    private String title;
    private String publishYear;
    private double price;
    

    public MovieVideoDisk() {}
    public MovieVideoDisk(String id, String title, String publishYear, double price) {
        this.id = id;
        this. title = title;
        this.publishYear = publishYear;
        this.price = price;
    }
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the publishYear
     */
    public String getPublishYear() {
        return publishYear;
    }

    /**
     * @param publishYear the publishYear to set
     */
    public void setPublishYear(String publishYear) {
        this.publishYear = publishYear;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return this.id +";Video;Movie;"+this.title+";"+this.publishYear+";"+this.price;
    }
}
