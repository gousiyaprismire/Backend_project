CREATE TABLE Student1 (
    studentId BIGINT PRIMARY KEY,
    country VARCHAR(255),
    university VARCHAR(255),
    name VARCHAR(255),
    email VARCHAR(255),
    isVerified BOOLEAN DEFAULT FALSE
);
