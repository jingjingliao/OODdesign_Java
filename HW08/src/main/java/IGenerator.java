/**
 * The interface of Generator.
 */
public interface IGenerator{

    /**
     * Generate output files by given template and csv data.
     * @param templateData The template text and tags, given as a TemplateDataReader object.
     * @param csvData The csv information and tags, given as a CSVDataReader object.
     * @param outputPath The outputPath, given as a String.
     * @throws Exception If error happens while generating txt files.
     */
    void generate(TemplateDataReader templateData, CSVDataReader csvData, String outputPath) throws Exception;
}