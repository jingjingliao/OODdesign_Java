public class Main {
  public static void main(String[] args) throws Exception {
    String emailKey = CommandLineParser.EMAIL + CommandLineParser.TEMPLATE;
    String letterKey = CommandLineParser.LETTER + CommandLineParser.TEMPLATE;
    String outputKey = CommandLineParser.OUTPUT_DIR;
    String csvKey = CommandLineParser.CSV_FILE;
    String USAGE = "Usage:\n"
        + "--email Generate email messages. If this option is provided, then\n"
        + "--email-template must also be provided.\n"
        + "--email-template <path/to/file> A filename for the email template.\n"
        + "--letter Generate letters. If this option is provided, then\n"
        + "--letter-template must also be provided.\n"
        + "--letter-template <path/to/file> A filename for the letter\n"
        + "template.\n"
        + "--output-dir <path/to/folder> The folder to store all generated\n"
        + "files. This option is required.\n"
        + "--csv-file <path/to/folder> The CSV file to process. This option is\n"
        + "required.\n"
        + "Examples:\n"
        + "--email --email-template email-template.txt --output-dir emails\n"
        + "--csv-file customer.csv\n"
        + "--letter --letter-template letter-template.txt --output-dir letters\n"
        + "--csv-file customer.csv";

    try {
      CommandLineParser parser = new CommandLineParser(args);
      parser.parse();

      if (parser.emailRequired || parser.letterRequired) {

        CSVDataReader csvReader = new CSVDataReader();
        csvReader.read(parser.paths.get(csvKey));

        if (parser.emailRequired) {
          TemplateDataReader emailTemplateReader = new TemplateDataReader();
          emailTemplateReader.read(parser.paths.get(emailKey));
          Generator g = new Generator();
          g.generate(emailTemplateReader, csvReader, parser.paths.get(outputKey) + "/email-folder");
          System.out.println("Emails created successfully.");
        }
        if (parser.letterRequired) {
          TemplateDataReader letterTemplateReader = new TemplateDataReader();
          letterTemplateReader.read(parser.paths.get(letterKey));
          Generator g = new Generator();
          g.generate(letterTemplateReader, csvReader, parser.paths.get(outputKey) + "/letter-folder");
          System.out.println("Letters created successfully.");
        }
      }
    } catch (Exception e) {
      System.out.println("ERROR: " + e.getMessage());
      System.out.println(USAGE);
    }
  }
}
