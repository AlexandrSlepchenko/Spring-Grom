package com.Lesson2.HW2;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@Controller
public class ItemController {

    private ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/ParamGetItem")
    ResponseEntity<String> get(
            @RequestParam("longId") long id) {
        return new ResponseEntity<>(itemService.findById(id).toString(), HttpStatus.OK);
    }

    @DeleteMapping("/ParamDeleteItem")
    ResponseEntity<String> delete(
            @RequestParam("longId") long id) {
        itemService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/saveItem", consumes = MediaType.APPLICATION_JSON_VALUE, produces =
            MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Item> putItem(@RequestBody Item item) {
        return new ResponseEntity<>(itemService.save(item), HttpStatus.OK);
    }

    @PutMapping(value = "/updateItem", consumes = MediaType.APPLICATION_JSON_VALUE, produces =
            MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Item> updateName(@RequestBody Item item) {
        return new ResponseEntity<>(itemService.update(item), HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.GET, value = "GetItem", produces = "text/plain")
    public @ResponseBody
    void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            resp.getWriter().println(itemService.findById(Long.valueOf(req.getParameter("id"))).toString());
        } catch (Exception e) {
            resp.getWriter().println(e.getMessage());
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "PostItem", produces = "text/plain")
    public @ResponseBody
    void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Item item;
        try (BufferedReader br = req.getReader()) {
            item = mapper(br);
            itemService.save(item);
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "PutItem", produces = "text/plain")
    public @ResponseBody
    void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Item item;
        try (BufferedReader br = req.getReader()) {
            item = mapper(br);
            itemService.update(item);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "DeleteItem", produces = "text/plain")
    public @ResponseBody
    void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            itemService.delete(Long.parseLong(req.getParameter("id")));
        } catch (Exception e) {
            resp.getWriter().println(e.getMessage());
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "GetAllItems", produces = "text/plain")
    public @ResponseBody
    void doGetAll(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            resp.getWriter().println(itemService.getAllItems());
        } catch (Exception e) {
            resp.getWriter().println(e.getMessage());
        }
    }

    public Item mapper(BufferedReader br) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(br, Item.class);
    }
}
