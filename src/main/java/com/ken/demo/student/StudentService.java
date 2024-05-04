package com.ken.demo.student;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository repository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository repository, StudentMapper studentMapper) {
        this.repository = repository;
        this.studentMapper = studentMapper;
    }

    public StudentResponseDto saveStudent(
            StudentDto dto
    ) {
        var student = studentMapper.toStudent(dto);
        var studentSave = repository.save(student);
        return studentMapper.toStudentResponseDto(studentSave);
    }

    public List<StudentResponseDto> getAllStudents() {
        return repository.findAll()//取出Student的所有原始資料
                .stream()//轉換成流
                .map(studentMapper::toStudentResponseDto) // 映射dto需要的資料
                .collect(Collectors.toList()); // 把資料放到list裡面
    }

    public StudentResponseDto getStudentById(
            Integer id
    ) {
        return repository.findById(id)
                .map(studentMapper::toStudentResponseDto)
                .orElse(null);
    }
    public List<StudentResponseDto> getStudentByName(
            String name
    ) {
        return repository.findAllByFirstnameContaining(name)
                .stream()
                .map(studentMapper::toStudentResponseDto)
                .collect(Collectors.toList());
    }

    public void deleteStudentById(
            Integer id
    ) {
        repository.deleteById(id);
    }
}
