import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class CommandLineParserTest {
    CommandLineParser parser;
    Map<String, String> paths;
    String[] validArgsBoth, validArgsEmail, validArgsLetter, validArgsDuplicatedCommands;
    String[] invalidArgsNoFileInput, invalidArgsNoOutputDirCommand, invalidArgsNoOutputDir, invalidArgsNoCSVCommand,
            invalidArgsNoEmailTemplateCommand, invalidArgsNoEmailTemplate, invalidArgsNoEmailCommand,
            invalidArgsNoLetterTemplateCommand,  invalidArgsNoLetterCommand, invalidArgsUnknownCommand,
            invalidArgsNoEmailOrLetter, invalidArgsEmpty;

    @Before
    public void setUp() throws Exception {
        validArgsBoth = new String[]{"--email", "--email-template", "email-template.txt", "--letter", "--letter-template",
                "letter-template.txt", "--csv-file", "nonprofit-supporters.csv", "--output-dir", "output-folder"};
        validArgsEmail = new String[]{"--email", "--email-template", "email-template.txt", "--csv-file",
                "nonprofit-supporters.csv", "--output-dir", "output-folder"};
        validArgsLetter =  new String[]{"--letter", "--letter-template", "letter-template.txt",
                "--csv-file", "nonprofit-supporters.csv", "--output-dir", "output-folder"};
        validArgsDuplicatedCommands = new String[]{"--email", "--email-template", "email-template1.txt", "--csv-file",
                "nonprofit-supporters.csv", "--output-dir", "output-folder", "--email-template", "email-template2.txt"};
        invalidArgsNoFileInput = new String[]{"--email", "--email-template", "--csv-file",
                "nonprofit-supporters.csv", "--output-dir", "output-folder"};
        invalidArgsNoEmailTemplateCommand = new String[]{"--email", "--csv-file", "nonprofit-supporters.csv", "--output-dir",
                "output-folder"};
        //Applies to no letter template too
        invalidArgsNoEmailTemplate = new String[]{"--email", "--csv-file", "nonprofit-supporters.csv", "--output-dir",
                "output-folder", "--email-template"};
        invalidArgsNoEmailCommand = new String[]{"--email-template", "email-template.txt", "--csv-file",
                "nonprofit-supporters.csv", "--output-dir", "output-folder"};
        invalidArgsNoLetterTemplateCommand = new String[]{"--letter", "--csv-file", "nonprofit-supporters.csv",
                "--output-dir", "output-folder"};
        invalidArgsNoLetterCommand = new String[]{"--letter-template", "letter-template.txt",
                "--csv-file", "nonprofit-supporters.csv", "--output-dir", "output-folder"};
        invalidArgsNoOutputDirCommand = new String[]{"--email", "--email-template", "email-template.txt", "--csv-file",
                "nonprofit-supporters.csv"};
        invalidArgsNoOutputDir = new String[]{"--letter", "--letter-template", "letter-template.txt",
                "--csv-file", "nonprofit-supporters.csv", "--output-dir"};
        invalidArgsNoCSVCommand = new String[]{"--email", "--email-template", "email-template.txt", "--output-dir", "output-folder"};
        invalidArgsNoEmailOrLetter = new String[]{"--csv-file", "nonprofit-supporters.csv", "--output-dir", "output-folder"};
        invalidArgsUnknownCommand = new String[]{"--email&letter"};
        invalidArgsEmpty = new String[]{};
    }

    @Test
    public void validParseBoth() throws Exception{
        parser = new CommandLineParser(validArgsBoth);
        parser.parse();
        assertTrue(parser.emailRequired);
        assertTrue(parser.letterRequired);
        paths = new HashMap<String, String>(){{
            put("email-template", "email-template.txt");
            put("letter-template", "letter-template.txt");
            put("csv-file", "nonprofit-supporters.csv");
            put("output-dir", "output-folder");
        }};
        assertEquals(paths, parser.paths);
    }

    @Test
    public void validParseEmail() throws Exception{
        parser = new CommandLineParser(validArgsEmail);
        parser.parse();
        assertTrue(parser.emailRequired);
        assertFalse(parser.letterRequired);
        paths = new HashMap<String, String>(){{
            put("email-template", "email-template.txt");
            put("csv-file", "nonprofit-supporters.csv");
            put("output-dir", "output-folder");
        }};
        assertEquals(paths, parser.paths);
    }

    @Test
    public void validParseLetter() throws Exception{
        parser = new CommandLineParser(validArgsLetter);
        parser.parse();
        assertFalse(parser.emailRequired);
        assertTrue(parser.letterRequired);
        paths = new HashMap<String, String>(){{
            put("letter-template", "letter-template.txt");
            put("csv-file", "nonprofit-supporters.csv");
            put("output-dir", "output-folder");
        }};
        assertEquals(paths, parser.paths);
    }

    @Test
    public void validParseDuplicatedCommands() throws Exception{
        parser = new CommandLineParser(validArgsDuplicatedCommands);
        parser.parse();
        assertTrue(parser.emailRequired);
        assertFalse(parser.letterRequired);
        paths = new HashMap<String, String>(){{
            put("email-template", "email-template2.txt");
            put("csv-file", "nonprofit-supporters.csv");
            put("output-dir", "output-folder");
        }};
        assertEquals(paths, parser.paths);
    }

    @Test(expected=InvalidArgumentsException.class)
    public void invalidParseNoFileInput() throws Exception{
        parser = new CommandLineParser(invalidArgsNoFileInput);
        parser.parse();
    }

    @Test(expected=InvalidArgumentsException.class)
    public void invalidParseNoEmailTemplateCommand() throws Exception{
        parser = new CommandLineParser(invalidArgsNoEmailTemplateCommand);
        parser.parse();
    }
    @Test(expected=InvalidArgumentsException.class)
    public void invalidParseNoEmailTemplate() throws Exception{
        parser = new CommandLineParser(invalidArgsNoEmailTemplate);
        parser.parse();
    }
    @Test(expected=InvalidArgumentsException.class)
    public void invalidParseNoEmailCommand() throws Exception{
        parser = new CommandLineParser(invalidArgsNoEmailCommand);
        parser.parse();
    }

    @Test(expected=InvalidArgumentsException.class)
    public void invalidParseNoLetterTemplateCommand() throws Exception{
        parser = new CommandLineParser(invalidArgsNoLetterTemplateCommand);
        parser.parse();
    }

    @Test(expected=InvalidArgumentsException.class)
    public void invalidParseNoLetterCommand() throws Exception{
        parser = new CommandLineParser(invalidArgsNoLetterCommand);
        parser.parse();
    }

    @Test(expected=InvalidArgumentsException.class)
    public void invalidParseNoOutputDirCommand() throws Exception{
        parser = new CommandLineParser(invalidArgsNoOutputDirCommand);
        parser.parse();
    }

    @Test(expected=InvalidArgumentsException.class)
    public void invalidParseNoOutputDir() throws Exception{
        parser = new CommandLineParser(invalidArgsNoOutputDir);
        parser.parse();
    }

    @Test(expected=InvalidArgumentsException.class)
    public void invalidParseUnknownCommand() throws Exception{
        parser = new CommandLineParser(invalidArgsUnknownCommand);
        parser.parse();
    }

    @Test(expected=InvalidArgumentsException.class)
    public void invalidParseNoCSVCommand() throws Exception{
        parser = new CommandLineParser(invalidArgsNoCSVCommand);
        parser.parse();
    }

    @Test(expected=InvalidArgumentsException.class)
    public void invalidParseNoEmailOrLetter() throws Exception{
        parser = new CommandLineParser(invalidArgsNoEmailOrLetter);
        parser.parse();
    }

    @Test(expected=InvalidArgumentsException.class)
    public void invalidParseEmptyArgs() throws Exception{
        parser = new CommandLineParser(invalidArgsEmpty);
        parser.parse();
    }

    @Test(expected=InvalidArgumentsException.class)
    public void invalidParseNullArgs() throws Exception{
        parser = new CommandLineParser(null);
        parser.parse();
    }

    @Test
    public void testEquals() {
        parser = new CommandLineParser(validArgsEmail);
        assertTrue(parser.equals(parser));
        assertTrue(parser.equals(new CommandLineParser(validArgsEmail)));
        assertFalse(parser.equals(null));
        assertFalse(parser.equals(""));
        CommandLineParser test = new CommandLineParser(validArgsEmail);
        test.emailRequired = true;
        assertFalse(parser.equals(test));
        test.emailRequired = false;
        test.letterRequired = true;
        assertFalse(parser.equals(test));
        test.letterRequired = false;
        test.paths.put("letter-template", "letter-template.txt");
        assertFalse(parser.equals(test));
        assertFalse(parser.equals(new CommandLineParser(validArgsBoth)));
    }

    @Test
    public void testHashCode() {
        assertEquals(new CommandLineParser(validArgsEmail).hashCode(), new CommandLineParser(validArgsEmail).hashCode());
    }

    @Test
    public void testToString() {
        assertEquals("CommandLineParser{paths={}, emailRequired=false, letterRequired=false, args=[--email, " +
                "--email-template, email-template.txt, --csv-file, nonprofit-supporters.csv, --output-dir, output-folder]}",
                new CommandLineParser(validArgsEmail).toString());
    }
}