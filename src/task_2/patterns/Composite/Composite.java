package task_2.patterns.Composite;

public class Composite {
    public static void main(String[] args) {

        MenuComponent rootMenu=new Menu("Весь список",null);

        MenuComponent dinner=new Menu("Обеденное","Для обеда");
        dinner.add(new MenuItem("Суп",null,true,200));
        dinner.add(new MenuItem("Окрощка",null,true,250));
        dinner.add(new MenuItem("Куринный суп",null,false,250));
        rootMenu.add(dinner);


        MenuComponent breakfast=new Menu("Утреннее меню",null);
        breakfast.add(new MenuItem("Гриль-бургеры",null,false,550));
        breakfast.add(new MenuItem("Ячница",null,true,110));
        breakfast.add(new MenuItem("Каша",null,true,150));
        rootMenu.add(breakfast);

        MenuComponent breakfastDesert=new Menu("Десертное утро","Разновидность утреннего меню");
        breakfastDesert.add( new MenuItem( "Мороженное",null,true,150));
        breakfastDesert.add( new MenuItem( "Пироженное",null,true,230));
        breakfast.add(breakfastDesert);

        Waitress waitress=new Waitress(rootMenu);
        waitress.printMenu();
        waitress.printVegeterian();

    }

}
