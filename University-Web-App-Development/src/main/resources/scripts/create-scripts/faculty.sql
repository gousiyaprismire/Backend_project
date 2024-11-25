
CREATE TABLE Faculty (
    id INT AUTO_INCREMENT PRIMARY KEY,       -- Unique identifier for faculty
    name VARCHAR(100) NOT NULL,              -- Faculty name
    biodata TEXT NOT NULL,                   -- Biodata of the faculty
    subjects TEXT NOT NULL,                  -- Subjects they teach (comma-separated)
    email VARCHAR(150) NOT NULL UNIQUE       -- Faculty email
);
	