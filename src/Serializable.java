import java.io.IOException;

public interface Serializable {
    void saveToFile(String fileName) throws IOException;
    void loadFromFile(String fileName) throws IOException, ClassNotFoundException;
}