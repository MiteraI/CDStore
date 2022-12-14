package management;

import entities.ientities.ICompactDisk;
import list.CDList;
import service.iservice.*;;


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
        printer.getClass();
        updater.getClass();
        creator.addDisk(list);
        for(ICompactDisk disk: list) {
            System.out.println(disk.getClass().toString());
        }
    }
    
}
