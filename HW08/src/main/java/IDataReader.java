import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Represents DataReader Interface
 */
public interface IDataReader {

    /**
     * Read the file
     * @param fileLocation the location where the file is
     * @throws Exception throw an exception if path is invalid
     */
    void read(String fileLocation) throws Exception;
}
