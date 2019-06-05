package by.traning.task02.entity;

public interface Composite extends Component {
    void  add(Component component);
    Composite copy();
}
