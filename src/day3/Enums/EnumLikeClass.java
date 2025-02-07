package day3.Enums;

public enum EnumLikeClass {
    SUNDAY("Weekend"), MONDAY("Weekday"), TUESDAY("Weekday"), WEDNESDAY("Weekday"),
    THURSDAY("Weekday"), FRIDAY("Weekday"), SATURDAY("Weekend");
    private String type;
    EnumLikeClass(String type){this.type=type;}

    public String getType() { return type; }
}
