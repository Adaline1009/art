package com.tezis.entity;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Adelya on 10.10.2017.
 */
public class Document {
    private int docId;
    private int docNumber;
    private Date date;
    private String content;
   private UUID uuid;

    public Document() {

    }

    public int getDocId() {
        return docId;
    }

    public void setDocId(int docId) {
        this.docId = docId;
    }

    public int getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(int docNumber) {
        this.docNumber = docNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}
