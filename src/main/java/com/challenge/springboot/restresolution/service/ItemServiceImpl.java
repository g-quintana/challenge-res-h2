package com.challenge.springboot.restresolution.service;

import com.challenge.springboot.restresolution.dao.ItemDAO;
import com.challenge.springboot.restresolution.entity.Item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService{

  private ItemDAO itemDAO;

  @Autowired
  public ItemServiceImpl(ItemDAO itemDAO) {
    this.itemDAO = itemDAO;
  }

  @Override
  @Transactional
  public List<Item> findAll() {
    return itemDAO.findAll();
  }

  @Override
  @Transactional
  public Item findById(int id) {
    return itemDAO.findById(id);
  }

  @Override
  @Transactional
  public void save(Item item) {
    itemDAO.save(item);
  }

  @Override
  @Transactional
  public void deleteById(int id) {
    itemDAO.deleteById(id);
  }
}
