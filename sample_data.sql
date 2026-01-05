-- Sample Data for Student Grade Management System
-- Run this SQL script to insert 5 students with their subject grades

-- Insert Students
INSERT INTO students (full_name) VALUES ('Juan Dela Cruz');
INSERT INTO students (full_name) VALUES ('Juanito Mozo');
INSERT INTO students (full_name) VALUES ('Peter Marticio');
INSERT INTO students (full_name) VALUES ('Dona Roldan');
INSERT INTO students (full_name) VALUES ('Luis Valdez');

-- Insert Subject Grades for Juan Dela Cruz (student_id = 1)
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade) 
VALUES (1, 'Mathematics', 'MATH101', '1st', '2025-2026', 95);

INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade) 
VALUES (1, 'Science', 'SCI101', '1st', '2025-2026', 88);

INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade) 
VALUES (1, 'English', 'ENG101', '1st', '2025-2026', 92);

INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade) 
VALUES (1, 'Filipino', 'FIL101', '1st', '2025-2026', 90);

INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade) 
VALUES (1, 'History', 'HIS101', '1st', '2025-2026', 87);

-- Insert Subject Grades for Juanito Mozo (student_id = 2)
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade) 
VALUES (2, 'Mathematics', 'MATH101', '1st', '2025-2026', 85);

INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade) 
VALUES (2, 'Science', 'SCI101', '1st', '2025-2026', 90);

INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade) 
VALUES (2, 'English', 'ENG101', '1st', '2025-2026', 88);

INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade) 
VALUES (2, 'Filipino', 'FIL101', '1st', '2025-2026', 92);

INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade) 
VALUES (2, 'History', 'HIS101', '1st', '2025-2026', 89);

-- Insert Subject Grades for Peter Marticio (student_id = 3)
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade) 
VALUES (3, 'Mathematics', 'MATH101', '1st', '2025-2026', 98);

INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade) 
VALUES (3, 'Science', 'SCI101', '1st', '2025-2026', 95);

INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade) 
VALUES (3, 'English', 'ENG101', '1st', '2025-2026', 93);

INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade) 
VALUES (3, 'Filipino', 'FIL101', '1st', '2025-2026', 91);

INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade) 
VALUES (3, 'History', 'HIS101', '1st', '2025-2026', 94);

-- Insert Subject Grades for Dona Roldan (student_id = 4)
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade) 
VALUES (4, 'Mathematics', 'MATH101', '1st', '2025-2026', 90);

INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade) 
VALUES (4, 'Science', 'SCI101', '1st', '2025-2026', 92);

INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade) 
VALUES (4, 'English', 'ENG101', '1st', '2025-2026', 95);

INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade) 
VALUES (4, 'Filipino', 'FIL101', '1st', '2025-2026', 93);

INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade) 
VALUES (4, 'History', 'HIS101', '1st', '2025-2026', 88);

-- Insert Subject Grades for Luis Valdez (student_id = 5)
INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade) 
VALUES (5, 'Mathematics', 'MATH101', '1st', '2025-2026', 87);

INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade) 
VALUES (5, 'Science', 'SCI101', '1st', '2025-2026', 85);

INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade) 
VALUES (5, 'English', 'ENG101', '1st', '2025-2026', 90);

INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade) 
VALUES (5, 'Filipino', 'FIL101', '1st', '2025-2026', 88);

INSERT INTO subject_grades (student_id, subject_name, subject_code, semester, school_year, grade) 
VALUES (5, 'History', 'HIS101', '1st', '2025-2026', 86);

-- Verification Queries (Optional - uncomment to check the data)
-- SELECT s.id, s.full_name, COUNT(sg.id) as subject_count 
-- FROM students s 
-- LEFT JOIN subject_grades sg ON s.id = sg.student_id 
-- GROUP BY s.id, s.full_name 
-- ORDER BY s.id;

-- SELECT s.full_name, sg.subject_name, sg.subject_code, sg.grade 
-- FROM students s 
-- JOIN subject_grades sg ON s.id = sg.student_id 
-- ORDER BY s.id, sg.subject_name;

