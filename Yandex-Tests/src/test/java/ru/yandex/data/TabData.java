package ru.yandex.data;

public class TabData {
    private String nameComp;
    private String price;


    public TabData (String nameComp, String price) {
        this.nameComp = nameComp;
        this.price = price;
    }

    @Override
    public String toString () {
        return "TabData{" +
                "nameComp='" + nameComp + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    public String getNameComp () {
        return nameComp;
    }

    public void setNameComp (String nameComp) {
        this.nameComp = nameComp;
    }

    public String getPrice () {
        return price;
    }

    public void setPrice (String price) {
        this.price = price;
    }
}
