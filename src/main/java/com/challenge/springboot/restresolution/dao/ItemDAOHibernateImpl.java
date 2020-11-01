package com.challenge.springboot.restresolution.dao;

import com.challenge.springboot.restresolution.entity.Item;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import javax.persistence.EntityManager;

@Repository
public class ItemDAOHibernateImpl implements ItemDAO{

  private final EntityManager entityManager;

  @Autowired
  public ItemDAOHibernateImpl(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  public List<Item> findAll() {
    Session currentSession = entityManager.unwrap(Session.class);
    Query<Item> theQuery = currentSession.createQuery("from Item", Item.class);

    return theQuery.getResultList();
  }

  @Override
  public Item findById(int id) {
    Session currentSession = entityManager.unwrap(Session.class);

    return currentSession.get(Item.class, id);
  }

  @Override
  public void save(Item item) {
    Session currentSession = entityManager.unwrap(Session.class);
    currentSession.saveOrUpdate(item);
  }

  @Override
  public void deleteById(int id) {
    Session currentSession = entityManager.unwrap(Session.class);
    Query theQuery = currentSession.createQuery("delete from Item i where i.id =: itemId");

    theQuery.setParameter("itemId", id);

    theQuery.executeUpdate();
  }
}
