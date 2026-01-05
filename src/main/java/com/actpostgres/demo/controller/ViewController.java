package com.actpostgres.demo.controller;

import com.actpostgres.demo.model.*;
import com.actpostgres.demo.repository.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/")
public class ViewController {

    private final StudentRepository studentRepository;
    private final SubjectGradeRepository subjectGradeRepository;

    public ViewController(StudentRepository studentRepository, 
                         SubjectGradeRepository subjectGradeRepository) {
        this.studentRepository = studentRepository;
        this.subjectGradeRepository = subjectGradeRepository;
    }

    @GetMapping
    public String home(Model model) {
        List<Student> students = studentRepository.findAll();
        model.addAttribute("students", students);
        return "index";
    }

    @GetMapping("/students/{studentId}")
    public String viewStudent(@PathVariable Long studentId, Model model) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        List<SubjectGrade> subjectGrades = subjectGradeRepository.findByStudentId(studentId);
        model.addAttribute("student", student);
        model.addAttribute("subjectGrades", subjectGrades);
        return "student-detail";
    }

    @PostMapping("/students")
    public String createStudent(@RequestParam String fullName, RedirectAttributes redirectAttributes) {
        Student student = new Student(fullName);
        studentRepository.save(student);
        redirectAttributes.addFlashAttribute("message", "Student created successfully!");
        return "redirect:/";
    }

    @PostMapping("/students/{studentId}/subjects")
    public String addSubject(@PathVariable Long studentId,
                            @RequestParam String subjectName,
                            @RequestParam String subjectCode,
                            @RequestParam String semester,
                            @RequestParam String schoolYear,
                            @RequestParam Double grade,
                            RedirectAttributes redirectAttributes) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        
        SubjectGrade subjectGrade = new SubjectGrade(
                student,
                subjectName,
                subjectCode,
                semester,
                schoolYear,
                java.math.BigDecimal.valueOf(grade)
        );
        subjectGradeRepository.save(subjectGrade);
        redirectAttributes.addFlashAttribute("message", "Subject grade added successfully!");
        return "redirect:/students/" + studentId;
    }

    @PostMapping("/students/{studentId}/delete")
    public String deleteStudent(@PathVariable Long studentId, RedirectAttributes redirectAttributes) {
        studentRepository.deleteById(studentId);
        redirectAttributes.addFlashAttribute("message", "Student deleted successfully!");
        return "redirect:/";
    }

    @PostMapping("/subjects/{subjectGradeId}/delete")
    public String deleteSubject(@PathVariable Long subjectGradeId, 
                               @RequestParam Long studentId,
                               RedirectAttributes redirectAttributes) {
        subjectGradeRepository.deleteById(subjectGradeId);
        redirectAttributes.addFlashAttribute("message", "Subject grade deleted successfully!");
        return "redirect:/students/" + studentId;
    }
}

