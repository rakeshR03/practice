package Concept.Class.Enum.CustomEnum;

public class EnumTest {
    public static void main(String[] args) {
        System.out.println("day : "+Weekday.getEnumFromValues(101));
    }
}
enum Weekday {
    MONDAY(101, "1st day of the week"),
    TUESDAY(102, "2nd day of the week"),
    WEDNESDAY(103, "3rd day of the week"),
    THURSDAY(104, "4th day of the week"),
    FRIDAY(105, "5th day of the week"),
    SATURDAY(106, "6th day of the week"),
    SUNDAY(107, "7th day of the week");

    private int value;
    private String comment;

    Weekday(int value, String comment) {
        this.value = value;
        this.comment = comment;
    }

    public int getValue() {
        return this.value;
    }

    public String getComment() {
        return this.comment;
    }

    public static Weekday getEnumFromValues(int value) {
        for (Weekday day : Weekday.values()) {
            if (day.value == value) {
                return day;
            }
        }
        return null;
    }
}
