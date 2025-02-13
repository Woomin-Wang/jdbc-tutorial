package wisoft.student;

import java.util.List;

public interface StudentService {

    List<Student> getStudents();

    Student getStudentByNo(final String studentNo);

    Student getStudentByName(final String studentName);

    Student getStudentByBirthday(final String studentBirthday);

    Integer insertStudent(final Student student);

    Integer insertStudentMulti(final Student[] students);

    //Integer insertStudentMultiBatch(final Student[] students);
    Integer insertStudentMultiBatch(final List<Student> students);

    Integer updateStudent(final Student student);

    Integer updateStudentMultiBatch(final List<Student> students);

    Integer deleteStudentByNo(final String no);

    Integer deleteStudentNoMultiBatch(final List<Student> students);

    Integer deleteStudentMulti(List<Student> students);
}