-- Sample Data for Student Grade Management System
-- Run this SQL script to insert 20 students with their subject grades

-- IMPORTANT:
-- This script assumes the tables are empty and IDs start at 1.
-- If you already have data, TRUNCATE the tables first or adjust the IDs.
--   TRUNCATE TABLE subject_grades RESTART IDENTITY CASCADE;
--   TRUNCATE TABLE students RESTART IDENTITY CASCADE;
--   TRUNCATE TABLE users RESTART IDENTITY CASCADE;

-- ============================================================================
-- INSERT ADMIN USER
-- ============================================================================
-- Password: admin123 (BCrypt hashed)
-- Column order: id, username, password
-- 
-- To generate a new BCrypt hash, run:
--   mvn compile exec:java -Dexec.mainClass="com.actpostgres.demo.util.GeneratePasswordHash"
-- Or use an online BCrypt generator: https://bcrypt-generator.com/
--
INSERT INTO users (username, password) 
VALUES ('admin', '$2a$10$x1eV.bwz8CInj8Sh5WXJtuXf3xWnoSqOWwyZcoAOUj9DK1aNLPyfa');

-- Insert 20 Students
INSERT INTO students (full_name) VALUES ('Juan Dela Cruz');        -- id = 1
INSERT INTO students (full_name) VALUES ('Juanito Mozo');          -- id = 2
INSERT INTO students (full_name) VALUES ('Peter Marticio');        -- id = 3
INSERT INTO students (full_name) VALUES ('Dona Roldan');           -- id = 4
INSERT INTO students (full_name) VALUES ('Luis Valdez');           -- id = 5
INSERT INTO students (full_name) VALUES ('Maria Santos');          -- id = 6
INSERT INTO students (full_name) VALUES ('Carlos Reyes');          -- id = 7
INSERT INTO students (full_name) VALUES ('Ana Navarro');           -- id = 8
INSERT INTO students (full_name) VALUES ('Miguel Torres');         -- id = 9
INSERT INTO students (full_name) VALUES ('Sophia Lim');            -- id = 10
INSERT INTO students (full_name) VALUES ('Daniel Cruz');           -- id = 11
INSERT INTO students (full_name) VALUES ('Patricia Ong');          -- id = 12
INSERT INTO students (full_name) VALUES ('Rafael Gomez');          -- id = 13
INSERT INTO students (full_name) VALUES ('Isabella Flores');       -- id = 14
INSERT INTO students (full_name) VALUES ('Mark Rivera');           -- id = 15
INSERT INTO students (full_name) VALUES ('James Lee');             -- id = 16
INSERT INTO students (full_name) VALUES ('Kristine Tan');          -- id = 17
INSERT INTO students (full_name) VALUES ('Allan Cruz');            -- id = 18
INSERT INTO students (full_name) VALUES ('Grace Villanueva');      -- id = 19
INSERT INTO students (full_name) VALUES ('Henry Ramos');           -- id = 20

-- Common subjects pool for variety
-- MATH101, MATH102, SCI101, SCI102, ENG101, ENG102, FIL101, HIS101

-- Insert Subject Grades for Student 1 - Juan Dela Cruz (6 subjects)
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (1, 'Mathematics I', 'MATH101', '1st', '2025-2026', 95);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (1, 'Mathematics II', 'MATH102', '2nd', '2025-2026', 93);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (1, 'Science I', 'SCI101', '1st', '2025-2026', 88);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (1, 'English I', 'ENG101', '1st', '2025-2026', 92);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (1, 'Filipino I', 'FIL101', '1st', '2025-2026', 90);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (1, 'History I', 'HIS101', '2nd', '2025-2026', 87);

-- Insert Subject Grades for Student 2 - Juanito Mozo (7 subjects)
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (2, 'Mathematics I', 'MATH101', '1st', '2025-2026', 85);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (2, 'Mathematics II', 'MATH102', '2nd', '2025-2026', 88);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (2, 'Science I', 'SCI101', '1st', '2025-2026', 90);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (2, 'Science II', 'SCI102', '2nd', '2025-2026', 89);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (2, 'English I', 'ENG101', '1st', '2025-2026', 88);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (2, 'Filipino I', 'FIL101', '1st', '2025-2026', 92);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (2, 'History I', 'HIS101', '2nd', '2025-2026', 89);

-- Insert Subject Grades for Student 3 - Peter Marticio (8 subjects)
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (3, 'Mathematics I', 'MATH101', '1st', '2025-2026', 98);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (3, 'Mathematics II', 'MATH102', '2nd', '2025-2026', 97);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (3, 'Science I', 'SCI101', '1st', '2025-2026', 95);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (3, 'Science II', 'SCI102', '2nd', '2025-2026', 94);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (3, 'English I', 'ENG101', '1st', '2025-2026', 93);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (3, 'English II', 'ENG102', '2nd', '2025-2026', 92);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (3, 'Filipino I', 'FIL101', '1st', '2025-2026', 91);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (3, 'History I', 'HIS101', '2nd', '2025-2026', 94);

-- Insert Subject Grades for Student 4 - Dona Roldan (6 subjects)
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (4, 'Mathematics I', 'MATH101', '1st', '2025-2026', 90);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (4, 'Science I', 'SCI101', '1st', '2025-2026', 92);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (4, 'Science II', 'SCI102', '2nd', '2025-2026', 91);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (4, 'English I', 'ENG101', '1st', '2025-2026', 95);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (4, 'Filipino I', 'FIL101', '1st', '2025-2026', 93);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (4, 'History I', 'HIS101', '2nd', '2025-2026', 88);

-- Insert Subject Grades for Student 5 - Luis Valdez (7 subjects)
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (5, 'Mathematics I', 'MATH101', '1st', '2025-2026', 87);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (5, 'Mathematics II', 'MATH102', '2nd', '2025-2026', 86);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (5, 'Science I', 'SCI101', '1st', '2025-2026', 85);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (5, 'English I', 'ENG101', '1st', '2025-2026', 90);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (5, 'English II', 'ENG102', '2nd', '2025-2026', 89);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (5, 'Filipino I', 'FIL101', '1st', '2025-2026', 88);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (5, 'History I', 'HIS101', '2nd', '2025-2026', 86);

-- Insert Subject Grades for Student 6 - Maria Santos (6 subjects)
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (6, 'Mathematics I', 'MATH101', '1st', '2025-2026', 89);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (6, 'Mathematics II', 'MATH102', '2nd', '2025-2026', 90);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (6, 'Science I', 'SCI101', '1st', '2025-2026', 87);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (6, 'English I', 'ENG101', '1st', '2025-2026', 93);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (6, 'Filipino I', 'FIL101', '1st', '2025-2026', 92);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (6, 'History I', 'HIS101', '2nd', '2025-2026', 88);

-- Insert Subject Grades for Student 7 - Carlos Reyes (7 subjects)
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (7, 'Mathematics I', 'MATH101', '1st', '2025-2026', 82);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (7, 'Mathematics II', 'MATH102', '2nd', '2025-2026', 84);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (7, 'Science I', 'SCI101', '1st', '2025-2026', 80);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (7, 'Science II', 'SCI102', '2nd', '2025-2026', 83);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (7, 'English I', 'ENG101', '1st', '2025-2026', 85);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (7, 'Filipino I', 'FIL101', '1st', '2025-2026', 87);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (7, 'History I', 'HIS101', '2nd', '2025-2026', 81);

-- Insert Subject Grades for Student 8 - Ana Navarro (8 subjects)
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (8, 'Mathematics I', 'MATH101', '1st', '2025-2026', 91);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (8, 'Mathematics II', 'MATH102', '2nd', '2025-2026', 92);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (8, 'Science I', 'SCI101', '1st', '2025-2026', 89);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (8, 'Science II', 'SCI102', '2nd', '2025-2026', 90);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (8, 'English I', 'ENG101', '1st', '2025-2026', 94);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (8, 'English II', 'ENG102', '2nd', '2025-2026', 93);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (8, 'Filipino I', 'FIL101', '1st', '2025-2026', 92);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (8, 'History I', 'HIS101', '2nd', '2025-2026', 90);

-- Insert Subject Grades for Student 9 - Miguel Torres (6 subjects)
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (9, 'Mathematics I', 'MATH101', '1st', '2025-2026', 76);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (9, 'Mathematics II', 'MATH102', '2nd', '2025-2026', 78);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (9, 'Science I', 'SCI101', '1st', '2025-2026', 80);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (9, 'English I', 'ENG101', '1st', '2025-2026', 82);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (9, 'Filipino I', 'FIL101', '1st', '2025-2026', 79);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (9, 'History I', 'HIS101', '2nd', '2025-2026', 81);

-- Insert Subject Grades for Student 10 - Sophia Lim (7 subjects)
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (10, 'Mathematics I', 'MATH101', '1st', '2025-2026', 93);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (10, 'Mathematics II', 'MATH102', '2nd', '2025-2026', 94);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (10, 'Science I', 'SCI101', '1st', '2025-2026', 92);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (10, 'English I', 'ENG101', '1st', '2025-2026', 95);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (10, 'English II', 'ENG102', '2nd', '2025-2026', 96);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (10, 'Filipino I', 'FIL101', '1st', '2025-2026', 91);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (10, 'History I', 'HIS101', '2nd', '2025-2026', 90);

-- Insert Subject Grades for Student 11 - Daniel Cruz (6 subjects)
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (11, 'Mathematics I', 'MATH101', '1st', '2025-2026', 88);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (11, 'Mathematics II', 'MATH102', '2nd', '2025-2026', 86);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (11, 'Science I', 'SCI101', '1st', '2025-2026', 87);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (11, 'English I', 'ENG101', '1st', '2025-2026', 89);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (11, 'Filipino I', 'FIL101', '1st', '2025-2026', 90);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (11, 'History I', 'HIS101', '2nd', '2025-2026', 85);

-- Insert Subject Grades for Student 12 - Patricia Ong (7 subjects)
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (12, 'Mathematics I', 'MATH101', '1st', '2025-2026', 91);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (12, 'Mathematics II', 'MATH102', '2nd', '2025-2026', 89);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (12, 'Science I', 'SCI101', '1st', '2025-2026', 93);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (12, 'English I', 'ENG101', '1st', '2025-2026', 94);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (12, 'English II', 'ENG102', '2nd', '2025-2026', 92);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (12, 'Filipino I', 'FIL101', '1st', '2025-2026', 90);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (12, 'History I', 'HIS101', '2nd', '2025-2026', 88);

-- Insert Subject Grades for Student 13 - Rafael Gomez (8 subjects)
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (13, 'Mathematics I', 'MATH101', '1st', '2025-2026', 84);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (13, 'Mathematics II', 'MATH102', '2nd', '2025-2026', 86);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (13, 'Science I', 'SCI101', '1st', '2025-2026', 83);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (13, 'Science II', 'SCI102', '2nd', '2025-2026', 85);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (13, 'English I', 'ENG101', '1st', '2025-2026', 87);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (13, 'English II', 'ENG102', '2nd', '2025-2026', 88);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (13, 'Filipino I', 'FIL101', '1st', '2025-2026', 86);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (13, 'History I', 'HIS101', '2nd', '2025-2026', 84);

-- Insert Subject Grades for Student 14 - Isabella Flores (6 subjects)
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (14, 'Mathematics I', 'MATH101', '1st', '2025-2026', 92);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (14, 'Mathematics II', 'MATH102', '2nd', '2025-2026', 94);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (14, 'Science I', 'SCI101', '1st', '2025-2026', 91);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (14, 'English I', 'ENG101', '1st', '2025-2026', 95);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (14, 'Filipino I', 'FIL101', '1st', '2025-2026', 93);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (14, 'History I', 'HIS101', '2nd', '2025-2026', 90);

-- Insert Subject Grades for Student 15 - Mark Rivera (7 subjects)
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (15, 'Mathematics I', 'MATH101', '1st', '2025-2026', 79);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (15, 'Mathematics II', 'MATH102', '2nd', '2025-2026', 81);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (15, 'Science I', 'SCI101', '1st', '2025-2026', 80);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (15, 'Science II', 'SCI102', '2nd', '2025-2026', 82);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (15, 'English I', 'ENG101', '1st', '2025-2026', 83);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (15, 'Filipino I', 'FIL101', '1st', '2025-2026', 84);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (15, 'History I', 'HIS101', '2nd', '2025-2026', 80);

-- Insert Subject Grades for Student 16 - James Lee (8 subjects)
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (16, 'Mathematics I', 'MATH101', '1st', '2025-2026', 88);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (16, 'Mathematics II', 'MATH102', '2nd', '2025-2026', 90);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (16, 'Science I', 'SCI101', '1st', '2025-2026', 87);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (16, 'Science II', 'SCI102', '2nd', '2025-2026', 89);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (16, 'English I', 'ENG101', '1st', '2025-2026', 91);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (16, 'English II', 'ENG102', '2nd', '2025-2026', 92);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (16, 'Filipino I', 'FIL101', '1st', '2025-2026', 90);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (16, 'History I', 'HIS101', '2nd', '2025-2026', 88);

-- Insert Subject Grades for Student 17 - Kristine Tan (6 subjects)
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (17, 'Mathematics I', 'MATH101', '1st', '2025-2026', 94);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (17, 'Mathematics II', 'MATH102', '2nd', '2025-2026', 95);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (17, 'Science I', 'SCI101', '1st', '2025-2026', 93);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (17, 'English I', 'ENG101', '1st', '2025-2026', 96);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (17, 'Filipino I', 'FIL101', '1st', '2025-2026', 94);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (17, 'History I', 'HIS101', '2nd', '2025-2026', 92);

-- Insert Subject Grades for Student 18 - Allan Cruz (7 subjects)
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (18, 'Mathematics I', 'MATH101', '1st', '2025-2026', 81);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (18, 'Mathematics II', 'MATH102', '2nd', '2025-2026', 82);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (18, 'Science I', 'SCI101', '1st', '2025-2026', 80);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (18, 'Science II', 'SCI102', '2nd', '2025-2026', 83);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (18, 'English I', 'ENG101', '1st', '2025-2026', 84);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (18, 'Filipino I', 'FIL101', '1st', '2025-2026', 82);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (18, 'History I', 'HIS101', '2nd', '2025-2026', 81);

-- Insert Subject Grades for Student 19 - Grace Villanueva (8 subjects)
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (19, 'Mathematics I', 'MATH101', '1st', '2025-2026', 90);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (19, 'Mathematics II', 'MATH102', '2nd', '2025-2026', 92);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (19, 'Science I', 'SCI101', '1st', '2025-2026', 89);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (19, 'Science II', 'SCI102', '2nd', '2025-2026', 91);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (19, 'English I', 'ENG101', '1st', '2025-2026', 93);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (19, 'English II', 'ENG102', '2nd', '2025-2026', 94);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (19, 'Filipino I', 'FIL101', '1st', '2025-2026', 92);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (19, 'History I', 'HIS101', '2nd', '2025-2026', 90);

-- Insert Subject Grades for Student 20 - Henry Ramos (6 subjects)
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (20, 'Mathematics I', 'MATH101', '1st', '2025-2026', 78);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (20, 'Mathematics II', 'MATH102', '2nd', '2025-2026', 79);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (20, 'Science I', 'SCI101', '1st', '2025-2026', 77);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (20, 'English I', 'ENG101', '1st', '2025-2026', 80);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (20, 'Filipino I', 'FIL101', '1st', '2025-2026', 81);
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade)
VALUES (20, 'History I', 'HIS101', '2nd', '2025-2026', 79);

-- SELECT s.id, s.full_name, COUNT(sg.id) as subject_count 
-- FROM students s 
-- LEFT JOIN subject_grades sg ON s.id = sg.student_id 
-- GROUP BY s.id, s.full_name 
-- ORDER BY s.id;

-- SELECT s.full_name, sg.subject_name, sg.subject_code, sg.grade 
-- FROM students s 
-- JOIN subject_grades sg ON s.id = sg.student_id 
-- ORDER BY s.id, sg.subject_name;


-- ============================================================================
-- OPTIONAL: NORMALIZE GRADES TO COLLEGE SCALE (1.00–3.00 PASSING, 5.00 FAIL)
-- Run this block AFTER inserting the sample data above if your current grades
-- are in percentage form (e.g., 75–99) and you want them in college scale.
--
-- Resulting grades will only be in:
--   1.00, 1.25, 1.50, 1.75,
--   2.00, 2.25, 2.50, 2.75,
--   3.00, 5.00
-- There will be NO 3.25 / 3.5 etc.
-- ============================================================================

-- Example mapping (you can tweak ranges if your professor uses a specific table):
--   96–100 → 1.00
--   93–95  → 1.25
--   90–92  → 1.50
--   87–89  → 1.75
--   84–86  → 2.00
--   81–83  → 2.25
--   78–80  → 2.50
--   75–77  → 2.75
--   70–74  → 3.00   (minimum passing)
--   <70    → 5.00   (failed)

UPDATE subject_grades
SET grade = CASE
    WHEN grade >= 96 THEN 1.00
    WHEN grade >= 93 THEN 1.25
    WHEN grade >= 90 THEN 1.50
    WHEN grade >= 87 THEN 1.75
    WHEN grade >= 84 THEN 2.00
    WHEN grade >= 81 THEN 2.25
    WHEN grade >= 78 THEN 2.50
    WHEN grade >= 75 THEN 2.75
    WHEN grade >= 70 THEN 3.00
    ELSE 5.00
END;

