package com.challenge.springboot.restresolution.service;

import com.challenge.springboot.restresolution.dao.ItemDAO;
import com.challenge.springboot.restresolution.entity.Item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService{

  private final ItemDAO itemDAO;

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

  @Override
  @Transactional
  public List<Item> findByName(String itemName) {
    return itemDAO.findByName(itemName);
  }

  @Override
  @Transactional
  public List<Item> findByPriceRange(Double minValue, Double maxValue) {
    return itemDAO.findByPriceRange(minValue, maxValue);
  }

  @Override
  @Transactional
  public List<Item> findByOwnerId(long ownerId) {
    return itemDAO.findByOwnerId(ownerId);
  }
}
