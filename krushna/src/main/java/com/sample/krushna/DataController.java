package com.sample.krushna;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
	
	@RestController
	@RequestMapping("/api/data")
	public class DataController {

	    private List<DataItem> data = new ArrayList<>();
	    private int nextId = 1;

	    // GET method to retrieve data
	    @GetMapping
	    public List<DataItem> getData() {
	        return data;
	    }

	    // POST method to add data
	    @PostMapping
	    public DataItem addData(@RequestBody DataItem newItem) {
	        newItem.setId(nextId++);
	        data.add(newItem);
	        return newItem;
	    }

	    // DELETE method to remove data by ID
	    @DeleteMapping("/{id}")
	    public DataItem deleteData(@PathVariable int id) {
	        DataItem itemToRemove = null;
	        for (DataItem item : data) {
	            if (item.getId() == id) {
	                itemToRemove = item;
	                break;
	            }
	        }
	        if (itemToRemove != null) {
	            data.remove(itemToRemove);
	            return itemToRemove;
	        } else {
	            return null;
	        }
	    }
	}
