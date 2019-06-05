package by.traning.task02.entity;

import by.traning.task02.enm.TypeSympol;

public class Symbol implements Component {

    private   TypeSympol typeSympol;

    private  Character symbol;

    public TypeSympol getTypeSympol() {
        return typeSympol;
    }

    public void setTypeSympol(final TypeSympol t) {
        this.typeSympol = t;
    }

    public Character getSymbol() {
        return symbol;
    }

    public void setSymbol(final Character s) {
        this.symbol = s;
    }

    @Override
    public String compose() {
        return  symbol.toString();
    }

    @Override
    public Component copy() {
        Symbol result = new Symbol();
        result.setSymbol(this.getSymbol());
        return result;
    }
}
