/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package management;

import java.util.ArrayList;
import tools.ParseMethod;

/**
 *
 * @author Administrator
 */
public class Menu extends ArrayList<String> {
    String[] options = { "Create new disk", "Update disk",
            "Delete disk", "Search disk by title",
            "Display all disks", "Display all disks by type",
            "Save information to file" };

    public Menu() {
        super();
        for (String item : options) {
            this.add(item);
        }
    }

    public int getChoice(String title) {
        System.out.println(title);
        for (int i = 0; i < this.size(); i++) {
            System.out.println("    " + (i + 1) + " - " + this.get(i));
        }
        System.out.println("Press other to quit.");
        return Integer.parseInt(ParseMethod.readNonBlank("Choose [1.." + this.size() + "]: ")); // nên trả về string,
                                                                                                // lỗi nếu nhập char
    }

    public void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
