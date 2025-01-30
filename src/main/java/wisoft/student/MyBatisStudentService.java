package wisoft.student;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import wisoft.common.MyBatisAccess;

import java.util.ArrayList;
import java.util.List;

public class MyBatisStudentService implements StudentService {


    final SqlSessionFactory sqlSessionFactory = MyBatisAccess.getSqlSessionFactory();


    @Override
    public List<Student> getStudents() {
        final List<Student> students;

        try (final SqlSession session = sqlSessionFactory.openSession()) {
            final var studentService = session.getMapper(StudentService.class);
            students = studentService.getStudents();
            return students;
        } catch (final Exception ex) {
            System.err.println(ex.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public Student getStudentByNo(String studentNo) {
        // 한명의 학생
        final Student students;

        try (final SqlSession session = sqlSessionFactory.openSession()) {
            final var studentService = session.getMapper(StudentService.class);
            students = studentService.getStudentByNo(studentNo);
            return students;
        } catch (final Exception ex) {
            System.err.println(ex.getMessage());
            return new Student();
        }
    }

    @Override
    public Student getStudentByName(String studentName) {
        final Student students;

        try (final SqlSession session = sqlSessionFactory.openSession()) {
            final var studentService = session.getMapper(StudentService.class);
            students = studentService.getStudentByName(studentName);
            return students;
        } catch (final Exception ex) {
            System.err.println(ex.getMessage());
            return new Student();
        }

    }

    @Override
    public Student getStudentByBirthday(String studentBirthday) {
        final Student students;

        try (final SqlSession session = sqlSessionFactory.openSession()) {
            final var studentService = session.getMapper(StudentService.class);
            students = studentService.getStudentByBirthday(studentBirthday);
            return students;
        } catch (final Exception ex) {
            System.err.println(ex.getMessage());
            return new Student();
        }
    }

    @Override
    public Integer insertStudent(Student student) {
        final Student students;

        try (final SqlSession session = sqlSessionFactory.openSession()) {
            final var studentService = session.getMapper(StudentService.class);
            int result = studentService.insertStudent(student);
            session.commit();
            return result;
        } catch (final Exception ex) {
            System.err.println(ex.getMessage());
            return 0;
        }
    }

    @Override
    public Integer insertStudentMulti(Student[] students) {
        try (final SqlSession session = sqlSessionFactory.openSession()) {
            final var studentService = session.getMapper(StudentService.class);
//                int result = 0;
//                for (Student student : students) {
//                    result += studentService.insertStudent(student);
//                }
            int result = studentService.insertStudentMulti(students);

            session.commit();
            return result;
        } catch (final Exception ex) {
            System.err.println(ex.getMessage());
            return 0;
        }
    }

    @Override
    public Integer insertStudentMultiBatch(final Student[] students) {
        try (final SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH)) {
            final var studentService = session.getMapper(StudentService.class);
            int result = 0;
            for (Student student : students) {
                result += studentService.insertStudent(student);
            }
            session.commit();
            return students.length;
        } catch (final Exception ex) {
            System.err.println(ex.getMessage());
            return 0;
        }
    }

    @Override
    public Integer updateStudent(Student student) {
        try (final SqlSession session = sqlSessionFactory.openSession()) {
            final var studentService = session.getMapper(StudentService.class);
            int result = studentService.updateStudent(student);
            session.commit();
            return result;
        } catch (final Exception ex) {
            System.err.println(ex.getMessage());
            return 0;
        }
    }

    @Override
    public Integer updateStudentMultiBatch(Student[] students) {
        try (final SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH)) {
            final var studentService = session.getMapper(StudentService.class);
            for (Student student : students) {
                studentService.updateStudent(student);
            }
            session.commit();
            return students.length;
        } catch (final Exception ex) {
            System.err.println(ex.getMessage());
            return 0;
        }
    }

    @Override
    public Integer deleteStudentByNo(String no) {
        try (final SqlSession session = sqlSessionFactory.openSession()) {
            final var studentService = session.getMapper(StudentService.class);
            int result = studentService.deleteStudentByNo(no);
            session.commit();
            return result;
        } catch (final Exception ex) {
            System.err.println(ex.getMessage());
            return 0;
        }
    }

    @Override
    public Integer deleteStudentNoMultiBatch(Student[] students) {
        try (final SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH)) {
            final var studentService = session.getMapper(StudentService.class);
            for (Student student : students) {
                studentService.deleteStudentByNo(student.getNo());
            }
            session.commit();
            return students.length;
        } catch (final Exception ex) {
            System.err.println(ex.getMessage());
            return 0;
        }
    }
}
