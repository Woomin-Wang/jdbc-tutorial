package wisoft.student;

import java.time.LocalDate;

public class Student {

    private String no;
    private String name;
    private LocalDate birthday;

    public Student() {
    }

    public Student(final String no) {
        this.no = no;
    }

    public Student(final String no, final String name) {
        this.no = no;
        this.name = name;
    }

    public Student(final String no, final LocalDate birthday) {
        this.no = no;
        this.birthday = birthday;
    }

    public Student(final String no, final String name, final LocalDate birthday) {
        this.no = no;
        this.name = name;
        this.birthday = birthday;
    }

    public String getNo() {
        return no;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

}