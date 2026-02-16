package com.example.tutor.service.Impl;

import com.example.tutor.model.entity.Teacher;
import com.example.tutor.service.TeacherService;
import jakarta.enterprise.context.SessionScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;


@Slf4j
@SessionScoped
public class TeacherServiceImpl implements TeacherService, Serializable {
    @PersistenceContext(unitName = "tutor")
    private EntityManager entityManager;

    @Transactional
    @Override
    public void save(Teacher attach) throws Exception {
        entityManager.merge(attach);
    }

    @Transactional
    @Override
    public void edit(Teacher attach) throws Exception {
        entityManager.merge(attach);
    }

    @Transactional
    @Override
    public void remove(Teacher attach) throws Exception {
        entityManager.remove(attach);
    }

    @Transactional
    @Override
    public void removeById(Long id) throws Exception {
        Teacher attach = entityManager.find(Teacher.class, id);
        entityManager.remove(attach);
    }

    @Transactional
    @Override
    public List<Teacher> findAll() throws Exception {
        TypedQuery<Teacher> query = entityManager.createQuery("select p from teacherEntity p", Teacher.class);
        return query.getResultList();
    }

    @Transactional
    @Override
    public Optional<Teacher> findById(Long id) throws Exception {
        return Optional.ofNullable(entityManager.find(Teacher.class, id));
    }
    @Transactional
    @Override
    public Optional<Teacher> findByName(String name)throws Exception{
        TypedQuery<Teacher> query = (TypedQuery<Teacher>) entityManager.createQuery("select s from teacherEntity  s where s.name = :name");
        query.setParameter("name", name);
        List<Teacher> result = query.getResultList();
        return Optional.ofNullable((result.isEmpty()) ? null : result.get(0));
    }

//    public Optional<Teacher> findTeacherByLesson(Long id) {
//        // نوشتن یک کوئری JPQL بر اساس id درس
//        String jpqlQuery = "SELECT t FROM Teacher t JOIN t.lessons l WHERE l.id = :lessonId";
//
//        // اجرای کوئری
//        List<Teacher> teachers = entityManager
//                .createQuery(jpqlQuery, Teacher.class)
//                .setParameter("lessonId", lessonId)
//                .getResultList();
//
//        return teachers;
//    }
//
//    public Optional<Teacher> findTeacherByLesson(Long id)throws Exception{
//        TypedQuery<Teacher> query = (TypedQuery<Teacher>) entityManager.createQuery("select s from teacherEntity  s where s.lesson = :id");
//        query.setParameter("lesson-id", id);
//        List<Teacher> result = query.getResultList();
//        return Optional.ofNullable((result.isEmpty()) ? null : result.get(0));
//    }
//@Transactional
//@Override
//    public Optional<Teacher> findTeacherByLesson(Long id) throws Exception {
//        try {
//            if (id == null) {
//                throw new IllegalArgumentException("Lesson ID cannot be null.");
//            }
//
//            // Use TypedQuery instead of Query
//            TypedQuery<Teacher> query = entityManager.createQuery("SELECT t FROM teacherEntity t WHERE t.lesson.id = :lessonId", Teacher.class);
//            query.setParameter("lessonId", id);
//
//            List<Teacher> result = query.getResultList();
//
//            return Optional.ofNullable(result.isEmpty() ? null : result.get(0));
//        } catch (Exception e) {
//            throw new RuntimeException("Error in finding teacher by lesson: " + e.getMessage(), e);
//        }
//    }
    //Optional[{"lesson":{"id":23,"name":"History"},"username":"reza","password":"reza123","role":{"role":"teacher"}}]
@Transactional
@Override
public Optional<Teacher> findTeacherByLesson(Long id) throws Exception {
    try {
        if (id == null) {
            throw new IllegalArgumentException("Lesson ID cannot be null.");
        }

        // Use TypedQuery instead of Query
        TypedQuery<Teacher> query = entityManager.createQuery(
                "SELECT new com.example.tutor.model.entity.Teacher(t.name, t.family, t.username, t.password, t.role, t.education, t.specification, t.lesson) " +
                        "FROM teacherEntity t " +
                        "WHERE t.lesson.id = :lessonId", Teacher.class);

        query.setParameter("lessonId", id);

        List<Teacher> result = query.getResultList();

        return Optional.ofNullable(result.isEmpty() ? null : result.get(0));
    } catch (Exception e) {
        throw new RuntimeException("Error in finding teacher by lesson: " + e.getMessage(), e);
    }
}



//public Optional<Teacher> findTeacherByLesson(Long id) throws Exception {
//    try {
//        if (id == null) {
//            throw new IllegalArgumentException("Lesson ID cannot be null.");
//        }
//
//        // Use createQuery without casting to TypedQuery directly
//        Query query = entityManager.createQuery("SELECT t FROM teacherEntity t WHERE t.lesson.id= :lessonId");
//
//        // Set parameter
//        query.setParameter("lessonId", id);
//
//        List<Teacher> result = query.getResultList();
//
//        return Optional.ofNullable(result.isEmpty() ? null : result.get(0));
//    } catch (Exception e) {
//        throw new RuntimeException("Error in finding teacher by lesson: " + e.getMessage(), e);
//    }
//}


//public Optional<Teacher> findTeacherByLesson(Long id) throws Exception {
//    try {
//        if (id == null) {
//            // Handle the case where id is null (invalid or not provided)
//            throw new IllegalArgumentException("Lesson ID cannot be null.");
//        }
//
//        // Use createQuery without casting to TypedQuery directly
//        Query query = entityManager.createQuery("SELECT t FROM teacherEntity t WHERE t.id = :lessonId");
//
//        // Cast to TypedQuery using the Jakarta Persistence API
//        TypedQuery<Teacher> typedQuery = (TypedQuery<Teacher>) query;
//
//        // Set parameter
//        typedQuery.setParameter("lessonId", id);
//
//        List<Teacher> result = typedQuery.getResultList();
//
//        return Optional.ofNullable(result.isEmpty() ? null : result.get(0));
//    } catch (Exception e) {
//        throw new RuntimeException("Error in finding teacher by lesson: " + e.getMessage(), e);
//    }
//}

//    public Optional<Teacher> findTeacherByLesson(Long id) throws Exception {
//        try {
//            if (id == null) {
//                throw new IllegalArgumentException("Lesson ID cannot be null.");
//            }
//
//            // Use createQuery without casting to TypedQuery directly
//            Query query = entityManager.createQuery("SELECT t FROM teacherEntity t WHERE t.lesson= :lessonId");
//
//            // Set parameter
//            query.setParameter("lessonId", id);
//
//            List<Teacher> result = query.getResultList();
//
//            return Optional.ofNullable(result.isEmpty() ? null : result.get(0));
//        } catch (Exception e) {
//            throw new RuntimeException("Error in finding teacher by lesson: " + e.getMessage(), e);
//        }
//    }


}
