package wisoft;

import wisoft.student.PostgresStudentService;
import wisoft.student.Student;

import java.time.LocalDate;
import java.util.List;

public class AppInit {

    public static void main(final String... args) {
        final var studentService = new PostgresStudentService();

        var resultCount = 0;
        Student result;
        List<Student> results;

        System.out.println("01. 학생 전체 목록을 조회합니다.");
        results = studentService.getStudents();
        results.forEach(student ->
                System.out.println("[학번] " + student.getNo() + " || [이름] " + student.getName() + " || [생일] " + student.getBirthday())
        );
        System.out.println("");

        System.out.println("02. 학번이 20110101인 학생을 조회합니다.");
        result = studentService.getStudentByNo("20110101");
        System.out.println("[학번] " + result.getNo() + " || [이름] " + result.getName() + " || [생일] " + result.getBirthday());
        System.out.println("");

        System.out.println("03. 이름이 홍길동인 학생을 조회합니다.");
        result = studentService.getStudentByName("홍길동");
        System.out.println("[학번] " + result.getNo() + " || [이름] " + result.getName() + " || [생일] " + result.getBirthday());
        System.out.println("");

        System.out.println("04. 생일이 1990-03-01인 학생을 조회합니다.");
        result = studentService.getStudentByBirthday("1990-03-01");
        System.out.println("[학번] " + result.getNo() + " || [이름] " + result.getName() + " || [생일] " + result.getBirthday());
        System.out.println("");

        System.out.println("05. 학번이 20110401이고, 이름이 이순신인 학생을 추가합니다.");
        final var student = new Student("20110401", "이순신");
        resultCount = studentService.insertStudent(student);
        System.out.println(resultCount + "명의 학생이 등록되었습니다.");
        System.out.println("");

        System.out.println("06. 학번이 20110501, 20110601, 20110701, 20110801이고,\n " +
                "이름이 이율곡, 이수일, 심순애, 임꺽정인 학생을 추가합니다.");
        var students = new Student[]{
                new Student("20110501", "이율곡"),
                new Student("20110601", "이수일"),
                new Student("20110701", "심순애"),
                new Student("20110801", "임꺽정")
        };
        resultCount = studentService.insertStudentMulti(students);
        System.out.println(resultCount + "명의 학생이 등록되었습니다.");
        System.out.println("");

        System.out.println("07. 학번이 20110901, 20111001, 20111101, 20111201이고,\n " +
                "이름이 이상훈, 강동희, 김호성, 김정준인 학생을 추가합니다.");
        students = new Student[]{
                new Student("20110901", "이상훈"),
                new Student("20111001", "강동희"),
                new Student("20111101", "김호성"),
                new Student("20111201", "김정준")
        };
        resultCount = studentService.insertStudentMulti(students);
        System.out.println(resultCount + "명의 학생이 등록되었습니다.");
        System.out.println("");


        System.out.println("09. 학번이 20110401인 학생의 생일을 1990-03-25으로 변경합니다.");
        resultCount = studentService.updateStudent(new Student("20110401", LocalDate.of(1990,3,25)));
        System.out.println(resultCount + "명의 학생 정보가 변경되었습니다.");
        System.out.println("");

        System.out.println("10. 학번이 20110501, 20110601, 20110701, 20110801인 학생의 생일을 각각 \n" +
                "1990-03-01, 1990-04-01, 1990-05-01, 1990-06-01, 1990-07-01, 1990-08-01, 1990-09-01, 1990-10-01으로 변경합니다.");
        students = new Student[]{
                new Student("20110501", LocalDate.of(1990, 3, 1)),
                new Student("20110601", LocalDate.of(1990, 4, 1)),
                new Student("20110701", LocalDate.of(1990, 5, 1)),
                new Student("20110801", LocalDate.of(1990, 6, 1)),
                new Student("20110901", LocalDate.of(1990, 7, 1)),
                new Student("20111001", LocalDate.of(1990, 8, 1)),
                new Student("20111101", LocalDate.of(1990, 9, 1)),
                new Student("20111201", LocalDate.of(1990, 10, 1))
        };
        resultCount = studentService.updateStudentMultiBatch(students);
        System.out.println(resultCount + "명의 학생 정보가 변경되었습니다.");
        System.out.println("");

        System.out.println("11. 학번이 20110401인 학생을 목록에서 제거합니다.");
        resultCount = studentService.deleteStudentByNo("20110401");
        System.out.println(resultCount + "명의 학생 정보가 삭제되었습니다.");
        System.out.println("");

        System.out.println("12. 학번이 20110501, 20110601, 20110701, 20110801인 학생을 목록에서 제거합니다.");
        students = new Student[]{
                new Student("20110501"),
                new Student("20110601"),
                new Student("20110701"),
                new Student("20110801"),
                new Student("20110901"),
                new Student("20111001"),
                new Student("20111101"),
                new Student("20111201")
        };
        resultCount = studentService.deleteStudentNoMultiBatch(students);
        System.out.println(resultCount + "명의 학생 정보가 삭제되었습니다.");
        System.out.println("");
    }

}