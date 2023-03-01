package task_2.patterns.Composite;

import java.util.Iterator;

public class Waitress {
    MenuComponent allMenus;
    public Waitress(MenuComponent allMenus) {this.allMenus = allMenus;}
    public void printMenu() {allMenus.print();}
    public void printVegeterian() {
        System.out.println("Vegeterian menu");
        Iterator<MenuComponent> iterator = allMenus.iterator();
        while (iterator.hasNext()) {
            try {MenuComponent elem = iterator.next();
                if (elem.isVegetrian())elem.print();
            } catch (UnsupportedOperationException а) {}
        }
    }

}
