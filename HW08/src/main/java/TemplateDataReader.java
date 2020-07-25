import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Represents TemplateDataReader which reads template file and extract useful information
 */
public class TemplateDataReader implements IDataReader{
    protected Set<String> tags;
    protected List<String> template;
    private static final String PATTERN = "(\\[\\[)([^]]*)(]])";

    /**
     * Constructs a TemplateDataReader
     */
    public TemplateDataReader() {
        this.tags = new HashSet<>();
        this.template =  new ArrayList<>();
    }

    /**
     * Read the file and extract information in tags and template
     * @param templateLocation the file location that we want to read
     * @throws Exception throw exception if file is not found or IOE errors
     */
    @Override
    public void read(String templateLocation) throws Exception {
        try (BufferedReader inputFile = new BufferedReader(new FileReader(templateLocation))){
            String line;
            while ((line = inputFile.readLine()) != null) {
                Pattern pattern = Pattern.compile(PATTERN);
                Matcher m = pattern.matcher(line);
                while (m.find()){
                    this.tags.add(m.group(2));
                }
                this.template.add(line);
            }
        } catch (FileNotFoundException fnfe) {
            throw new FileNotFoundException("OOPS! A file was not found");
        } catch (IOException ioe) {
            throw new IOException("Something went wrong!");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TemplateDataReader that = (TemplateDataReader) o;
        return tags == that.tags &&
            template == that.template;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.tags, this.template);
    }

    @Override
    public String toString() {
        return "TemplateDataReader{" +
            "tags=" + tags +
            ", template=" + template +
            '}';
    }
}
