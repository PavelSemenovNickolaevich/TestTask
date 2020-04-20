package ru.yandex.data;

public class NoteData {

    private String  nameComp;
    private String price;

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

    public NoteData (String nameComp, String price) {
        this.nameComp = nameComp;
        this.price = price;
    }


    @Override
    public String toString () {
        return "NoteData{" +
                "nameComp='" + nameComp + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
