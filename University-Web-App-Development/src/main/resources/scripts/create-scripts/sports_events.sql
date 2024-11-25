
CREATE TABLE Sports_Events (
    id INT AUTO_INCREMENT PRIMARY KEY,       -- Unique identifier for events
    sport_id INT NOT NULL,                   -- References the Sports table
    event_name VARCHAR(150) NOT NULL,        -- Name of the event
    event_date DATE NOT NULL,                -- Date of the event
    location VARCHAR(255) NOT NULL,          -- Location of the event
    FOREIGN KEY (sport_id) REFERENCES Sports(id) ON DELETE CASCADE
);
