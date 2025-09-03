package Concept.Class.Enum.NormalEnum;

import java.util.List;

public class EnumSample {
    public static void main(String[] args) {
        /*
        - common function which is used
        - values()
        - ordinal()
        - valueOf()
        - name()
         */

        System.out.println("values : "+WeekDay.values());

        for (WeekDay day : WeekDay.values()) {
            System.out.println("day : "+ day +", ordinal : "+ day.ordinal()
                    +", name : "+day.name());
        }
        System.out.println("valueOf : "+WeekDay.valueOf("SATURDAY"));

    }
}

enum WeekDay {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;
}

