package com.rtt.teacher;

import java.util.List;

public interface TeacherI {
    public SuccessTeacherResponse createTeacher(TeacherRequest teacherRequest );
    public List<Teacher> allTeacherList();
}
