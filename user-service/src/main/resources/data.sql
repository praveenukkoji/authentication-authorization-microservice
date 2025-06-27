-- Create table if not exists
CREATE TABLE IF NOT EXISTS users (
    id UUID PRIMARY KEY,
    fullname VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
    );

-- Insert users only if not already present
INSERT INTO users (id, fullname, email, password)
SELECT '7b13c621-4c5b-4f72-92b6-21a50af47323', 'Boss Kumar', 'boss@example.com', 'pass123'
    WHERE NOT EXISTS (SELECT 1 FROM users WHERE email = 'boss@example.com');

INSERT INTO users (id, fullname, email, password)
SELECT 'eac4d8d1-b3a0-4573-a0b1-e14e364aeb38', 'Priya Sharma', 'priya@example.com', 'pass123'
    WHERE NOT EXISTS (SELECT 1 FROM users WHERE email = 'priya@example.com');

INSERT INTO users (id, fullname, email, password)
SELECT 'd42cc59a-884b-4f2c-baa6-c9cba344e441', 'Ravi Verma', 'ravi@example.com', 'pass123'
    WHERE NOT EXISTS (SELECT 1 FROM users WHERE email = 'ravi@example.com');

INSERT INTO users (id, fullname, email, password)
SELECT '9c6ae9f4-f9df-4b5c-bc7a-740b1e2ce50f', 'Anjali Das', 'anjali@example.com', 'pass123'
    WHERE NOT EXISTS (SELECT 1 FROM users WHERE email = 'anjali@example.com');

INSERT INTO users (id, fullname, email, password)
SELECT '19a6cf3f-3b3b-4e4f-bca4-b45df8ea6813', 'Amit Singh', 'amit@example.com', 'pass123'
    WHERE NOT EXISTS (SELECT 1 FROM users WHERE email = 'amit@example.com');
