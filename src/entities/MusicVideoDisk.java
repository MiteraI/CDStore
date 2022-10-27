/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import entities.ientities.IVideoDisk;

/**
 *
 * @author Huynh Anh Kiet
 */
public class MusicVideoDisk implements IVideoDisk {
    private String id;
    private String title;
    private String publishYear;
    private double price;
    private String type = "VIDEO";
    private String collect = "MUSIC";

    public MusicVideoDisk() {
    }

    public MusicVideoDisk(String id, String title, String publishYear, double price) {
        this.id = id;
        this.title = title;
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
        return this.id + SEPARATOR + this.type + SEPARATOR + this.collect + SEPARATOR + this.title.toUpperCase()
                + SEPARATOR + this.publishYear + SEPARATOR + this.price;
    }

	@Override
	public String toTable() {
        return String.format(FORMAT_STRING, this.id,this.type,this.collect,this.title.toUpperCase(),this.publishYear,this.price);
	}
}
