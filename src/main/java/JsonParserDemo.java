import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * @author andreiserov
 */
public class JsonParserDemo {
    static String json = """
            {
              "setting1": "Some value",
              "setting2": 200,
              "setting3": true,
              "key1": "value1",
              "numbers1": [1, 2, 3, 4],
              "numbers2": [2, 3, 4, 5],
              "id3": 45,
              "id": {
                "oneMore": "str",
                "chars5": ["asdf", "basdf", "czcz"]
              },
              "default": null,
              "checked": false,
              "numbers3": [3, 4, 5],
              "chars1": ["a", "b", "c"],
              "chars2": ["d", "e", "f"]
            }
            """;

    public static void main(String[] args) throws IOException {
        final ObjectMapper om = new ObjectMapper();

        final JsonNode root = om.readTree(json);

        final Set<String> strings = extractJsonNodesValues(root);


    }
    private static Set<String> extractJsonNodesValues(JsonNode root) throws IOException {
        Set<String> values = new HashSet<>();

        JsonParser jsonParser = root.traverse();

        while (!jsonParser.isClosed()) {
            final JsonToken jsonToken = jsonParser.nextToken();
            if (jsonToken == JsonToken.VALUE_STRING) {
                values.add(jsonParser.getValueAsString());
            }
        }

        return values;
    }

}
