//package wisoft;
//
//import wisoft.student.PostgresStudentService;
//import wisoft.student.Student;
//
//import java.time.LocalDate;
//import java.util.List;
//import java.util.Scanner;
//
//public class AppInit4 {
//
//    public static void main(final String... args) {
//        final var studentService = new PostgresStudentService();
//        var scanner = new Scanner(System.in);
//
//        System.out.println("원하는 작업을 선택하세요:");
//        System.out.println("1. 학생 전체 조회\n2. 특정 학번 조회\n3. 특정 이름 조회\n4. 특정 생일 조회");
//        System.out.println("5. 학생 추가\n6. 여러 학생 추가\n7. 생일 변경\n8. 여러 학생 생일 변경");
//        System.out.println("9. 학생 삭제\n10. 여러 학생 삭제");
//
//        int choice = scanner.nextInt();
//        scanner.nextLine(); // 개행 문자 처리
//
//        switch (choice) {
//            case 1:
//                List<Student> students = studentService.getStudents();
//                students.forEach(student ->
//                        System.out.println("[학번] " + student.getNo() + " || [이름] " + student.getName() + " || [생일] " + student.getBirthday())
//                );
//                break;
//
//            case 2:
//                System.out.print("조회할 학번을 입력하세요: ");
//                String studentNo = scanner.nextLine();
//                Student studentByNo = studentService.getStudentByNo(studentNo);
//                System.out.println("[학번] " + studentByNo.getNo() + " || [이름] " + studentByNo.getName() + " || [생일] " + studentByNo.getBirthday());
//                break;
//
//            case 3:
//                System.out.print("조회할 이름을 입력하세요: ");
//                String name = scanner.nextLine();
//                Student studentByName = studentService.getStudentByName(name);
//                System.out.println("[학번] " + studentByName.getNo() + " || [이름] " + studentByName.getName() + " || [생일] " + studentByName.getBirthday());
//                break;
//
//            case 4:
//                System.out.print("조회할 생일(YYYY-MM-DD)을 입력하세요: ");
//                String birthday = scanner.nextLine();
//                Student studentByBirthday = studentService.getStudentByBirthday(birthday);
//                System.out.println("[학번] " + studentByBirthday.getNo() + " || [이름] " + studentByBirthday.getName() + " || [생일] " + studentByBirthday.getBirthday());
//                break;
//
//            case 5:
//                System.out.print("추가할 학생의 학번을 입력하세요: ");
//                String newNo = scanner.nextLine();
//                System.out.print("추가할 학생의 이름을 입력하세요: ");
//                String newName = scanner.nextLine();
//                int added = studentService.insertStudent(new Student(newNo, newName));
//                System.out.println(added + "명의 학생이 등록되었습니다.");
//                break;
//
//            case 6:
//                System.out.print("추가할 학생 수를 입력하세요: ");
//                int count = scanner.nextInt();
//                scanner.nextLine(); // 개행 문자 처리
//
//                Student[] newStudents = new Student[count];
//
//                for (int i = 0; i < count; i++) {
//                    System.out.print((i + 1) + "번째 학생의 학번을 입력하세요: ");
//                    String multiNo = scanner.nextLine();
//                    System.out.print((i + 1) + "번째 학생의 이름을 입력하세요: ");
//                    String multiName = scanner.nextLine();
//                    System.out.print((i + 1) + "번째 학생의 생일을 입력하세요(YYYY-MM-DD, 없으면 엔터): ");
//                    String multiBirthday = scanner.nextLine();
//
//                    LocalDate birthdayDate = multiBirthday.isEmpty() ? null : LocalDate.parse(multiBirthday);
//                    newStudents[i] = new Student(multiNo, multiName, birthdayDate);
//                }
//
//                int addedCount = studentService.insertStudentMulti(newStudents);
//                System.out.println(addedCount + "명의 학생이 등록되었습니다.");
//                break;
//
//
//            case 7:
//                System.out.print("생일을 변경할 학생의 학번을 입력하세요: ");
//                String updateNo = scanner.nextLine();
//                System.out.print("새 생일을 입력하세요(YYYY-MM-DD): ");
//                LocalDate newBirthday = LocalDate.parse(scanner.nextLine());
//                int updated = studentService.updateStudent(new Student(updateNo, newBirthday));
//                System.out.println(updated + "명의 학생 정보가 변경되었습니다.");
//                break;
//
//            // 생일 여러명 변경
//            case 8:
//                System.out.print("생일을 변경할 학생 수를 입력하세요: ");
//                int numUpdate = scanner.nextInt();
//                scanner.nextLine(); // 개행 문자 처리
//
//                Student[] updateStudents = new Student[numUpdate];
//
//                for (int i = 0; i < numUpdate; i++) {
//                    System.out.print("학생 " + (i + 1) + "의 학번을 입력하세요: ");
//                    updateNo = scanner.nextLine();
//                    System.out.print("학생 " + (i + 1) + "의 새 생일을 입력하세요(YYYY-MM-DD): ");
//                    LocalDate updateBirthday = LocalDate.parse(scanner.nextLine());
//                    updateStudents[i] = new Student(updateNo, updateBirthday);
//                }
//
//                int updatedCount = studentService.updateStudentMultiBatch(updateStudents);
//                System.out.println(updatedCount + "명의 학생 생일이 변경되었습니다.");
//                break;
//
//            case 9:
//                System.out.print("삭제할 학생의 학번을 입력하세요: ");
//                String deleteNo = scanner.nextLine();
//                int deleted = studentService.deleteStudentByNo(deleteNo);
//                System.out.println(deleted + "명의 학생 정보가 삭제되었습니다.");
//                break;
//
//            // 여러명 삭제
//            case 10:
//                System.out.print("삭제할 학생 수를 입력하세요: ");
//                int numDelete = scanner.nextInt();
//                scanner.nextLine(); // 개행 문자 처리
//
//                Student[] deleteStudents = new Student[numDelete];
//
//                for (int i = 0; i < numDelete; i++) {
//                    System.out.print("삭제할 학생 " + (i + 1) + "의 학번을 입력하세요: ");
//                    deleteNo = scanner.nextLine();
//                    deleteStudents[i] = new Student(deleteNo);
//                }
//
//                int deletedCount = studentService.deleteStudentNoMultiBatch(deleteStudents);
//                System.out.println(deletedCount + "명의 학생 정보가 삭제되었습니다.");
//                break;
//
//            default:
//                System.out.println("잘못된 선택입니다.");
//        }
//
//        scanner.close();
//    }
//}
