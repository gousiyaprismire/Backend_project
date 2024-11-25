
CREATE TABLE Scholarships (
    id INT AUTO_INCREMENT PRIMARY KEY,       -- Unique identifier for scholarships
    name VARCHAR(150) NOT NULL,              -- Name of the scholarship
    type VARCHAR(50) NOT NULL,               -- Type of scholarship (e.g., merit-based, need-based)
    eligibility TEXT NOT NULL,               -- Eligibility criteria
    benefits TEXT NOT NULL,                  -- Scholarship benefits
    application_deadline DATE NOT NULL,      -- Application deadline
    apply_link TEXT                          -- Link to the application form
);