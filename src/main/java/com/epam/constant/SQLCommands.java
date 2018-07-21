package com.epam.constant;

public class SQLCommands {

    public static final String TABLE_EXAM = "CREATE TABLE `exam` (\n" +
            "  `exam_id` int(11) NOT NULL,\n" +
            "  `stud_id` int(11) NOT NULL,\n" +
            "  `sub_id` int(11) NOT NULL,\n" +
            "  `date_of_exam` date NOT NULL,\n" +
            "  `stud_mark` int(11) DEFAULT NULL,\n" +
            "  PRIMARY KEY (`exam_id`),\n" +
            "  KEY `sub_id_idx` (`sub_id`),\n" +
            "  KEY `stud_id_idx` (`stud_id`)\n" +
            ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci";
    public static final String TABLE_GRADEBOOK = "CREATE TABLE `gradebook` (\n" +
            "  `gb_number` int(11) NOT NULL,\n" +
            "  `date_of_admission` date NOT NULL,\n" +
            "  `st_group` varchar(45) NOT NULL,\n" +
            "  `course` int(11) NOT NULL,\n" +
            "  `form_of_education` varchar(45) NOT NULL,\n" +
            "  `spec_id` int(11) NOT NULL,\n" +
            "  PRIMARY KEY (`gb_number`),\n" +
            "  KEY `spec_id_idx` (`spec_id`)\n" +
            ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci";
    public static final String TABLE_PASSPORT = "CREATE TABLE `passport` (\n" +
            "  `pass_serial_number` int(11) NOT NULL,\n" +
            "  `gender` varchar(45) NOT NULL,\n" +
            "  `date_of_birth` date NOT NULL,\n" +
            "  `father_or_mother_full_name` varchar(45) NOT NULL,\n" +
            "  `address` varchar(45) NOT NULL,\n" +
            "  PRIMARY KEY (`pass_serial_number`)\n" +
            ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci";
    public static final String TABLE_SPECIALTY = "CREATE TABLE `specialty` (\n" +
            "  `spec_id` int(11) NOT NULL,\n" +
            "  `spec_name` varchar(45) NOT NULL,\n" +
            "  `spec_description` varchar(45) DEFAULT NULL,\n" +
            "  PRIMARY KEY (`spec_id`)\n" +
            ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci";
    public static final String TABLE_STUDENT = "CREATE TABLE `student` (\n" +
            "  `stud_id` int(11) NOT NULL,\n" +
            "  `stud_fname` varchar(45) NOT NULL,\n" +
            "  `stud_lname` varchar(45) NOT NULL,\n" +
            "  `stud_middle_name` varchar(45) DEFAULT NULL,\n" +
            "  `stud_phone_number` varchar(45) DEFAULT NULL,\n" +
            "  `pass_serial_number` int(11) NOT NULL,\n" +
            "  `gb_number` int(11) NOT NULL,\n" +
            "  PRIMARY KEY (`stud_id`),\n" +
            "  KEY `pass_serial_number_idx` (`pass_serial_number`),\n" +
            "  KEY `gb_number_idx` (`gb_number`)\n" +
            ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci";
    public static final String TABLE_SUBJECT = "CREATE TABLE `subject` (\n" +
            "  `sub_id` int(11) NOT NULL,\n" +
            "  `sub_name` varchar(45) NOT NULL,\n" +
            "  `sub_description` varchar(45) DEFAULT NULL,\n" +
            "  PRIMARY KEY (`sub_id`)\n" +
            ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci";
    public static final String EXAM_CONSTRAINTS = "ALTER TABLE exam\n" +
            "ADD CONSTRAINT `stud_id` FOREIGN KEY (`stud_id`) REFERENCES `student` (`stud_id`) ON DELETE CASCADE ON UPDATE CASCADE,\n" +
            "ADD CONSTRAINT `sub_id` FOREIGN KEY (`sub_id`) REFERENCES `subject` (`sub_id`) ON DELETE CASCADE ON UPDATE CASCADE";
    public static final String GRADEBOOK_CONSTRAINTS = "ALTER TABLE gradebook\n" +
            "ADD CONSTRAINT `spec_id` FOREIGN KEY (`spec_id`) REFERENCES `specialty` (`spec_id`) ON DELETE CASCADE ON UPDATE CASCADE";
    public static final String STUDENT_CONSTRAINTS = "ALTER TABLE student\n" +
            "ADD CONSTRAINT `gb_number` FOREIGN KEY (`gb_number`) REFERENCES `gradebook` (`gb_number`) ON DELETE CASCADE ON UPDATE CASCADE,\n" +
            "ADD CONSTRAINT `pass_serial_number` FOREIGN KEY (`pass_serial_number`) REFERENCES `passport` (`pass_serial_number`) ON DELETE CASCADE ON UPDATE CASCADE";
    public static final String EXAM_INSERT = "INSERT INTO exam (exam_id,stud_id,sub_id,date_of_exam,stud_mark) values\n" +
            "(2,3,1,'2018-06-04',4),\n" +
            "(3,1,3,'2018-06-07',3),\n" +
            "(5,2,4,'2018-06-11',3),\n" +
            "(1,5,5,'2018-06-12',5),\n" +
            "(4,4,2,'2018-06-01',4);";
    public static final String GRADEBOOK_INSERT = "INSERT INTO gradebook (gb_number,date_of_admission,st_group,course,form_of_education,spec_id) values\n" +
            "(95754,'2014-08-12','KI-45',4,'external',5),\n" +
            "(56736,'2015-08-15','MK-33',3,'full-time',3),\n" +
            "(34564,'2014-08-22','T-41',4,'external',4),\n" +
            "(97643,'2016-08-10','FC-21',2,'full-time',1),\n" +
            "(53455,'2014-08-11','KI-43',4,'full-time',5);";
    public static final String PASSPORT_INSERT = "INSERT INTO passport (pass_serial_number,gender,date_of_birth,father_or_mother_full_name,address) values\n" +
            "(4352345,'female','1997-02-02','Kachan Bogdan Stepanovych','Shafarica,10'),\n" +
            "(4359075,'male','1996-11-13','Berezko Igor Andriyovych','Zelena,95A'),\n" +
            "(4301174,'female','1997-05-29','Klym Ivan Orestovych','Chornovola,117'),\n" +
            "(4337772,'female','1997-08-01','Protsiv Roman Mykhailovych','Vernadskogo,2'),\n" +
            "(4390235,'male','1998-03-21','Bereta Serhii Liubomyrovych','Sykhivska,53');";
    public static final String SPECIALTY_INSERT = "INSERT INTO specialty (spec_id,spec_name,spec_description) values\n" +
            "(3,'Management',NULL),\n" +
            "(5,'Computer Engineering',NULL),\n" +
            "(4,'Tourism',NULL),\n" +
            "(1,'Finance and Credit',NULL),\n" +
            "(2,'Marketing',NULL);";
    public static final String STUDENT_INSERT = "INSERT INTO student (stud_id,stud_fname,stud_lname,stud_middle_name,stud_phone_number,pass_serial_number,gb_number) values\n" +
            "(5,'Taras','Berezko','Igorovych','0974729521',4359075,34564),\n" +
            "(3,'Katya','Klym','Ivanivna','0988560021',4301174,53455),\n" +
            "(2,'Pavlo','Bereta','Serhiyovych','0639134441',4390235,56736),\n" +
            "(1,'Olya','Kachan','Bogdanivna','0973122150',4352345,97643),\n" +
            "(4,'Nadia','Protsiv','Romanivna','0980907622',4337772,95754);";
    public static final String SUBJECT_INSERT = "INSERT INTO subject (sub_id,sub_name,sub_description) values\n" +
            "(3,'Maths',NULL),\n" +
            "(2,'Physics',NULL),\n" +
            "(5,'English',NULL),\n" +
            "(4,'Chemistry',NULL),\n" +
            "(1,'History',NULL);";

    private SQLCommands(){}
}
