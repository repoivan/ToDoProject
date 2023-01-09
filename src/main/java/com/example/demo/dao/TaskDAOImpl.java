package com.example.demo.dao;

import com.example.demo.model.Task;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class TaskDAOImpl  implements TaskDAO{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void createTaskTable() {
//        final String sql = "CREATE TABLE IF NOT EXISTS tasks (" +
//                "id BIGINT (10) AUTO_INCREMENT,\n" +
//                "name varchar(45) NOT NULL" +
//                "PRIMARY KEY (id)\n" +
//                ")";
//        entityManager.createQuery(sql);
    }

    @Override
    public List<Task> taskList() {
        return entityManager.createQuery("select task from Task task", Task.class).getResultList();
    }

    @Override
    public Task taskByName(int id) {
        return null;
    }

    @Override
    public void save(Task task) {
        entityManager.persist(task);
    }

    @Override
    public void update(Task task) {

    }

    @Override
    public void delete(int id) {

    }
}
