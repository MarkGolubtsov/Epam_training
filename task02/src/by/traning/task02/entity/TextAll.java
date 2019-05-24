package by.traning.task02.entity;


import java.util.ArrayList;

public class TextAll implements Composite{

    private  ArrayList<Component> list = new ArrayList<>();

    @Override
    public String compose() {
        String result = "";

        for (int i = 0; i < list.size(); i++) {
            result = result + list.get(i).compose()+"\n    ";
        }
        return result;
    }

    @Override
    public void add(Component component) {
        list.add(component);
    }
}
