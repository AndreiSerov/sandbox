package model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
class SomeData {
    @NotNull
    @JsonProperty(required = true)
    private String a;
    private String b;
}

class Gen<T> {
    T t;

    public Gen(T t) {
        this.t = t;
    }
}

public class Serialization {


    public static <T> Gen<T> getGen(T t) {
        return new Gen<>(t);
    }

    public static void main(String[] args) throws JsonProcessingException {


        Gen<String> some_string = getGen("Some string");
//        if (some_string instanceof String) System.out.println("Its STRING");
//        Gen<String> some_string1 = some_string;
//        String json = "{\"a\":\"A is here\"}";
//        ObjectMapper objectMapper = new ObjectMapper();
//        SomeData someData = objectMapper.readValue(json, SomeData.class);
//        System.out.println(someData);
//
//        String json2 = "{\"b\":\"B is here\"}";
//        SomeData someData2 = objectMapper.readValue(json2, SomeData.class);
//        System.out.println(someData2);
//
//        SomeData someData1 = new SomeData();
//        someData1.setB("A IS HERE WITHOUT B");
//        System.out.println(objectMapper.writeValueAsString(someData1));

    }
}
