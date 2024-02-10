package hexlet.code;


import hexlet.code.schemas.BaseSchema;

import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        //System.out.println("Hello world");
        var v = new Validator();

        var schema = v.map();
        var schS = v.string().required();
        Map<String, BaseSchema<String>> schemas = new HashMap<>();
        schemas.put("firstName", schS);
        schemas.put("lastName", v.string().required().minLength(2));
        schema.shape(schemas);
        Map<String, String> human1 = new HashMap<>();
        human1.put("firstName", "John");
        human1.put("lastName", "Smith");
        System.out.println(schema.isValid(human1));
        Map<String, String> human2 = new HashMap<>();
        human2.put("firstName", "John");
        human2.put("lastName", null);
        System.out.println(schema.isValid(human2));
        //System.out.println(schema.isValid(schemas));

    }
}
