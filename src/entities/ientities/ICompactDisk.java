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
    static final String SEPARATOR = ";";
    static final String FORMAT_HEADER = "|%-6s|%-10s|%-10s|%-20s|%6s|%8s|\n";
    static final String FORMAT_STRING = "|%-6s|%-10s|%-10s|%-20s|%6s|%8s|";
    public String toString();
    public String toTable();
    String getId();
    double getPrice();
    String getPublishYear();
    String getTitle();
    void setId(String id);
    void setPrice(double price);
    void setPublishYear(String publishYear);
    void setTitle(String title);
}
