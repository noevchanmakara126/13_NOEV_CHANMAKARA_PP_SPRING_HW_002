CREATE TABLE IF NOT EXISTS student_tb (
    stu_id SERIAL PRIMARY KEY ,
    stu_name    VARCHAR(100) NOT NULL ,
    email VARCHAR(100) NOT NULL ,
    phone_num INTEGER NOT NULL
);
CREATE TABLE IF NOT EXISTS course_tb (
    course_id SERIAL PRIMARY KEY ,
    course_name VARCHAR(100) NOT NULL ,
    description VARCHAR(200) NOT NULL ,
    instructor_id INTEGER ,
    CONSTRAINT fk_CourseInstructor FOREIGN KEY (instructor_id) REFERENCES instructors_tb(instructor_id) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE TABLE IF NOT EXISTS instructors_tb (
    instructor_id SERIAL PRIMARY KEY ,
    instuctor_name VARCHAR(100) NOT NULL ,
    email VARCHAR(100)
);
CREATE TABLE IF NOT EXISTS student_course_tb (
    student_id INTEGER NOT NULL ,
    course_id INTEGER NOT NULL,
    PRIMARY KEY (student_id,course_id),
    CONSTRAINT fk_student FOREIGN KEY (student_id) REFERENCES student_tb(stu_id) ON DELETE CASCADE  ON UPDATE CASCADE ,
    CONSTRAINT fk_course FOREIGN KEY (course_id) REFERENCES  course_tb(course_id) ON DELETE CASCADE ON UPDATE CASCADE
)

