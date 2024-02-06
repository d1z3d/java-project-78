package hexlet.code;


public class App {
    public static void main(String[] args) {
        var validator = new Validator();

        //TODO - сделать тесты
        //StringSchema
        var stringSchema = validator.string();

        var t1 = stringSchema.isValid(""); //true
        var t2 = stringSchema.isValid(null); //true
        stringSchema.required();
        var t3 = stringSchema.isValid(null); // false
        var t4 = stringSchema.isValid(""); // false
        var t5 = stringSchema.isValid("what does the fox say"); // true
        var t6 = stringSchema.isValid("hexlet"); // true
        var t7 = stringSchema.contains("wh").isValid("what does the fox say"); // true
        var t8 = stringSchema.contains("what").isValid("what does the fox say"); // true
        var t9 = stringSchema.contains("whatthe").isValid("what does the fox say"); // false
        var t10 = stringSchema.isValid("what does the fox say"); // false

        System.out.printf("%s - %s%n", "stringSchema.isValid(\"\")", t1);
        System.out.printf("%s - %s%n", "stringSchema.isValid(null)", t2);
        System.out.printf("%s - %s%n", "stringSchema.isValid(null)", t3);
        System.out.printf("%s - %s%n", "stringSchema.isValid(\"\")", t4);
        System.out.printf("%s - %s%n", "stringSchema.isValid(\"what does the fox say\")", t5);
        System.out.printf("%s - %s%n", "stringSchema.isValid(\"hexlet\")", t6);
        System.out.printf("%s - %s%n", "stringSchema.contains(\"wh\").isValid(\"what does the fox say\")", t7);
        System.out.printf("%s - %s%n", "stringSchema.contains(\"what\").isValid(\"what does the fox say\")", t8);
        System.out.printf("%s - %s%n", "stringSchema.contains(\"whatthe\").isValid(\"what does the fox say\")", t9);
        System.out.printf("%s - %s%n", "stringSchema.isValid(\"what does the fox say\")", t10);

        //NumberSchema
        /*var numberSchema = validator.number();
        var t1 = numberSchema.isValid(5);
        var t2 = numberSchema.isValid(null);
        var t3 = numberSchema.positive().isValid(null);
        numberSchema.required();
        var t4 = numberSchema.isValid(null);
        var t5 = numberSchema.isValid(10);
        var t11 = numberSchema.isValid(-10);
        var t6 = numberSchema.isValid(0);
        numberSchema.range(5, 10);
        var t8 = numberSchema.isValid(10);
        var t9 = numberSchema.isValid(4);
        var t10 = numberSchema.isValid(11);
        System.out.printf("%s - %s%n", "numberSchema.isValid(5)", t1);
        System.out.printf("%s - %s%n", "numberSchema.isValid(null)", t2);
        System.out.printf("%s - %s%n", "numberSchema.positive().isValid(null)", t3);
        System.out.printf("%s - %s%n", "numberSchema.isValid(null)", t4);
        System.out.printf("%s - %s%n", "numberSchema.isValid(10)", t5);
        System.out.printf("%s - %s%n", "numberSchema.isValid(-10)", t11);
        System.out.printf("%s - %s%n", "isValid(0)", t6);
        System.out.printf("%s - %s%n", "isValid(10)", t8);
        System.out.printf("%s - %s%n", "isValid(4)", t9);
        System.out.printf("%s - %s%n", "isValid(11)", t10);*/
    }
}
