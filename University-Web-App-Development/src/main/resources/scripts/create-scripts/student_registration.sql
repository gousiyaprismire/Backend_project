CREATE TABLE student_registration (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    fullname VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    mobile VARCHAR(13) NOT NULL,
    upload_id VARCHAR(255) NOT NULL,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    country VARCHAR(255) NOT NULL,
    enroll_date DATE DEFAULT CURRENT_DATE,
    status VARCHAR(50) DEFAULT 'pending'
);
