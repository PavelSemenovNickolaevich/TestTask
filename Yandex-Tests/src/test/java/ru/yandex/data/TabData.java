package ru.yandex.data;

public class TabData {
    private String nameComp;
    private String price;


    public TabData (String nameComp, String price) {
        this.nameComp = nameComp;
        this.price = price;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TabData tabData = (TabData) o;

        if (nameComp != null ? !nameComp.equals(tabData.nameComp) : tabData.nameComp != null) return false;
        return price != null ? price.equals(tabData.price) : tabData.price == null;
    }

    @Override
    public int hashCode () {
        int result = nameComp != null ? nameComp.hashCode() : 0;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
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
