package com.rtt.teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/teachers")
public class TeacherController {
    @Autowired
    private  TeacherService teacherService;

   // @Autowired
   // public TeacherController(TeacherService teacherService) {
    //    this.teacherService = teacherService;
   // }

    @PostMapping("/add-teacher")
    public ResponseEntity<Teacher> addTeacher(@RequestBody Teacher teacher) {
        Teacher savedTeacher = teacherService.saveTeacher(teacher);
        return ResponseEntity.ok(savedTeacher);
    }
}


