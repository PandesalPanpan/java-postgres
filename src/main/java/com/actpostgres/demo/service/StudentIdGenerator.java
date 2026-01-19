package com.actpostgres.demo.service;

import com.actpostgres.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Year;

@Service
public class StudentIdGenerator {

    private final StudentRepository studentRepository;

    public StudentIdGenerator(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Transactional
    public String generateStudentId() {
        int currentYear = Year.now().getValue();
        String yearPrefix = String.valueOf(currentYear);
        
        // Find the maximum sequence number for the current year
        Long maxSequence = studentRepository.findMaxSequenceForYear(yearPrefix);
        
        // If no students exist for this year, start at 1, otherwise increment
        long nextSequence = (maxSequence == null) ? 1 : maxSequence + 1;
        
        // Format: {YEAR}{SEQUENCE (5 digits)}MN0
        // Example: 202400001MN0, 202400002MN0, etc.
        String sequencePart = String.format("%05d", nextSequence);
        
        return yearPrefix + sequencePart + "MN0";
    }
}
