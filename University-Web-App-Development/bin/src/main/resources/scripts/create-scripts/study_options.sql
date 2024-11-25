
CREATE TABLE Study_Options (
    id INT AUTO_INCREMENT PRIMARY KEY,       -- Unique identifier for courses
    name VARCHAR(150) NOT NULL,              -- Name of the course
    level VARCHAR(50) NOT NULL,              -- Level of the course (e.g., Bachelor's, Master's)
    field_of_study VARCHAR(100) NOT NULL,    -- Field of study (e.g., Computer Science)
    duration VARCHAR(50) NOT NULL,           -- Course duration
    description TEXT NOT NULL,               -- Course description
    entry_requirements TEXT NOT NULL         -- Entry requirements
);
