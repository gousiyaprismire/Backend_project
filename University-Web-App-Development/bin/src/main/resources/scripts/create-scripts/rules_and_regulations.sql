
CREATE TABLE Rules_And_Regulations (
    id INT AUTO_INCREMENT PRIMARY KEY,       -- Unique identifier for rules
    rule VARCHAR(255) NOT NULL,              -- Title or summary of the rule
    description TEXT NOT NULL                -- Detailed description of the rule
);
