
CREATE TABLE user (
    id INT AUTO_INCREMENT PRIMARY KEY,       -- Unique identifier for each user
    name VARCHAR(100) NOT NULL,              -- User's full name
    email VARCHAR(150) NOT NULL UNIQUE,      -- User's email address (must be unique)
    password VARCHAR(255) NOT NULL,          -- Encrypted password
    role ENUM('student', 'admin') NOT NULL,  -- Role of the user (student or admin)
    status ENUM('pending', 'verified') DEFAULT 'pending', -- Verification status
);
