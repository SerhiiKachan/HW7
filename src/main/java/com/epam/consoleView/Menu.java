package com.epam.consoleView;

import com.epam.model.*;
import com.epam.service.*;
import com.epam.serviceImpl.*;

import java.sql.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

class Menu {

    private static Scanner input = new Scanner(System.in);
    private Map<String, String> selects;
    private Map<String, PrintI> methods;
    private SpecialtyService specialtyService;
    private StudentService studentService;
    private GradebookService gradebookService;
    private PassportService passportService;
    private ExamService examService;
    private SubjectService subjectService;
    private Util util;

    Menu() {
        specialtyService = new SpecialtyServiceImpl();
        studentService = new StudentServiceImpl();
        gradebookService = new GradebookServiceImpl();
        passportService = new PassportServiceImpl();
        examService = new ExamServiceImpl();
        subjectService = new SubjectServiceImpl();
        util = new Util();
        selects = new LinkedHashMap<>();
        methods = new LinkedHashMap<>();
        selects.put("1", " add new student -  1");
        selects.put("2", " add new specialty - 2");
        selects.put("3", " add new subject - 3");
        selects.put("4", " add new passport - 4");
        selects.put("5", " add new gradebook - 5");
        selects.put("6", " add new exam - 6");
        selects.put("7", " find student by id - 7");
        selects.put("8", " find specialty by id - 8");
        selects.put("9", " find subject by id - 9");
        selects.put("10", " find passport by serial number - 10");
        selects.put("11", " find gradebook by gb number - 11");
        selects.put("12", " find exam by id - 12");
        selects.put("13", " find all students - 13");
        selects.put("14", " find all specialties - 14");
        selects.put("15", " find all subjects - 15");
        selects.put("16", " find all passports - 16");
        selects.put("17", " find all gradebooks - 17");
        selects.put("18", " find all exams - 18");
        selects.put("19", " update student - 19");
        selects.put("20", " update specialty - 20");
        selects.put("21", " update subject - 21");
        selects.put("22", " update passport - 22");
        selects.put("23", " update gradebook - 23");
        selects.put("24", " update exam - 24");
        selects.put("25", " delete student - 25");
        selects.put("26", " delete specialty - 26");
        selects.put("27", " delete subject - 27");
        selects.put("28", " delete passport - 28");
        selects.put("29", " delete gradebook - 29");
        selects.put("30", " delete exam - 30");
        selects.put("31", " delete specialty and transfer student to another specialty - 31");
        selects.put("32", " get all meta data about database - 32");
        selects.put("Q", " Q - exit");

        methods.put("1", this::addNewStudent);
        methods.put("2", this::addNewSpecialty);
        methods.put("3", this::addNewSubject);
        methods.put("4", this::addNewPassport);
        methods.put("5", this::addNewGradebook);
        methods.put("6", this::addNewExam);
        methods.put("7", this::findStudentById);
        methods.put("8", this::findSpecialtyById);
        methods.put("9", this::findSubjectById);
        methods.put("10", this::findPassportBySerialNumber);
        methods.put("11", this::findGradebookByGBNumber);
        methods.put("12", this::findExamById);
        methods.put("13", this::findAllStudents);
        methods.put("14", this::findAllSpecialties);
        methods.put("15", this::findAllSubjects);
        methods.put("16", this::findAllPassports);
        methods.put("17", this::findAllGradebooks);
        methods.put("18", this::findAllExams);
        methods.put("19", this::updateStudent);
        methods.put("20", this::updateSpecialty);
        methods.put("21", this::updateSubject);
        methods.put("22", this::updatePassport);
        methods.put("23", this::updateGradebook);
        methods.put("24", this::updateExam);
        methods.put("25", this::deleteStudent);
        methods.put("26", this::deleteSpecialty);
        methods.put("27", this::deleteSubject);
        methods.put("28", this::deletePassport);
        methods.put("29", this::deleteGradebook);
        methods.put("30", this::deleteExam);
        methods.put("31", this::delectSpecialtyAndTransferStudentsToAnother);
        methods.put("32", this::getMetaDataOfDataBase);

    }

    private void addNewStudent() {
        System.out.println("Ensure that you have added passport and gradebook for this student!");
        System.out.println("Enter id:");
        int id = input.nextInt();
        System.out.println("Enter name:");
        String name = input.next();
        System.out.println("Enter surname:");
        String surname = input.next();
        System.out.println("Enter middle name:");
        String middleName = input.next();
        System.out.println("Enter phone number:");
        String phone = input.next();
        System.out.println("Enter passport serial number:");
        int serialNumber = input.nextInt();
        System.out.println("Enter gradebook number:");
        int gbNumber = input.nextInt();
        if (middleName.equalsIgnoreCase("null"))
            middleName = null;
        if (phone.equalsIgnoreCase("null"))
            phone = null;
        Student student = new Student(id, name, surname, middleName, phone, serialNumber, gbNumber);
        studentService.createStudent(student);
    }

    private void addNewSpecialty() {
        System.out.println("enter id:");
        int id = input.nextInt();
        System.out.println("enter name:");
        String name = input.next();
        System.out.println("enter description:");
        String description = input.next();
        if (description.equalsIgnoreCase("null"))
            description = null;
        Specialty specialty = new Specialty(id, name, description);
        specialtyService.createSpecialty(specialty);

    }

    private void addNewPassport() {
        System.out.println("Enter serial number:");
        int id = input.nextInt();
        System.out.println("Enter gender:");
        String name = input.next();
        System.out.println("Enter dob:");
        Date dob = Date.valueOf(input.next());
        System.out.println("Enter parent's full name:");
        String parentFullName = input.next();
        System.out.println("Enter address:");
        String address = input.next();
        Passport passport = new Passport(id, name, dob, parentFullName, address);
        passportService.createPassport(passport);
    }

    private void addNewGradebook() {
        System.out.println("Enter gb number:");
        int gbNumber = input.nextInt();
        System.out.println("Enter date of admission:");
        Date doa = Date.valueOf(input.next());
        System.out.println("Enter group:");
        String group = input.next();
        System.out.println("Enter course:");
        int course = input.nextInt();
        System.out.println("Enter form of education:");
        String education = input.next();
        System.out.println("Enter specialty id:");
        int specialtyId = input.nextInt();
        Gradebook gradebook = new Gradebook(gbNumber, doa, group, course, education, specialtyId);
        gradebookService.createGradebook(gradebook);
    }

    private void addNewSubject() {
        System.out.println("enter id:");
        int id = input.nextInt();
        System.out.println("enter name:");
        String name = input.next();
        System.out.println("enter description:");
        String description = input.next();
        if (description.equalsIgnoreCase("null"))
            description = null;
        Subject subject = new Subject(id, name, description);
        subjectService.createSubject(subject);
    }

    private void addNewExam() {
        System.out.println("Enter id:");
        int id = input.nextInt();
        System.out.println("Enter student id:");
        int studentId = input.nextInt();
        System.out.println("Enter subject id:");
        int subjectId = input.nextInt();
        System.out.println("Enter date of exam:");
        Date doe = Date.valueOf(input.next());
        System.out.println("Enter mark:");
        int mark = input.nextInt();
        Exam exam = new Exam(id, studentId, subjectId, doe, mark);
        examService.createExam(exam);
    }

    private void findStudentById() {
        System.out.println("Enter id of student:");
        int id = input.nextInt();
        Student student = studentService.getStudentById(id);
        if (student == null) {
            System.out.println("student with such id doesn`t exist:");
        } else {
            System.out.println(student);
        }
    }

    private void findSpecialtyById() {
        System.out.println("Enter id of specialty:");
        int id = input.nextInt();
        Specialty specialty = specialtyService.getSpecialtyById(id);
        if (specialty == null) {
            System.out.println("specialty with such id doesn`t exist:");
        } else {
            System.out.println(specialty);
        }
    }

    private void findSubjectById() {
        System.out.println("Enter id of subject:");
        int id = input.nextInt();
        Subject subject = subjectService.getSubjectById(id);
        if (subject == null) {
            System.out.println("subject with such id doesn`t exist:");
        } else {
            System.out.println(subject);
        }
    }

    private void findPassportBySerialNumber() {
        System.out.println("Enter serial number of passport:");
        int serialNumber = input.nextInt();
        Passport passport = passportService.getPassportBySerialNumber(serialNumber);
        if (passport == null) {
            System.out.println("passport with such serial number doesn`t exist:");
        } else {
            System.out.println(passport);
        }
    }

    private void findGradebookByGBNumber() {
        System.out.println("Enter gb number of gradebook:");
        int gbNumber = input.nextInt();
        Gradebook gradebook = gradebookService.getGradebookByGBNumber(gbNumber);
        if (gradebook == null) {
            System.out.println("gradebook with such gb number doesn`t exist:");
        } else {
            System.out.println(gradebook);
        }
    }

    private void findExamById() {
        System.out.println("Enter id of exam:");
        int id = input.nextInt();
        Exam exam = examService.getExamById(id);
        if (exam == null) {
            System.out.println("exam with such id doesn`t exist:");
        } else {
            System.out.println(exam);
        }
    }

    private void findAllStudents() {
        studentService.getAllStudents().forEach(System.out::println);
    }

    private void findAllSpecialties() {
        specialtyService.getAllSpecialties().forEach(System.out::println);
    }

    private void findAllSubjects() {
        subjectService.getAllSubjects().forEach(System.out::println);
    }

    private void findAllPassports() {
        passportService.getAllPassports().forEach(System.out::println);
    }

    private void findAllGradebooks() {
        gradebookService.getAllGradebooks().forEach(System.out::println);
    }

    private void findAllExams() {
        examService.getAllExams().forEach(System.out::println);
    }

    private void updateStudent() {
        System.out.println("Enter id of student you want to update:");
        int id = input.nextInt();
        studentService.updateStudent(studentService.getStudentById(id));
    }

    private void updateSpecialty() {
        System.out.println("Enter id of specialty you want to update:");
        int id = input.nextInt();
        specialtyService.updateSpecialty(specialtyService.getSpecialtyById(id));
    }

    private void updateSubject() {
        System.out.println("Enter id of subject you want to update:");
        int id = input.nextInt();
        subjectService.updateSubject(subjectService.getSubjectById(id));
    }

    private void updatePassport() {
        System.out.println("Enter serial number of passport you want to update:");
        int serialNumber = input.nextInt();
        passportService.updatePassport(passportService.getPassportBySerialNumber(serialNumber));
    }

    private void updateGradebook() {
        System.out.println("Enter gb number of gradebook you want to update:");
        int gbNumber = input.nextInt();
        gradebookService.updateGradebook(gradebookService.getGradebookByGBNumber(gbNumber));
    }

    private void updateExam() {
        System.out.println("Enter id of exam you want to update:");
        int id = input.nextInt();
        examService.updateExam(examService.getExamById(id));
    }

    private void deleteStudent() {
        System.out.println("Enter id of student you want to delete:");
        int id = input.nextInt();
        studentService.removeStudent(studentService.getStudentById(id));
    }

    private void deleteSpecialty() {
        System.out.println("Enter id of specialty you want to delete:");
        int id = input.nextInt();
        specialtyService.removeSpecialty(specialtyService.getSpecialtyById(id));
    }

    private void deleteSubject() {
        System.out.println("Enter id of subject you want to delete:");
        int id = input.nextInt();
        subjectService.removeSubject(subjectService.getSubjectById(id));
    }

    private void deletePassport() {
        System.out.println("Enter serial number of passport you want to delete:");
        int serialNumber = input.nextInt();
        passportService.removePassport(passportService.getPassportBySerialNumber(serialNumber));
    }

    private void deleteGradebook() {
        System.out.println("Enter gb number of gradebook you want to delete:");
        int gbNumber = input.nextInt();
        gradebookService.removeGradebook(gradebookService.getGradebookByGBNumber(gbNumber));
    }

    private void deleteExam() {
        System.out.println("Enter id of exam you want to delete:");
        int id = input.nextInt();
        examService.removeExam(examService.getExamById(id));
    }

    private void delectSpecialtyAndTransferStudentsToAnother() {
        System.out.println("Enter id specialty that should be deleted:");
        int idOld = input.nextInt();
        System.out.println("Enter new specialty where students should be transferred to:");
        int idNew = input.nextInt();
        specialtyService.deleteSpecialtyAndReplaceStudentsToAnotherSpecialty(idNew, idOld);
    }

    private void getMetaDataOfDataBase() {
        util.getAllMetaData();
    }

    private void printMenu() {
        System.out.println("MENU:");
        for (String string : selects.values()) {
            System.out.println(string);
        }
    }

    void show() {
        String keySelect;
        do {
            printMenu();
            System.out.println("Select option:");
            keySelect = input.next();
            try {
                if (!keySelect.equalsIgnoreCase("Q"))
                    methods.get(keySelect).print();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (!keySelect.equalsIgnoreCase("Q"));
    }

}
