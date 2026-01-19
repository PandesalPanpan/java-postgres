-- Create tables for Spring Boot application
-- Database: pidro

-- Drop tables if they exist (in reverse order of dependencies)
DROP TABLE IF EXISTS subject_grades CASCADE;
DROP TABLE IF EXISTS students CASCADE;
DROP TABLE IF EXISTS users CASCADE;

-- Create users table
CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

-- Create students table
CREATE TABLE students (
    id BIGSERIAL PRIMARY KEY,
    student_id VARCHAR(15) NOT NULL UNIQUE,
    full_name VARCHAR(255) NOT NULL
);

-- Create subject_grades table
CREATE TABLE subject_grades (
    id BIGSERIAL PRIMARY KEY,
    student_id BIGINT NOT NULL,
    subject_name VARCHAR(255) NOT NULL,
    subject_code VARCHAR(255) NOT NULL,
    semester VARCHAR(255) NOT NULL,
    school_year VARCHAR(255) NOT NULL,
    grade DECIMAL(5,2) NOT NULL,
    CONSTRAINT fk_subject_grade_student 
        FOREIGN KEY (student_id) 
        REFERENCES students(id) 
        ON DELETE CASCADE
);

-- Create indexes for better query performance
CREATE INDEX idx_subject_grades_student_id ON subject_grades(student_id);
CREATE INDEX idx_subject_grades_subject_code ON subject_grades(subject_code);
CREATE INDEX idx_users_username ON users(username);
CREATE INDEX idx_students_student_id ON students(student_id);
