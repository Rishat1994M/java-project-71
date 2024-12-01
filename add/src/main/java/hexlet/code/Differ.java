package hexlet.code;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.TreeMap;
import java.util.TreeSet;


public class Differ {
    public static String generate(String filepath1, String filepath2, String format) throws Exception {
        final String defaultFormat = "stylish";
        return generate(filepath1, filepath2, defaultFormat);
    }
}
