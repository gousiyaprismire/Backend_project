
CREATE TABLE Admin (
    id Long AUTO_INCREMENT PRIMARY KEY,       -- Unique identifier for each user
    fullname VARCHAR(100) NOT NULL,              -- User's full name
    email VARCHAR(150) NOT NULL UNIQUE,      -- User's email address (must be unique)
    password VARCHAR(255) NOT NULL,          -- Encrypted password
   contactNumber VARCHAR(255) NOT NULL,
   username VARCHAR(255) NOT NULL,
   adminId VARCHAR(255) NOT NULL,
);
