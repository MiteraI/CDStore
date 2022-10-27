package management;

import data.IFileHandler;
import list.CDList;
import service.iservice.*;
import tools.ParseMethod;;

/**
 *
 * @author Huynh Anh Kiet
 */
public class CDMng {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CDList list = MainFactory.initList();
        ICreator creator = MainFactory.newCreator();
        IPrinter printer = MainFactory.newPrinter();
        IUpdater updater = MainFactory.newUpdater();
        IDeleter deleter = MainFactory.newDeleter();
        Menu mnu = MainFactory.newMenu();
        IFileHandler fileHandler = MainFactory.newFileHandler();
        fileHandler.loadCDFromFile(list);
        mnu.clearConsole();
        boolean changed = false;
        int choice = 0;
        do {         
            choice = mnu.getChoice("--------DISK STORE--------");
            mnu.clearConsole();
            switch (choice) {
                case 1 -> {
                    creator.addDisk(list);
                    changed = true;
                }
                case 2 -> {
                    updater.updateDisk(list);
                    changed = true;
                }
                case 3 -> {
                    deleter.deleteDisk(list);
                    changed = true;
                }
                case 4 -> printer.printByTitle(list);
                case 5 -> printer.printList(list);
                case 6 -> printer.printByType(list);
                case 7 -> {
                    fileHandler.saveToFile(list);
                    changed = false;
                }
                default -> {
                    boolean res = false;
                    if (changed)
                        res = ParseMethod.readBool("Data changed. Write to file? ");
                    if (res == true) {
                        fileHandler.saveToFile(list);
                    }
                }
            }
        } while (choice > 0 && choice <= mnu.size());
        System.out.println("Good Bye!");
    }
}