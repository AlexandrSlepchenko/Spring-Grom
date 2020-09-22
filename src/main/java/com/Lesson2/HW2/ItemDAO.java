package com.Lesson2.HW2;

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
    public EntityManager entityManager;

    public Item save(Item item) {
        entityManager.persist(item);
        return item;
    }

    public Item update(Item item) {
        entityManager.merge(item);
        return item;
    }

    public void delete(Long id) {
        entityManager.remove(findById(id));
    }

    public Item findById(Long id) {
        return entityManager.find(Item.class, id);
    }

    public List getAllItems() {
        Query query = entityManager.createQuery("SELECT i FROM Item i", Item.class);
        return query.getResultList();
    }
}
