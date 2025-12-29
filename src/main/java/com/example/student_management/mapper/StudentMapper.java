package com.example.student_management.mapper;

import com.example.student_management.dto.request.StudentRequestDTO;
import com.example.student_management.dto.response.StudentResponseDTO;
import com.example.student_management.entity.Student;

public class StudentMapper {

    // Create
    public static Student toEntity(StudentRequestDTO dto) {
        Student student = new Student();
        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        student.setCourse(dto.getCourse());
        return student;
    }

    // Update
    public static void updateEntity(Student student, StudentRequestDTO dto){
        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        student.setCourse(dto.getCourse());
    }

    // READ
    public static StudentResponseDTO toResponse(Student student) {
        return new StudentResponseDTO(
                student.getId(),
                student.getName(),
                student.getEmail(),
                student.getCourse()
        );
    }
}
