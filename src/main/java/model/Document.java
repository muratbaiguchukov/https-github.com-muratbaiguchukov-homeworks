package model;

public class Document {
    private String name;

    public Document(String name) {
        this.name = name;
    }

    public void print(){
        System.out.println("Document about " + name);
    }

}
