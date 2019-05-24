package by.traning.task02.parser;

import by.traning.task02.entity.Composite;



public interface Handle {

    void setNext( Handle h);
    void  handle1(String text, Composite composite);

}
