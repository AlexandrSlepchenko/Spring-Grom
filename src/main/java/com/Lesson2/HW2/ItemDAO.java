package com.Lesson2.HW2;

import com.Lesson3.HW.Model.File;
import com.Lesson3.HW.Model.Storage;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class ItemDAO {

    @PersistenceContext
    private EntityManager entityManager;


    public Item save(Item item) {
        entityManager.persist(item);
        return item;
    }

    public Item update(Item item) {
        entityManager.merge(item);
        return item;
    }

    public void delete(Long id) {
        entityManager.detach(findById(id));
    }

    public Item findById(Long id) {
        return entityManager.find(Item.class, id);
    }

    public List getAllItems() {
        Query query = entityManager.createQuery("SELECT i FROM Item i", Item.class);
        return query.getResultList();
    }
}
