### Hexlet tests and linter status:
[![Actions Status](https://github.com/d1z3d/java-project-78/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/d1z3d/java-project-78/actions) [![CI](https://github.com/d1z3d/java-project-78/actions/workflows/main.yml/badge.svg)](https://github.com/d1z3d/java-project-78/actions) [![Maintainability](https://api.codeclimate.com/v1/badges/639b97fc31cbd676897a/maintainability)](https://codeclimate.com/github/d1z3d/java-project-78/maintainability) [![Test Coverage](https://api.codeclimate.com/v1/badges/639b97fc31cbd676897a/test_coverage)](https://codeclimate.com/github/d1z3d/java-project-78/test_coverage)

## Валидатор данных
Валидатор данных – библиотека, с помощью которой можно проверять корректность любых данных. Подобных библиотек множество в каждом языке, так как практически все программы работают с внешними данными, которые нужно проверять на корректность. В первую очередь речь идет про данные форм заполняемых пользователями.

## Валидация строк
Вызов метода string() определяет схему StringSchema.
Схема содержит следующие методы:
1. required() — делает данные обязательными для заполнения. Иными словами добавляет в схему ограничение, которое не позволяет использовать null или пустую строку в качестве значения
2. minLength() — добавляет в схему ограничение минимальной длины для строки. Строка должна быть равна или длиннее указанного числа
3. contains() — добавляет в схему ограничение по содержимому строки. Строка должна содержать определённую подстроку

```java
import hexlet.code.Validator;
import hexlet.code.schemas.StringSchema;

var v = new Validator();
var schema = v.string().required().minLength(5).contains("hex");
schema.isValid("hexspeak");
```

## Валидация чисел
Вызов метода number() определяет схему NumberSchema. Эта схема используется для валидации чисел.
Схема содержит следующие методы:
1. required() — добавляет в схему ограничение, которое не позволяет использовать null в качестве значения
2. positive() — добавляет ограничение на знак числа. Число должно быть положительным
3. range() — добавляет допустимый диапазон, в который должно попадать значение числа включая границы

```java
import hexlet.code.Validator;
import hexlet.code.schemas.NumberSchema;

var v = new Validator();
var schema = v.number().required().positive().range(5, 10);
schema.isValid(7);
```

## Валидация объектов типа Map
Вызов метода map() определяет схему MapSchema. Эта схема используется для валидации объектов типа Map.
Схема содержит следующие методы:
1. required() — добавляет в схему ограничение, которое не позволяет использовать null в качестве значения. Требуется тип данных Map
2. sizeof() — добавляет ограничение на размер мапы. Количество пар ключ-значений в объекте Map должно быть равно заданному

```java
import hexlet.code.Validator;
import hexlet.code.schemas.MapSchema;

var v = new Validator();
var schema = v.map().required().sizeof(2);
var data = new HashMap<String, String>();
data.put("key1", "value1");
data.put("key2", "value2");
schema.isValid(data);
```

## Вложенная валидация
При работе со сложными данными бывает нужно проверять не только сам объект Map, но и данные внутри него.
Метод shape() используется для определения свойств объекта Map и создания схемы для валидации их значений. Каждому свойству объекта Map привязывается свой набор ограничений (своя схема), что позволяет более точно контролировать данные:

```java
import hexlet.code.Validator;
import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.BaseSchema;

var v = new Validator();
var schema = v.map();
Map<String, BaseSchema<String>> schemas = new HashMap<>();
schemas.put("firstName", v.string().required());
schemas.put("lastName", v.string().required().minLength(2));
schema.shape(schemas);
Map<String, String> human1 = new HashMap<>();
human1.put("firstName", "John");
human1.put("lastName", "Smith");
schema.isValid(human1);
```

## Стек
Gradle 8.4

Java 20

