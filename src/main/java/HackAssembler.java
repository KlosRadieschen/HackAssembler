import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class HackAssembler {
    public static void main(String[] args) throws IOException {
        String[] lines = loadFileLines(args[0]);

        String[] parsedLines = new Parser().parseLines(lines).process().getParsedLines();

        writeToFile(Paths.get(args[0].split("\\.")[0] + ".hack"), parsedLines);
    }

    public static String[] loadFileLines(String filePath) throws IOException {
        return Files.readAllLines(Paths.get(filePath))
                .stream()
                .map(String::trim)
                .filter(line -> !line.startsWith("//"))
                .toArray(String[]::new);
    }

    public static void writeToFile(Path path, String[] lines) throws IOException {
        Path path1 = Files.write(path, Arrays.asList(lines));
    }
}