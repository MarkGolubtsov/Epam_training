package by.traning.task2.entity;


import java.util.LinkedList;

public class Text {
    private String text;

    private LinkedList<Paragraph> paragraphs;

    public Text(String s,LinkedList<Paragraph> paragraphs)
    {
        text=s;
        this.paragraphs=paragraphs;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LinkedList<Paragraph> getParagraphs() {
        return paragraphs;
    }

    public void setParagraphs(LinkedList<Paragraph> paragraphs) {
        this.paragraphs = paragraphs;
    }
}
