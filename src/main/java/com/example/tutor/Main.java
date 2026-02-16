//package com.example.tutor;
//
//import com.example.tutor.model.enums.Grade;
//import com.example.tutor.service.CelassService;
//import com.example.tutor.service.Impl.CelassServiceImpl;
//import com.example.tutor.service.Impl.LessonServiceImpl;
//import com.example.tutor.service.Impl.ManagerServiceImpl;
//import com.example.tutor.service.Impl.RoleServiceImpl;
//import com.example.tutor.service.Impl.StudentServiceImpl;
//import com.example.tutor.service.Impl.TeacherServiceImpl;
//import com.example.tutor.service.LessonService;
//import com.example.tutor.service.ManagerService;
//import com.example.tutor.service.RoleService;
//import com.example.tutor.service.StudentService;
//import com.example.tutor.service.TeacherService;
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//public class Main {
//
//    public static void main(String[] args) throws Exception {
//
//
//        Role role1= Role.builder().role("manager").build();
//        Role role2= Role.builder().role("student").build();
//        Role role3= Role.builder().role("teacher").build();
//
//        RoleService roleService = new RoleServiceImpl();
//        roleService.save(role1);
//        RoleService roleService2 = new RoleServiceImpl();
//        roleService2.save(role2);
//        RoleService roleService3 = new RoleServiceImpl();
//        roleService3.save(role3);
//
//        Lesson lesson1 = Lesson.builder().
//                name("math")
//        .build();
//        Lesson lesson2 = Lesson.builder().
//                name("programming")
//                .build();
//
//
//        LessonService lessonService =new LessonServiceImpl();
//        lessonService.save(lesson1);
//        LessonService lessonService2 =new LessonServiceImpl();
//        lessonService2.save(lesson2);
//
//        Celass clss1 = Celass.builder()
//                .lesson(lesson1)
//                .build();
//
//        CelassService celassService=new CelassServiceImpl();
//        celassService.save(clss1);
//
//        Manager manager = Manager.builder()
//                .username("fatemehkhalvandi")
//                .name("fatemeh")
//                .family("khalvandi")
//                .password("fatemeh123")
//                .role(role1)
//                .build();
//
//        ManagerService managerService=new ManagerServiceImpl();
//        managerService.save(manager);
//
//        Student student1= Student.builder()
//                .username("azadehazadi")
//                .name("azadeh")
//                .family("azadi")
//                .password("azi123")
//                .grade(Grade.primary)
//                .celass(clss1)
//                .role(role2)
//                .build();
//
//        StudentService studentService = new StudentServiceImpl();
//
//        studentService.save(student1);
//        log.info("student saved");
//        Student student2= Student.builder()
//                .username("شائشیazadi")
//                .name("azadeh")
//                .family("azadi")
//                .password("azi123")
//                .grade(Grade.primary)
//                .celass(clss1)
//                .role(role2)
//                .build();
//
//        StudentService studentService2 = new StudentServiceImpl();
//        studentService2.save(student2);
//
//        Teacher teacher1= Teacher.builder()
//                .username("aliAlipour")
//                .name("ali")
//                .family("alipour")
//                .password("ali123")
//                .role(role3)
//                .education("PHD")
//                .specification("کسب دوره ReactJS از مرکز آموزش های الکترونیکی دانشگاه صنعت شریف")
//                .id(2).build();
//
//        TeacherService teacherService = new TeacherServiceImpl();
//        teacherService.save(teacher1);
//
//
////        System.out.println(UserService.getService().save(teacher1));
//
////        System.out.println(UserService.getService().save(student1));
//
//
//
//////
////        User user =
////                User
////                        .builder()
////                        .name("ahmad123")
////                        .family("messbah")
////                        .username("ahmadddd")
////                        .password("ahmad123")
////                        .role(role1)
////                        .build();
////        System.out.println(UserService.getService().save(user));
////
////        Manager admin = Manager.builder()
////                .username("fatemehkhalvandi")
////                .name("fatemeh")
////                .family("khalvandi")
////                .password("fatemeh123")
////                .role(role1)
////                .build();
////        System.out.println(UserService.getService().save(admin));
////
////        Teacher teacher1= Teacher.builder()
////                .username("aliAlipour")
////                .name("ali")
////                .family("alipour")
////                .password("ali123")
////                .role(role3)
////                .education("PHD")
////                .specification("کسب دوره ReactJS از مرکز آموزش های الکترونیکی دانشگاه صنعت شریف")
////                .id(2).build();
////        System.out.println(UserService.getService().save(teacher1));
////
////        Teacher teacher2= Teacher.builder()
////                .username("rezarezaee")
////                .name("reza")
////                .family("rezaee")
////                .password("reza123")
////                .role(role3)
////                .education("Master of computer")
////                .specification("کسب دوره ReactJS از مرکز آموزش های الکترونیکی دانشگاه صنعت شریف")
////                .id(3).build();
////        System.out.println(UserService.getService().save(teacher2));
////
////
////        Student student1= Student.builder()
////                .username("azadehazadi")
////                .name("azadeh")
////                .family("azadi")
////                .password("azi123")
////                .grade(Grade.primary)
////                .role(role2)
////                .id(4).build();
////        System.out.println(UserService.getService().save(student1));
////
////        Student student2= Student.builder()
////                .username("ahmadazadi")
////                .name("ahmad")
////                .family("ahmadi")
////                .password("ahmad123")
////                .grade(Grade.primary)
////                .role(role2)
////                .id(5).build();
////        System.out.println(UserService.getService().save(student2));
////
////
////        Lesson lesson1= Lesson.builder()
////                .name("math")
////                .build();
////        Lesson lesson2= Lesson.builder()
////                .name("english")
////                .build();
////        Lesson lesson3= Lesson.builder()
////                .name("programming")
////                .build();
////        System.out.println(LessonService.getService().save(lesson1));
////        System.out.println(LessonService.getService().save(lesson2));
////        System.out.println(LessonService.getService().save(lesson3));
//////        System.out.println(UserService.getService().findAll());
////        System.out.println(UserService.getService().findByUsername("ahmadazadi"));
////
////        System.out.println(UserService.getService().findByUsername("ahmada"));
//
////        Celass clss1 = Celass.builder()
////                .lesson(lesson1)
////                .teacher(teacher1)
//////                .students(students)
////                .build();
////        clss1.addStudent(student1);
////        clss1.addStudent(student2);
////        System.out.println(ClassService.getService().save(clss1));
//
////        User user2 =
////                User
////                        .builder()
////                        .name("ali")
////                        .family("alipour")
////                        .username("ali")
////                        .password("ali123")
////                        .role(UserRole.Customer)
////                        .build();
////
////        System.out.println(UserService.getService().save(user2));
////        System.out.println(UserService.getService().findAll());
//
////        System.out.println(UserService.getService().findByUsername("ali"));
////        System.out.println(UserService.getService().findByUsername("reza"));
////        System.out.println(UserService.getService().findByUsernameAndPassword("ali","ali123"));
////        System.out.println(UserService.getService().findByUsernameAndPassword("ali","ali1234"));
//    }
//
//
//
//    }
//
