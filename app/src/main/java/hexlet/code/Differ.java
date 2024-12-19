package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
//import java.util.TreeMap;
import java.util.stream.Collectors;

public class Differ {
    public static String generate(String filepath1, String filepath2, String format) throws Exception {

        Map map1 = getData(filepath1);
        Map map2 = getData(filepath2);

        List<String> keyList1 = new ArrayList<>(map1.keySet());
        List<String> keyList2 = new ArrayList<>(map2.keySet());

        keyList1.addAll(keyList2);

        List<String> distinctList = keyList1.stream().distinct().sorted().collect(Collectors.toList());

        StringBuilder result = new StringBuilder();

        for (String key : distinctList) {
            if (map1.containsKey(key) && !map2.containsKey(key)) {
                result.append("- ").append(key).append(": ").append(map1.get(key)).append("\n");
            } else if (map1.containsKey(key) && map2.containsKey(key)) {
                if (map1.get(key).equals(map2.get(key))) {
                    result.append("  ").append(key).append(": ").append(map1.get(key)).append("\n");
                } else {
                    result.append("- ").append(key).append(": ").append(map1.get(key)).append("\n");
                    result.append("+ ").append(key).append(": ").append(map2.get(key)).append("\n");
                }
            } else if (!map1.containsKey(key) && map2.containsKey(key)) {
                result.append("+ ").append(key).append(": ").append(map2.get(key)).append("\n");
            }
        }
        return result.toString();
    }

    public static Map getData(String content) throws Exception {
        return new ObjectMapper().readValue(new File(content), Map.class);
    }
}
