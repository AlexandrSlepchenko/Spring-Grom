package com.Lesson3.HW.Controller;

import com.Lesson3.HW.Model.File;
import com.Lesson3.HW.Model.Storage;
import com.Lesson3.HW.Service.FileService;
import com.Lesson3.HW.Service.StorageService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@org.springframework.stereotype.Controller
public class FileController {

    FileService fileService;
    StorageService storageService;

    @Autowired
    public FileController(FileService fileService, StorageService storageService) {
        this.fileService = fileService;
        this.storageService = storageService;
    }

    @RequestMapping(method = RequestMethod.PUT, value = "put", produces = "text/plain")
    public @ResponseBody
    void put(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Storage storage;
        File file;
        try (BufferedReader br = req.getReader()) {
            String[] textOfNumbers = br.readLine().split(",");
            file = fileService.findById(Long.parseLong(textOfNumbers[1]));
            storage = storageService.findById(Long.parseLong(textOfNumbers[0]));
            fileService.put(storage, file);
        } catch (Exception e) {
            resp.getWriter().println(e.getMessage());
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "transferAll", produces = "text/plain")
    public @ResponseBody
    void transferAll(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Storage storageFrom;
        Storage storageTo;
        try (BufferedReader br = req.getReader()) {
            String[] textOfNumbers = br.readLine().split(",");
            storageFrom = storageService.findById(Long.parseLong(textOfNumbers[0]));
            storageTo = storageService.findById(Long.parseLong(textOfNumbers[1]));
            fileService.transferAll(storageFrom, storageTo);
        } catch (Exception e) {
            resp.getWriter().println(e.getMessage());
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/transferFile", produces = "text/plain")
    public @ResponseBody
    void transferFile(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Storage storageTo;
        try (BufferedReader br = req.getReader()) {
            String[] textOfNumbers = br.readLine().split(",");
            storageTo = storageService.findById(Long.parseLong(textOfNumbers[0]));
            fileService.transferFile(storageTo, Long.parseLong(textOfNumbers[1]));
        } catch (Exception e) {
            resp.getWriter().println(e.getMessage());
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete", produces = "text/plain")
    public @ResponseBody
    void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Storage storage;
        File file;
        try (BufferedReader br = req.getReader()) {
            String[] textOfNumbers = br.readLine().split(",");
            file = fileService.findById(Long.parseLong(textOfNumbers[1]));
            storage = storageService.findById(Long.parseLong(textOfNumbers[0]));
            fileService.delete(storage, file);
        } catch (Exception e) {
            resp.getWriter().println(e.getMessage());
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "GetFile", produces = "text/plain")
    public @ResponseBody
    void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            resp.getWriter().println(fileService.findById(Long.parseLong(req.getParameter("id"))).toString());
        } catch (Exception e) {
            resp.getWriter().println(e.getMessage());
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "PostFile", produces = "text/plain")
    public @ResponseBody
    void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        File file;
        try (BufferedReader br = req.getReader()) {
            file = mapper(br);
            fileService.save(file);
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "PutFile", produces = "text/plain")
    public @ResponseBody
    void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        File file;
        try (BufferedReader br = req.getReader()) {
            file = mapper(br);
            fileService.update(file);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "DeleteFile", produces = "text/plain")
    public @ResponseBody
    void deleteFile(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            fileService.deleteById(Long.parseLong(req.getParameter("id")));
        } catch (Exception e) {
            resp.getWriter().println(e.getMessage());
        }
    }

    public File mapper(BufferedReader br) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(br, File.class);
    }
}
