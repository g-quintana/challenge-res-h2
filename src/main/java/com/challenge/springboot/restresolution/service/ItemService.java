package com.challenge.springboot.restresolution.service;

import com.challenge.springboot.restresolution.entity.Item;

import java.util.List;

public interface ItemService {

  List<Item> findAll();

  Item findById(int id);

  void save(Item item);

  void deleteById(int id);

  List<Item> findByName(String itemName);

  List<Item> findByPriceRange(Double minValue, Double maxValue);

  List<Item> findByOwnerId(long ownerId);
}
