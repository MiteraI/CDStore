package data;
import java.util.List;
import tools.FileMethod;

public class Config {
    private static final String CONFIG_FILE = "Product/Config.txt";
    private String productFile;
    public Config() {
        readData();
    }
    private void readData(){
        List<String> lines = FileMethod.readLinesFromFile(CONFIG_FILE);
        for(String line: lines){
            line = line.toUpperCase();
            String[] parts = line.split(":");
            if(line.contains("PRODUCT")){
                productFile = "Product/" + parts[1].trim();
            }
        }
    }
    public String getProductFile(){
        return productFile;
    }
}
