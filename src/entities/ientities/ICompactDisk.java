/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package entities.ientities;

/**
 *
 * @author Huynh Anh Kiet
 */
public interface ICompactDisk {
    public String toString();
    String getId();
    double getPrice();
    String getPublishYear();
    String getTitle();
    void setId(String id);
    void setPrice(double price);
    void setPublishYear(String publishYear);
    void setTitle(String title);
}
