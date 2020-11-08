package it.thomasiommi.mongocktest.mongock;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;


@ChangeLog(order = "001")
public class MongockChangelog1 {

    private final String PERSON_COLLECTION_NAME = "person";

    @ChangeSet(order = "001", id = "addAge", author = "Thomas Iommi")
    public void addAge(MongoDatabase db) {
        MongoCollection<Document> personCollection = db.getCollection(PERSON_COLLECTION_NAME);
        Document ageField = new Document("age", -1);
        personCollection.updateMany(new Document(), new Document("$set", ageField));
    }



}
