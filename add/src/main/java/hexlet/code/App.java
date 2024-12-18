package hexlet.code;

<<<<<<< HEAD
//import com.fasterxml.jackson.databind.ObjectMapper;

=======
import com.fasterxml.jackson.databind.ObjectMapper;
>>>>>>> 3e31ec73ac0eaad17e68207eaa07b407ad16c68c
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.File;
<<<<<<< HEAD
//import java.util.Map;
import java.util.concurrent.Callable;

@Command(name = "gendiff", mixinStandardHelpOptions = true,
        version = "gendiff 1.0",
        description = "Compares two configuration files and shows a difference")
=======
import java.util.Map;
import java.util.concurrent.Callable;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 1.0", description = "Compares two configuration files and shows a difference")
>>>>>>> 3e31ec73ac0eaad17e68207eaa07b407ad16c68c
class App implements Callable<Integer> {

    @Parameters(index = "0", description = "path to first file")
    private File filepath1;
    @Parameters(index = "1", description = "path to second file")
    private File filepath2;
    @Option(names = {"-f", "--format"}, paramLabel = "format",
            description = "output format [default: stylish]",
            defaultValue = "stylish")
    private String format;

    @Override
    public Integer call() throws Exception {
        System.out.println(Differ.generate("file1.json", "file2.json", ""));
        return 0;
    }

    public static void main(String... args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }

<<<<<<< HEAD
}
=======
}
>>>>>>> 3e31ec73ac0eaad17e68207eaa07b407ad16c68c
