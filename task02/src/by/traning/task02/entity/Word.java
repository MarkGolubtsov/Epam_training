package by.traning.task02.entity;

import java.util.ArrayList;

public class Word implements Composite {

   public ArrayList<Component> list = new ArrayList<>();
    @Override
    public String compose() {
        String result ="";
        for (int i = 0; i < list.size(); i++) {
            result = result +list.get(i).compose();
        }
        return result;
    }

    @Override
    public void add(Component component) {
        list.add(component);
    }
}