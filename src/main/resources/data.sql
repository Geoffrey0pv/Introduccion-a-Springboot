/*======================================================================
  1. PROFESORES  -------------------------------------------------------
  ======================================================================*/
INSERT INTO professors (name) VALUES
                                  ('Gabriel Tamura'),
                                  ('Ángela Villota'),
                                  ('Andrés Aristizábal'),
                                  ('Rocío Segovia'),
                                  ('Claudia Castiblanco')
    ON CONFLICT DO NOTHING;


/*======================================================================
  2. CURSOS  (referencian profesor)  -----------------------------------
  ======================================================================*/
INSERT INTO courses (name, professor_id) VALUES
                                             ('Ingeniería de Software IV',
                                              (SELECT id FROM professors WHERE name = 'Gabriel Tamura')),
                                             ('Computación y Estructuras Discretas III',
                                              (SELECT id FROM professors WHERE name = 'Ángela Villota')),
                                             ('Computación y Estructuras Discretas II',
                                              (SELECT id FROM professors WHERE name = 'Andrés Aristizábal')),
                                             ('Ingeniería de Software III',
                                              (SELECT id FROM professors WHERE name = 'Rocío Segovia')),
                                             ('Proyecto Integrador I',
                                              (SELECT id FROM professors WHERE name = 'Claudia Castiblanco'))
    ON CONFLICT DO NOTHING;


/*======================================================================
  3. ESTUDIANTES  ------------------------------------------------------
  ======================================================================*/
INSERT INTO students (code, name, program) VALUES
                                               ('A00001','Juan Pérez','SIS'),
                                               ('A00002','María Gómez','SIS'),
                                               ('A00003','Miguel Rodríguez','TEL'),
                                               ('A00004','Lucía Fernández','DMI'),
                                               ('A00005','Daniela Ramírez','TEL'),
                                               ('A00006','Santiago Morales','SIS'),
                                               ('A00007','Valentina Castro','DMI'),
                                               ('A00008','Carlos Méndez','SIS'),
                                               ('A00009','Javier Ortega','IBQ'),
                                               ('A00010','Camila Rojas','MED'),
                                               ('A00011','Andrés Herrera','ENI'),
                                               ('A00012','Natalia Vargas','IBQ'),
                                               ('A00013','Emiliano Suárez','SIS'),
                                               ('A00014','Sofía León','TEL'),
                                               ('A00015','Alejandro Pineda','IND'),
                                               ('A00016','Isabela Cárdenas','PSI'),
                                               ('A00017','Mateo Torres','DIS'),
                                               ('A00018','Gabriela Mendoza','TEL'),
                                               ('A00019','Luis Álvarez','DIS'),
                                               ('A00020','Fernanda Espinosa','ENI')
    ON CONFLICT DO NOTHING;

/*======================================================================
  4. MATRÍCULAS  -------------------------------------------------------
  ======================================================================*/
-- helper: función inline que busca ids por código o nombre
-- (Postgres permite sub-selects en VALUES)
INSERT INTO enrollments (student_id, course_id) VALUES
    /* ───────── Ingeniería de Software IV ───────── */
                                                    ((SELECT id FROM students WHERE code = 'A00001'),
                                                     (SELECT id FROM courses  WHERE name = 'Ingeniería de Software IV')),
                                                    ((SELECT id FROM students WHERE code = 'A00002'),
                                                     (SELECT id FROM courses  WHERE name = 'Ingeniería de Software IV')),
                                                    ((SELECT id FROM students WHERE code = 'A00006'),
                                                     (SELECT id FROM courses  WHERE name = 'Ingeniería de Software IV')),
                                                    ((SELECT id FROM students WHERE code = 'A00008'),
                                                     (SELECT id FROM courses  WHERE name = 'Ingeniería de Software IV')),
                                                    ((SELECT id FROM students WHERE code = 'A00013'),
                                                     (SELECT id FROM courses  WHERE name = 'Ingeniería de Software IV')),

    /* ───────── Computación y Estructuras Discretas III ───────── */
                                                    ((SELECT id FROM students WHERE code = 'A00001'),
                                                     (SELECT id FROM courses  WHERE name = 'Computación y Estructuras Discretas III')),
                                                    ((SELECT id FROM students WHERE code = 'A00002'),
                                                     (SELECT id FROM courses  WHERE name = 'Computación y Estructuras Discretas III')),
                                                    ((SELECT id FROM students WHERE code = 'A00003'),
                                                     (SELECT id FROM courses  WHERE name = 'Computación y Estructuras Discretas III')),
                                                    ((SELECT id FROM students WHERE code = 'A00006'),
                                                     (SELECT id FROM courses  WHERE name = 'Computación y Estructuras Discretas III')),
                                                    ((SELECT id FROM students WHERE code = 'A00014'),
                                                     (SELECT id FROM courses  WHERE name = 'Computación y Estructuras Discretas III')),

    /* ───────── Computación y Estructuras Discretas II ───────── */
                                                    ((SELECT id FROM students WHERE code = 'A00003'),
                                                     (SELECT id FROM courses  WHERE name = 'Computación y Estructuras Discretas II')),
                                                    ((SELECT id FROM students WHERE code = 'A00005'),
                                                     (SELECT id FROM courses  WHERE name = 'Computación y Estructuras Discretas II')),
                                                    ((SELECT id FROM students WHERE code = 'A00010'),
                                                     (SELECT id FROM courses  WHERE name = 'Computación y Estructuras Discretas II')),
                                                    ((SELECT id FROM students WHERE code = 'A00012'),
                                                     (SELECT id FROM courses  WHERE name = 'Computación y Estructuras Discretas II')),
                                                    ((SELECT id FROM students WHERE code = 'A00018'),
                                                     (SELECT id FROM courses  WHERE name = 'Computación y Estructuras Discretas II')),

    /* ───────── Ingeniería de Software III ───────── */
                                                    ((SELECT id FROM students WHERE code = 'A00001'),
                                                     (SELECT id FROM courses  WHERE name = 'Ingeniería de Software III')),
                                                    ((SELECT id FROM students WHERE code = 'A00004'),
                                                     (SELECT id FROM courses  WHERE name = 'Ingeniería de Software III')),
                                                    ((SELECT id FROM students WHERE code = 'A00006'),
                                                     (SELECT id FROM courses  WHERE name = 'Ingeniería de Software III')),
                                                    ((SELECT id FROM students WHERE code = 'A00009'),
                                                     (SELECT id FROM courses  WHERE name = 'Ingeniería de Software III')),
                                                    ((SELECT id FROM students WHERE code = 'A00013'),
                                                     (SELECT id FROM courses  WHERE name = 'Ingeniería de Software III')),

    /* ───────── Proyecto Integrador I ───────── */
                                                    ((SELECT id FROM students WHERE code = 'A00007'),
                                                     (SELECT id FROM courses  WHERE name = 'Proyecto Integrador I')),
                                                    ((SELECT id FROM students WHERE code = 'A00008'),
                                                     (SELECT id FROM courses  WHERE name = 'Proyecto Integrador I')),
                                                    ((SELECT id FROM students WHERE code = 'A00011'),
                                                     (SELECT id FROM courses  WHERE name = 'Proyecto Integrador I')),
                                                    ((SELECT id FROM students WHERE code = 'A00015'),
                                                     (SELECT id FROM courses  WHERE name = 'Proyecto Integrador I')),
                                                    ((SELECT id FROM students WHERE code = 'A00020'),
                                                     (SELECT id FROM courses  WHERE name = 'Proyecto Integrador I'))
    ON CONFLICT DO NOTHING;


/*======================================================================
  5. USUARIO DE PRUEBA --------------------------------------------------
  ======================================================================*/
INSERT INTO roles (id,name) VALUES (1,'ADMIN'),(2,'PROFESSOR');

INSERT INTO users (id,username,password,email) VALUES
    (1,'geoffrey','$2a$12$t2fHJtRhCs67uAxwaeCaY.EoEBv2OEsPRapNsK7HlzX3mK8RBbwb.', 'geoffrey@gmail.com');

INSERT INTO user_roles (user_id,role_id) VALUES (1,1);
