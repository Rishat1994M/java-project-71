package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {

    String testDeleteDouble =
            "  availability: false\n"
                    + "  bf-Cache-Status: DYNAMIC\n"
                    + "  connection: keep-alive\n"
                    + "  t-Content-Length: 1105\n";

    @Test
    public void deleteDoubleTest() throws Exception {

        String filepath1 = "./src/test/resources/file1Test.json";
        String filepath2 = "./src/test/resources/file2Test.json";

        assertEquals(testDeleteDouble, Differ.generate(filepath1, filepath2, "json"));
    }

    String testNotAddSecondFile =
            "- availability: false\n"
                    + "- bf-Cache-Status: DYNAMIC\n"
                    + "- connection: keep-alive\n"
                    + "+ follow: false\n"
                    + "- t-Content-Length: 1105\n";

    @Test
    public void notAddSecondFile() throws Exception {

        String filepath3 = "./src/test/resources/file3Test.json";
        String filepath4 = "./src/test/resources/file4Test.json";

        assertEquals(testNotAddSecondFile, Differ.generate(filepath3, filepath4, "json"));
    }

    String testAddSecondFile =
            "- follow: false\n"
                    + "+ name: admin\n"
                    + "+ timeout: 110\n"
                    + "+ verbose: false\n";

    @Test
    public void addSecondFile() throws Exception {

        String filepath5 = "./src/test/resources/file5Test.json";
        String filepath6 = "./src/test/resources/file6Test.json";

        assertEquals(testAddSecondFile, Differ.generate(filepath5, filepath6, "json"));
    }

    String testAddAndNotSecondFile =
            "- name: admin\n"
                    + "+ name: quest\n"
                    + "- timeout: 110\n"
                    + "+ timeout: 111\n"
                    + "- verbose: false\n"
                    + "+ verbose: true\n";

    @Test
    public void addAndNotSecondFile() throws Exception {

        String filepath7 = "./src/test/resources/file7Test.json";
        String filepath8 = "./src/test/resources/file8Test.json";

        assertEquals(testAddAndNotSecondFile, Differ.generate(filepath7, filepath8, "json"));
    }
}
