package topic_1.basic_data_types;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Random;

public class WorkingWithEnums {

    public static void main(String[] args) {
        Class cls = new Class();
        cls.whatIsInEnum();
    }

}

enum Enum {
    Field1,
    Field2,
    Field3,
}

enum EnumWithConstructor {
    Field1("value1"),
    Field2("value2"),
    Field3("value3");

    public final String value;

    EnumWithConstructor(String value) {
        this.value = value;
    }
}

class Class {

    public Enum enumField;

    public EnumWithConstructor enumWithConstructorField;

    private Enum getRandomEnum() {
        // getting all enum`s fields as list
        List<Enum> enumValues = new ArrayList<>(
                EnumSet.allOf(Enum.class)
        );

        Random random = new Random();

        // took random element from whole list
        return enumValues.get(
                random.nextInt(
                        enumValues.size()
                )
        );
    }

    public EnumWithConstructor getRandomEnumWithConstructor() {
        List<EnumWithConstructor> enumValues = new ArrayList<>(
                EnumSet.allOf(EnumWithConstructor.class)
        );

        Random random = new Random();

        return enumValues.get(
                random.nextInt(
                        enumValues.size()
                )
        );
    }

    public String enumToString() {
        return STR."enum field is \{this.enumField}\n" +
                STR."enum class is \{this.enumField.getClass()}\n" +
                STR."enum name is \{this.enumField.name()}\n";
    }

    public String enumWithConstructorToString() {
        return STR."enum with constructor field is \{this.enumWithConstructorField}\n" +
                STR."enum with constructor class is \{this.enumWithConstructorField.getClass()}\n" +
                STR."enum with constructor name is \{this.enumWithConstructorField.name()}\n" +
                STR."enum with constructor value is \{this.enumWithConstructorField.value}\n";
    }

    public void whatIsInEnum() {
        this.enumField = getRandomEnum();
        this.enumWithConstructorField = getRandomEnumWithConstructor();

        System.out.println(
                STR."enum to String:\n \{enumToString()}" +
                STR."enum with constructor to String:\n \{enumWithConstructorToString()}"
        );
    }

}
