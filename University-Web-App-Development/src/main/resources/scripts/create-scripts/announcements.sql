
CREATE TABLE Announcements (
    id INT AUTO_INCREMENT PRIMARY KEY,       -- Unique identifier for announcements
    title VARCHAR(255) NOT NULL,             -- Title of the announcement
    content TEXT NOT NULL,                   -- Content of the announcement
    date DATE NOT NULL                       -- Announcement date
);
