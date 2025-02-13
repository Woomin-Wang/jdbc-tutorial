package wisoft.student;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")

public class StudentController {

    // 객체 생성
    final StudentService service;

    // 생성자
    public StudentController(StudentService service) {
        this.service = service;
    }

    // 학생 전체 조회
    @GetMapping
    public List<Student> getALLStudents() {
        return service.getStudents();
    }

    // 학생 학번으로 조회
    @GetMapping("/{no}")
    public Student getStudentByNo(
            @PathVariable("no") final String no
    ) {
        return this.service.getStudentByNo(no);
    }

    // 학생 이름으로 조회
    @GetMapping(params = "name")
    public Student getStudentByName (
            @RequestParam final String name
    ) {
        return service.getStudentByName(name);
    }

    // 학생 생일으로 조회
    @GetMapping(params = "birthday")
    public Student getStudentByBirthday(
            @RequestParam final String birthday
    ) {
        return service.getStudentByBirthday(birthday);
    }

    // 학생 한명 추가
    @PostMapping
    public String addStudent(
            @RequestBody final Student student
    ) {
        final var result = this.service.insertStudent(student);
        return result + "명의 학생이 등록되었습니다.";
    }

    // 학생 여러명 추가
    @PostMapping("/batch")
    public String addStudents(
            @RequestBody final List<Student> students
    ) {
        final var result = this.service.insertStudentMultiBatch(students);
        return result + "명의 학생이 등록되었습니다.";
    }

    // 학생 한명 추가
    @PatchMapping
    public String updateStudent(
            @RequestBody final Student student
    ) {
        final var result = this.service.updateStudent(student);
        return result + "명의 학생이 수정되었습니다.";
    }

    // 학생 여러명 추가
    @PatchMapping("/batch")
    public String updateStudents(
            @RequestBody final List<Student> students
    ) {
        final var result = this.service.updateStudentMultiBatch(students);
        return result + "명의 학생이 수정되었습니다.";
    }

    // 학생 한명 추가
    @DeleteMapping
    public String deleteStudent(
            @RequestBody final Student student
    ) {
        final var result = this.service.deleteStudentByNo(student.getNo());
        return result + "명의 학생이 삭제되었습니다.";
    }

    // 학생 여러명 추가
    @DeleteMapping("/batch")
    public String deleteStudents(
            @RequestBody final List<Student> students
    ) {
        final var result = this.service.deleteStudentMulti(students);
        return result + "명의 학생이 삭제되었습니다.";
    }



}




