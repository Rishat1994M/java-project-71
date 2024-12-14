package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Differ {
    public static String generate(String filepath1, String filepath2, String format) throws Exception {

        Map map1 = getData(filepath1);
        Map map2 = getData(filepath2);

        List<String> keyList1 = new ArrayList<>(map1.keySet());
        List<String> keyList2 = new ArrayList<>(map2.keySet());

        keyList1.addAll(keyList2);

        List<String> distinctList = keyList1.stream().distinct().sorted().collect(Collectors.toList());
        for (String key : distinctList) {
            if (map1.containsKey(key) && !map2.containsKey(key)) {
                System.out.println("- " + key + ": " + map1.get(key));
            } else if (map1.containsKey(key) && map2.containsKey(key)) {
                if (map1.get(key).equals(map2.get(key))) {
                    System.out.println("  " + key + ": " + map1.get(key));
                } else {
                    System.out.println("- " + key + ": " + map1.get(key));
                    System.out.println("+ " + key + ": " + map2.get(key));
                }
            } else if (!map1.containsKey(key) && map2.containsKey(key)) {
                System.out.println("+ " + key + ": " + map2.get(key));
            }
        }
        return null;
    }

    public static Map getData(String content) throws Exception {
        return new ObjectMapper().readValue(new File(content), Map.class);
    }
}
