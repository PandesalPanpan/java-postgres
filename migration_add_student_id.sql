-- Migration script to add student_id column to existing students table
-- Run this script if you have an existing database with student data

-- Add the student_id column (nullable initially to allow existing data)
ALTER TABLE students ADD COLUMN IF NOT EXISTS student_id VARCHAR(15);

-- Create index for the new column
CREATE INDEX IF NOT EXISTS idx_students_student_id ON students(student_id);

-- Note: After running this migration, you'll need to:
-- 1. Generate student IDs for existing records (if any)
-- 2. Then make the column NOT NULL and UNIQUE:
--    ALTER TABLE students ALTER COLUMN student_id SET NOT NULL;
--    ALTER TABLE students ADD CONSTRAINT uk_students_student_id UNIQUE (student_id);
