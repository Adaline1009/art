package com.tezis.services;

import com.tezis.entity.Document;

import java.io.IOException;

/**
 * Created by Adelya on 10.10.2017.
 */
public interface IDocumentService {
    Document getDocument(int id) throws IOException;

    void createDocument(Document document);

    void deleteDocument(int id);

    void updateDocument(Document document);

}
