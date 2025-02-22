DROP TABLE IF EXISTS user_workouts;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS workouts;
DROP TABLE IF EXISTS categories;

CREATE TABLE users (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT NOT NULL,
    email TEXT UNIQUE NOT NULL,
    age INTEGER CHECK (age >= 0),
    weight REAL CHECK (weight > 0)
);

CREATE TABLE categories (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT NOT NULL UNIQUE
);

CREATE TABLE workouts (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT NOT NULL,
    description TEXT,
    category_id INTEGER,
    FOREIGN KEY (category_id) REFERENCES categories(id) ON DELETE SET NULL
);

CREATE TABLE user_workouts (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    user_id INTEGER NOT NULL,
    workout_id INTEGER NOT NULL,
    date TEXT NOT NULL DEFAULT CURRENT_DATE,
    duration INTEGER NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (workout_id) REFERENCES workouts(id) ON DELETE CASCADE
);

INSERT INTO users (name, email, age, weight) VALUES
('John Doe', 'john.doe@example.com', 28, 75.5),
('Jane Smith', 'jane.smith@example.com', 32, 65.2),
('Mike Johnson', 'mike.johnson@example.com', 40, 82.3);

INSERT INTO categories (name) VALUES
('Cardio'),
('Strength Training'),
('Flexibility'),
('Endurance');

INSERT INTO workouts (name, description, category_id) VALUES
('Treadmill Running', 'Running on a treadmill at a moderate pace.', 1),
('Bench Press', 'Lifting weights on a bench press.', 2),
('Yoga Stretching', 'A set of yoga poses for flexibility.', 3),
('Cycling', 'Stationary bike workout for endurance.', 4),
('Deadlifts', 'A weightlifting exercise that targets multiple muscle groups.', 2);

INSERT INTO user_workouts (user_id, workout_id, date, duration) VALUES
(1, 1, '2025-02-01', 30),
(1, 2, '2025-02-02', 45),
(2, 3, '2025-02-03', 60),
(2, 4, '2025-02-04', 50),
(3, 5, '2025-02-05', 40),
(3, 1, '2025-02-06', 35);
