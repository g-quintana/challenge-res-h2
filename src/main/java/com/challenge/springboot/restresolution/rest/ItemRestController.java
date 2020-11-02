package com.challenge.springboot.restresolution.rest;

import com.challenge.springboot.restresolution.entity.Item;
import com.challenge.springboot.restresolution.service.ItemService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;

@ApiOperation(value = "/marketplace/v1/items", tags = "Items Controller")
@RestController
@RequestMapping("/items")
public class ItemRestController {

  private final ItemService itemService;

  @Autowired
  public ItemRestController(ItemService itemService) {
    this.itemService = itemService;
  }

  @ApiOperation(value = "Retrieves all Items", response = Iterable.class)
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "SUCCESS", response = Item.class),
      @ApiResponse(code = 401, message = "UNAUTHORIZED!", response = ErrorResponse.class),
      @ApiResponse(code = 403, message = "FORBIDDEN!", response = ErrorResponse.class),
      @ApiResponse(code = 404, message = "NOT FOUND", response = ErrorResponse.class)
  })
  @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Item> findAll() {
    return itemService.findAll();
  }

  @ApiOperation(value = "Retrieves Item by Id", response = Item.class)
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "SUCCESS", response = Item.class),
      @ApiResponse(code = 401, message = "UNAUTHORIZED!", response = ErrorResponse.class),
      @ApiResponse(code = 403, message = "FORBIDDEN!", response = ErrorResponse.class),
      @ApiResponse(code = 404, message = "NOT FOUND", response = ErrorResponse.class)
  })
  @GetMapping(value = "/{itemId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Item findById(@PathVariable int itemId) {
    Item item = itemService.findById(itemId);
    if(item == null) {
      throw new RuntimeException("Item id not found - " + itemId);
    }
    return item;
  }

  @ApiOperation(value = "Insert Item", response = Item.class)
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "SUCCESS", response = Item.class),
      @ApiResponse(code = 401, message = "UNAUTHORIZED!", response = ErrorResponse.class),
      @ApiResponse(code = 403, message = "FORBIDDEN!", response = ErrorResponse.class),
      @ApiResponse(code = 404, message = "NOT FOUND", response = ErrorResponse.class)
  })
  @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
  public Item addItem(@RequestBody Item item) {
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    item.setId(0);
    item.setCreationDate(timestamp);
    item.setModificationDate(timestamp);
    itemService.save(item);
    return item;
  }

  @ApiOperation(value = "Updates Item", response = Item.class)
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "SUCCESS", response = Item.class),
      @ApiResponse(code = 401, message = "UNAUTHORIZED!", response = ErrorResponse.class),
      @ApiResponse(code = 403, message = "FORBIDDEN!", response = ErrorResponse.class),
      @ApiResponse(code = 404, message = "NOT FOUND", response = ErrorResponse.class)
  })
  @PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
  public Item updateItem(@RequestBody Item item) {
    itemService.save(item);
    return item;
  }

  @ApiOperation(value = "Deletes Item by Id", response = String.class)
  @DeleteMapping(value = "/{itemId}", produces = MediaType.TEXT_PLAIN_VALUE)
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "SUCCESS", response = String.class),
      @ApiResponse(code = 401, message = "UNAUTHORIZED!", response = ErrorResponse.class),
      @ApiResponse(code = 403, message = "FORBIDDEN!", response = ErrorResponse.class),
      @ApiResponse(code = 404, message = "NOT FOUND", response = ErrorResponse.class)
  })
  public String deleteItem(@PathVariable int itemId) {
    Item tempItem = itemService.findById(itemId);
    if(tempItem == null) {
      throw new RuntimeException("Item id not found - " + itemId);
    }
    itemService.deleteById(itemId);
    return "Deleted item id - " + itemId;
  }

  @ApiOperation(value = "Get Items like name", response = Iterable.class)
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "SUCCESS", response = Item.class),
      @ApiResponse(code = 401, message = "UNAUTHORIZED!", response = ErrorResponse.class),
      @ApiResponse(code = 403, message = "FORBIDDEN!", response = ErrorResponse.class),
      @ApiResponse(code = 404, message = "NOT FOUND", response = ErrorResponse.class)
  })
  @GetMapping(value = "/byname/{itemName}", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Item> findLikeName(@PathVariable String itemName) {
    return itemService.findByName(itemName);
  }

  @ApiOperation(value = "Get Items by price range", response = Iterable.class)
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "SUCCESS", response = Item.class),
      @ApiResponse(code = 401, message = "UNAUTHORIZED!", response = ErrorResponse.class),
      @ApiResponse(code = 403, message = "FORBIDDEN!", response = ErrorResponse.class),
      @ApiResponse(code = 404, message = "NOT FOUND", response = ErrorResponse.class)
  })
  @GetMapping(value = "/bypricerange", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Item> findByPriceRange(@RequestParam(required = false) Double minValue, @RequestParam(required = false) Double maxValue) {
    return itemService.findByPriceRange(minValue, maxValue);
  }

  @ApiOperation(value = "Get Items by Owner Id", response = Iterable.class)
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "SUCCESS", response = Item.class),
      @ApiResponse(code = 401, message = "UNAUTHORIZED!", response = ErrorResponse.class),
      @ApiResponse(code = 403, message = "FORBIDDEN!", response = ErrorResponse.class),
      @ApiResponse(code = 404, message = "NOT FOUND", response = ErrorResponse.class)
  })
  @GetMapping(value = "/byownerid/{ownerId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Item> findByOwnerId(@PathVariable long ownerId) {
    return itemService.findByOwnerId(ownerId);
  }
}
