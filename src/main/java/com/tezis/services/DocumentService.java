package com.tezis.services;

import com.tezis.entity.Document;
import com.tezis.mapper.DocumentMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.UUID;

/**
 * Created by Adelya on 10.10.2017.
 */
@Service
public class DocumentService implements IDocumentService {
    @Autowired
    DocumentMapper documentMapper;

    public Document getDocument(int id) throws IOException {
        return documentMapper.getDocument(id);
    }

    public void createDocument(Document document) {
        UUID uuid = UUID.randomUUID();
         document.setUuid(uuid);
        documentMapper.insertDocument(document);
        RestTemplate restTemplate = new RestTemplate();
        String loginUrl = "http://localhost:8080/app-portal/api/login?u=admin&p=admin&l=ru";
        System.out.println("here");
        HttpEntity<String> login = new HttpEntity<String>("login");
        ResponseEntity<String> responseEntity = restTemplate.exchange(loginUrl, HttpMethod.GET, login, String.class);
        String sessionId = responseEntity.getBody();
        String insertUrl = "http://localhost:8080/app-portal/api/commit?s=" + sessionId;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        JSONArray array = new JSONArray();
        JSONObject arrayObject = new JSONObject();
        arrayObject.put("id", "NEW-tezisext$Invoice-"+uuid.toString());
        arrayObject.put("number", document.getDocNumber());
        arrayObject.put("paymentConditions", document.getContent());
        array.put(arrayObject);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("commitInstances", array);
        HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), headers);
        restTemplate.exchange(insertUrl, HttpMethod.POST, entity, String.class);
    }

    public void deleteDocument(int id) {
        documentMapper.deleteDocument(id);
    }

    public void updateDocument(Document document) {
        documentMapper.updateDocument(document);
    }
}
