package by.traning.task02.entity;

import by.traning.task02.enm.TypeSympol;

public class Symbol implements Component {

    private   TypeSympol typeSympol;

    private  Character symbol;

    public TypeSympol getTypeSympol() {
        return typeSympol;
    }

    public void setTypeSympol(TypeSympol typeSympol) {
        this.typeSympol = typeSympol;
    }

    public Character getSymbol() {
        return symbol;
    }

    public void setSymbol(Character symbol) {
        this.symbol = symbol;
    }

    @Override
    public String compose() {
        return  symbol.toString();
    }
}
