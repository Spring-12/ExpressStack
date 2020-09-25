package com.lcl.domain;

public class Console {

    private Integer expressTotal;
    private Integer expressIncrease;
    private Integer uncollectedExpress;
    private Integer uncollectedIncrease;

    public Console(Integer expressTotal, Integer expressIncrease, Integer uncollectedExpress, Integer uncollectedIncrease) {
        this.expressTotal = expressTotal;
        this.expressIncrease = expressIncrease;
        this.uncollectedExpress = uncollectedExpress;
        this.uncollectedIncrease = uncollectedIncrease;
    }

    public Console() {
    }

    public Integer getExpressTotal() {
        return expressTotal;
    }

    public void setExpressTotal(Integer expressTotal) {
        this.expressTotal = expressTotal;
    }

    public Integer getExpressIncrease() {
        return expressIncrease;
    }

    public void setExpressIncrease(Integer expressIncrease) {
        this.expressIncrease = expressIncrease;
    }

    public Integer getUncollectedExpress() {
        return uncollectedExpress;
    }

    public void setUncollectedExpress(Integer uncollectedExpress) {
        this.uncollectedExpress = uncollectedExpress;
    }

    public Integer getUncollectedIncrease() {
        return uncollectedIncrease;
    }

    public void setUncollectedIncrease(Integer uncollectedIncrease) {
        this.uncollectedIncrease = uncollectedIncrease;
    }

    @Override
    public String toString() {
        return "Console{" +
                "expressTotal=" + expressTotal +
                ", expressIncrease=" + expressIncrease +
                ", uncollectedExpress=" + uncollectedExpress +
                ", uncollectedIncrease=" + uncollectedIncrease +
                '}';
    }
}
