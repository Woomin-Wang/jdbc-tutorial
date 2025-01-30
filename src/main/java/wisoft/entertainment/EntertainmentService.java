package wisoft.entertainment;

import wisoft.student.Student;

import java.util.List;

public interface EntertainmentService {

    List<Entertainment> getStudents();

    Entertainment getStudentByNo(final String studentNo);

    Entertainment getStudentByName(final String studentName);

    Entertainment getStudentByBirthday(final String studentBirthday);

    Integer insertStudent(final Entertainment student);

    Integer insertStudentMulti(final Entertainment[] students);

    Integer insertStudentMultiBatch(final Entertainment[] students);

    Integer updateStudentBirthdayByNo(String no, String birthday);

    Integer updateStudent(final Entertainment student);

    Integer updateStudentMultiBatch(final Student[] students);

    Integer deleteStudentByNo(final String no);

    Integer deleteStudentNoMultiBatch(final Student[] students);

}