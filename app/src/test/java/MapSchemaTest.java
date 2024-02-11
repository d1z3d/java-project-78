import hexlet.code.Validator;
import hexlet.code.schemas.BaseSchema;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MapSchemaTest {

    @Test
    public void isValidTest() {
        var v = new Validator();
        var schema = v.map().sizeOf(2);
        Map<String, BaseSchema<String>> stringSchema = new HashMap<>();
        stringSchema.put("firstName", v.string().contains("t").required());
        stringSchema.put("lastName", v.string().minLength(2).required());
        schema.shape(stringSchema);
        Map<String, String> human1 = new HashMap<>();
        human1.put("firstName", "Johnathan");
        human1.put("lastName", "Smith");
        assertTrue(schema.isValid(human1));
        Map<String, String> human2 = new HashMap<>();
        human2.put("firstName", "Johnathan");
        human2.put("lastName", null);
        assertFalse(schema.isValid(human2));
        Map<String, String> human3 = new HashMap<>();
        human3.put("firstName", "Annet");
        human3.put("lastName", "B");
        assertFalse(schema.isValid(human3));

        Map<String, BaseSchema<Number>> numberSchema = new HashMap<>();
        numberSchema.put("age", v.number().positive().required());
        numberSchema.put("hours", v.number().range(12, 18).required());
        schema.shape(numberSchema);
        Map<String, Number> person1 = new HashMap<>();
        person1.put("age", 12);
        person1.put("hours", 15);
        assertTrue(schema.isValid(person1));
        Map<String, Number> person2 = new HashMap<>();
        person2.put("age", -12);
        person2.put("hours", null);
        assertFalse(schema.isValid(person2));

        schema = v.map().sizeOf(3);
        stringSchema.clear();
        stringSchema.put("firstName", v.string().contains("t").required());
        stringSchema.put("lastName", v.string().minLength(2).required());
        schema.shape(stringSchema);
        Map<String, String> person3 = new HashMap<>();
        person3.put("firstName", "Johnathan");
        person3.put("lastName", "Smith");
        assertFalse(schema.isValid(person3));
    }
}
