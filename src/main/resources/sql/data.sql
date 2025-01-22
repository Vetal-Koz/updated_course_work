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
    (1, 5),
    (5, 1),
    (6, 1),
    (6, 5),
    (1, 6),
    (5, 6)
