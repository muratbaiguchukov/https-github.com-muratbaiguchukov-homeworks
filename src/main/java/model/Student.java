package model;

public class Student {
    private Integer id;
    private String fio;

    public Student(Integer id, String fio) {
        this.id = id;
        this.fio = fio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }
}
