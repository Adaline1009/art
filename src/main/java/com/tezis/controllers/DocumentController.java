package com.tezis.controllers;

import com.tezis.entity.Document;
import com.tezis.services.DocumentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * Created by Adelya on 10.10.2017.
 */
@Api(value="docControler", description="swaggwer documentation")
@RestController
@RequestMapping("/product")
public class DocumentController {
    @Autowired
    DocumentService documentService;

    @ApiOperation(value = "Search a document with an ID",response = ResponseEntity.class)
    @RequestMapping(value="/documents/{id}",method=RequestMethod.GET)
    public ResponseEntity  getDocument(@PathVariable("id")int id) throws IOException {
        Document document =null;
        document = documentService.getDocument(id);
        if (document == null) {
            return new ResponseEntity("No document found for ID " + id, HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity(document,HttpStatus.OK);

    }
    @ApiOperation(value = "Update a document ")
    @RequestMapping(value="documents/{id}",method = RequestMethod.PUT)
    public ResponseEntity updateDocument(@RequestBody Document document) {
           documentService.updateDocument(document);
        return new ResponseEntity(HttpStatus.OK);

    }
    @ApiOperation(value = "Create a document")
    @RequestMapping(value="/documents",method = RequestMethod.POST)
    public  ResponseEntity createDocument(@RequestBody Document document) {
        documentService.createDocument(document);
        return new ResponseEntity(HttpStatus.OK);

    }

    @ApiOperation(value = "Delete a document with id ")
    @RequestMapping(value="/documents/{id}",method = RequestMethod.DELETE)
    public ResponseEntity deleteDocument(@PathVariable int id) {
       documentService.deleteDocument(id);
        return new ResponseEntity( HttpStatus.OK);

    }
    @RequestMapping(value="/kfc",method = RequestMethod.GET)
    public ResponseEntity test(){
        return new ResponseEntity("KFC so good",HttpStatus.OK);
    }
}
