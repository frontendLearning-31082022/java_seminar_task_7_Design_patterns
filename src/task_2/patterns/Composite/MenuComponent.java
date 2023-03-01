package task_2.patterns.Composite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public abstract class MenuComponent {
    public void add(MenuComponent m){throw new UnsupportedOperationException();}
    public void print(){throw new UnsupportedOperationException();}
    public Iterator iterator(){throw new UnsupportedOperationException();}
    public boolean isVegetrian(){throw new UnsupportedOperationException();}
}

class MenuItem extends MenuComponent{
    String name;String desc; boolean vegeterian; double price;
    public MenuItem(String name, String description, boolean vegeterian, double price) {
        this.name = name;
        this.desc = description;
        this.vegeterian = vegeterian;
        this.price = price;
    }

    public Iterator iterator(){return Collections.emptyIterator();}
    public boolean isVegetrian(){return this.vegeterian;}
    public void print(){System.out.println("\t"+name+"\t"+desc+"\t"+price+"\t"+vegeterian); }
}


class Menu extends MenuComponent{
    String name;String desc;
    ArrayList<MenuComponent> menuArList =new ArrayList<>();

    public Menu(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public Iterator iterator(){return new IteratorComposite(menuArList.iterator());}
    public void add(MenuComponent menuComponent){menuArList.add(menuComponent);}
    public void print() {System.out.println("Меню "+name+" "+desc);   menuArList.forEach(x->x.print()); }
}



