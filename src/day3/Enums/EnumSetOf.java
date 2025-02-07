package day3.Enums;

import java.util.EnumSet;
import java.util.Set;

public class EnumSetOf {
    enum Menu{
        INDOMIE,
        PECEL_AYAM,
        ES_TEH,
        KOPI
    }

    public static void main(String[] args) {
        //nambahin menu kedalam set
        Set<Menu> availableMenu = EnumSet.of(Menu.INDOMIE, Menu.PECEL_AYAM);
        //nambahin menu lain
        availableMenu.add(Menu.ES_TEH);
        if(availableMenu.contains(Menu.ES_TEH)){
            System.out.println("Menu is available");
        } else {
            System.out.println("Menu is unavailable");
        }

        System.out.println("Today's menu is : " +availableMenu);
    }
}
