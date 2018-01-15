package com.tezis.mapper;

import com.tezis.entity.Document;
import org.apache.ibatis.annotations.*;


public interface DocumentMapper {
   String getDocument = "SELECT *FROM DOCUMENTS WHERE DOC_ID=#{docId}";
    String insertDocument = "INSERT INTO DOCUMENTS(doc_number,date,content,doc_uuid) VALUES (#{docNumber},#{date},#{content}," +
            "#{uuid,typeHandler = com.tezis.mapper.UUIDTypeHandler,jdbcType=OTHER })";
    String updateDocument = "UPDATE DOCUMENTS SET doc_number=#{docNumber}, date=#{date}, content=#{content}" +
            "where doc_id=#{docId}";
    String deleteDocument = "DELETE FROM DOCUMENTS WHERE doc_id=#{docId}";

    @Select(getDocument)
    @Results(value = {
            @Result(property = "docId", column = "doc_id"),
            @Result(property = "docNumber", column = "doc_number"),
            @Result(property = "date", column = "date"),
            @Result(property = "content", column = "content"),
            @Result(property = "uuid", column = "doc_uuid", typeHandler =UUIDTypeHandler.class)

    })
    Document getDocument(int docId);
    @Insert(insertDocument)
    @Options(useGeneratedKeys = true, keyProperty = "docId")

    void insertDocument(Document document);
    @Update(updateDocument)
    void updateDocument(Document document);
    @Delete(deleteDocument)
    void deleteDocument(int docId);

}
