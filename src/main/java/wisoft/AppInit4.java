package wisoft;

import wisoft.student.PostgresStudentService;
import wisoft.student.Student;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class AppInit4 {

    public static void main(final String... args) {
        final var studentService = new PostgresStudentService();
        var scanner = new Scanner(System.in);

        System.out.println("원하는 작업을 선택하세요:");
        System.out.println("1. 학생 전체 조회\n2. 특정 학번 조회\n3. 특정 이름 조회\n4. 특정 생일 조회");
        System.out.println("5. 학생 추가\n6. 여러 학생 추가\n7. 생일 변경\n8. 학생 삭제");

        int choice = scanner.nextInt();
        scanner.nextLine(); // 개행 문자 처리

        switch (choice) {
            case 1:
                List<Student> students = studentService.getStudents();
                students.forEach(student ->
                        System.out.println("[학번] " + student.getNo() + " || [이름] " + student.getName() + " || [생일] " + student.getBirthday())
                );
                break;

            case 2:
                System.out.print("조회할 학번을 입력하세요: ");
                String studentNo = scanner.nextLine();
                Student studentByNo = studentService.getStudentByNo(studentNo);
                System.out.println("[학번] " + studentByNo.getNo() + " || [이름] " + studentByNo.getName() + " || [생일] " + studentByNo.getBirthday());
                break;

            case 3:
                System.out.print("조회할 이름을 입력하세요: ");
                String name = scanner.nextLine();
                Student studentByName = studentService.getStudentByName(name);
                System.out.println("[학번] " + studentByName.getNo() + " || [이름] " + studentByName.getName() + " || [생일] " + studentByName.getBirthday());
                break;

            case 4:
                System.out.print("조회할 생일(YYYY-MM-DD)을 입력하세요: ");
                String birthday = scanner.nextLine();
                Student studentByBirthday = studentService.getStudentByBirthday(birthday);
                System.out.println("[학번] " + studentByBirthday.getNo() + " || [이름] " + studentByBirthday.getName() + " || [생일] " + studentByBirthday.getBirthday());
                break;

            case 5:
                System.out.print("추가할 학생의 학번을 입력하세요: ");
                String newNo = scanner.nextLine();
                System.out.print("추가할 학생의 이름을 입력하세요: ");
                String newName = scanner.nextLine();
                int added = studentService.insertStudent(new Student(newNo, newName));
                System.out.println(added + "명의 학생이 등록되었습니다.");
                break;

            case 6:
                System.out.println("여러 명의 학생을 추가하는 기능 (생략)");
                break;

            case 7:
                System.out.print("생일을 변경할 학생의 학번을 입력하세요: ");
                String updateNo = scanner.nextLine();
                System.out.print("새 생일을 입력하세요(YYYY-MM-DD): ");
                LocalDate newBirthday = LocalDate.parse(scanner.nextLine());
                int updated = studentService.updateStudent(new Student(updateNo, newBirthday));
                System.out.println(updated + "명의 학생 정보가 변경되었습니다.");
                break;

            case 8:
                System.out.print("삭제할 학생의 학번을 입력하세요: ");
                String deleteNo = scanner.nextLine();
                int deleted = studentService.deleteStudentByNo(deleteNo);
                System.out.println(deleted + "명의 학생 정보가 삭제되었습니다.");
                break;

            default:
                System.out.println("잘못된 선택입니다.");
        }

        scanner.close();
    }
}
