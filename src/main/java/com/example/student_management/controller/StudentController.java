package com.example.student_management.controller;

import com.example.student_management.dto.request.StudentRequestDTO;
import com.example.student_management.dto.response.StudentResponseDTO;
import com.example.student_management.service.impl.StudentServiceImpl;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Validated
@RestController
@RequestMapping("/v1/students")
public class StudentController {

    // Constructor Injection

    private final StudentServiceImpl service;
    public StudentController(StudentServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<StudentResponseDTO> createStudent(@Valid @RequestBody StudentRequestDTO dto) {
        return new ResponseEntity<>(service.saveStudent(dto), HttpStatus.CREATED);
    }

    // READ ALL
    @GetMapping("/all")
    public ResponseEntity<List<StudentResponseDTO>> getAllStudents() {
        return ResponseEntity.ok(service.getAllStudents());
    }

    @GetMapping("/paged")
    public ResponseEntity<Page<StudentResponseDTO>> getAllStudentsPageed(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {

        return  ResponseEntity.ok(
                service.getAllStudentPage(page, size, sortBy, direction));
    }

    // READ BY ID
    @GetMapping("/id/{id}")
    public ResponseEntity<StudentResponseDTO> getStudentById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getStudentById(id));
    }

    // READ BY EMAIL
    @GetMapping("/email/{email}")
    public ResponseEntity<StudentResponseDTO> getStudentByEmail(@PathVariable String email) {
        return ResponseEntity.ok(service.getStudentByEmail(email));
    }

    // READ BY NAME
    @GetMapping("/name/{name}")
    public ResponseEntity<List<StudentResponseDTO>> getStudentByName(@PathVariable String name) {
        return ResponseEntity.ok(service.getStudentByName(name));
    }

    // UPDATE BY ID
    @PutMapping("/id/{id}")
    public ResponseEntity<StudentResponseDTO> updateStudentById(
            @PathVariable @Min(1) Long id,
            @Valid
            @RequestBody StudentRequestDTO dto) {
        return ResponseEntity.ok(service.updateById(id, dto));
    }

    // DELETE BY ID
    @DeleteMapping("/id/{id}")
    public ResponseEntity<Void> deleteStudentById(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // DELETE BY Email
    @DeleteMapping("/email/{email}")
    public  ResponseEntity<Void> deleteStudentByEmail(@PathVariable String email){
        service.deleteByEmail(email);
        return ResponseEntity.noContent().build();
    }
}
