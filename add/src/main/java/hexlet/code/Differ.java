package hexlet.code;

public class Differ {
    public static String generate(String filepath1, String filepath2, String format) throws Exception {
        final String defaultFormat = "stylish";
        return generate(filepath1, filepath2, defaultFormat);
    }
}
