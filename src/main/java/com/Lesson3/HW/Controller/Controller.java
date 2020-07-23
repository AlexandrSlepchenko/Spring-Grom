package com.Lesson3.HW.Controller;

import com.Lesson3.HW.Model.File;
import com.Lesson3.HW.Service.FileService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class Controller {

    FileService fileService;

    @Autowired
    public Controller(FileService fileService) {
        this.fileService = fileService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/putFile", produces = "text/plain")
    public @ResponseBody
    File put() {
        return fileService.put(null, null);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/transferAllFiles", produces = "text/plain")
    public @ResponseBody
    List transferAll() {
        return fileService.transferAll(null, null);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/transferFile", produces = "text/plain")
    public @ResponseBody
    File transferFile() {
        return fileService.transferFile(null, 0);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteFile", produces = "text/plain")
    public @ResponseBody
    void deleteFile() {
        fileService.delete(null, null);
    }



//    @RequestMapping(method = RequestMethod.GET, value = "GetItem", produces = "text/plain")
//    public @ResponseBody
//    void doGet (HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        try {
//            resp.getWriter().println(itemService.findById(Long.valueOf(req.getParameter("id"))).toString());
//        }catch (Exception e){
//            resp.getWriter().println(e.getMessage());
//        }
//    }
//
//    @RequestMapping(method = RequestMethod.POST, value = "PostItem", produces = "text/plain")
//    public @ResponseBody
//    void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        Item item;
//        try (BufferedReader br = req.getReader()) {
//            item = mapper(br);
//            itemService.save(item);
//        }
//    }
//
//    @RequestMapping(method = RequestMethod.PUT, value = "PutItem", produces = "text/plain")
//    public @ResponseBody
//    void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        Item item;
//        try (BufferedReader br = req.getReader()) {
//            item = mapper(br);
//            itemService.update(item);
//        }
//    }
//
    @RequestMapping(method = RequestMethod.DELETE, value = "DeleteItem", produces = "text/plain")
    public @ResponseBody
    void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            fileService.delete(null, null);
        } catch (Exception e) {
            resp.getWriter().println(e.getMessage());
        }
    }

    public File mapper(BufferedReader br) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(br, File.class);
    }
}
