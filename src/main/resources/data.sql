INSERT INTO student_tb VALUES (default,'Thearith','threarithzin126@gmail.com','0999999');
INSERT INTO instructors_tb VALUES (default,'Chea Menglim','menglimsingle007@gmail.com');

INSERT INTO course_tb VALUES (DEFAULT,'Java','After Learn this student can move to Spring Boot ',4);
INSERT INTO student_course_tb VALUES (10,13);



SELECT * FROM student_course_tb bc INNER JOIN course_tb c
    ON bc.course_id = c.course_id
    WHERE student_id = 14;
;