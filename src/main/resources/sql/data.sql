INSERT INTO classes (name, form) VALUES
    ('Department', 'DepartmentForm'),
    ('Document', 'DocumentForm'),
    ('ElectronicDocument', 'ElectronicDocumentForm'),
    ('Employee', 'EmployeeForm'),
    ('Faculty', 'FacultyForm'),
    ('Folder', 'FolderForm'),
    ('Immovable', 'ImmovableForm'),
    ('MaterialMean', 'MaterialMeanForm'),
    ('Movable', 'MovableForm'),
    ('MultimediaDocument', 'MultimediaDocumentForm'),
    ('PaperDocument', 'PaperDocumentForm'),
    ('Person', 'PersonForm'),
    ('Student', 'StudentForm'),
    ('Subdivision', 'SubdivisionForm'),
    ('Teacher', 'TeacherForm'),
    ('Technicalstaff', 'TechnicalstaffForm'),
    ('TextDocument', 'TextDocumentForm'),
    ('Uniobject', 'UniobjectForm');


INSERT INTO class_relations (child_class_id, parent_class_id) VALUES
    (5, 1),
    (6, 1),
    (6, 5),
    (1, 6),
    (5, 6),
    (1, 5), -- Кафедра належить факультету
    (14, 5), -- Підрозділ належить факультету
    (4, 5), -- Працівник працює у факультеті
    (13, 5), -- Студент навчається на факультеті

    -- Кафедра містить викладачів, студентів, документи
    (15, 1), -- Викладач належить кафедрі
    (13, 1), -- Студент може бути прив'язаний до кафедри
    (2, 1); -- Документ пов'язаний з кафедрою


INSERT INTO methods (class_id, form, method_name) VALUES
    (13, 'ExpelForm', 'ExpelFromUniversity')
