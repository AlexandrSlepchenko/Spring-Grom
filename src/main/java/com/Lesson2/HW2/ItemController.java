package com.Lesson2.HW2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ItemController{

    @Autowired
    ItemService itemService;

    Item item = new Item();

    @RequestMapping(method = RequestMethod.GET, value = "/GetItem", produces = "text/plain")
    public @ResponseBody
    Item getItem() {
        return itemService.findById((long) 1);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/PostItem", produces = "text/plain")
    public @ResponseBody
    Item saveItem() {
        return itemService.save(item);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/PostItem", produces = "text/plain")
    public @ResponseBody
    Item updateItem() {
        return itemService.update(item);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/DeleteItem", produces = "text/plain")
    public @ResponseBody
    void deleteItem() {
        itemService.delete((long) 4);
    }


}
