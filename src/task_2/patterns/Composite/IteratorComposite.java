package task_2.patterns.Composite;


import java.util.Iterator;
import java.util.Stack;

public class IteratorComposite implements Iterator {
    Stack stack = new Stack();

    public IteratorComposite(Iterator iterator) {
        stack.push(iterator);
    }

    public Object next() {
        if (!hasNext())return null;

        Iterator iterator = (Iterator)stack.peek();
        MenuComponent component = (MenuComponent)iterator.next();
//        if (component instanceof Menu)stack.push(component.iterator());
        stack.push(component.iterator());

        return component;
    }

    public boolean hasNext() {
        if (stack.empty())return false;

        Iterator iterator =  (Iterator)stack.peek();
        if (iterator.hasNext())return true;

        stack.pop();
        return hasNext();
    }


    public void remove() {
        throw new UnsupportedOperationException();
    }

}
