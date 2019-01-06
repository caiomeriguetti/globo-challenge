package com.globo.challenge.dbchanges;

import com.github.mongobee.changeset.ChangeLog;
import com.github.mongobee.changeset.ChangeSet;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

@ChangeLog
public class DatabaseSeed {

    @ChangeSet(order = "001", id = "initialSeed", author = "caio")
    public void initialSeed(DB db){

        DBCollection mycollection = db.getCollection("appUser");
        DBObject doc = new BasicDBObject("username", "caio") {
        }.append("password", "$2a$10$kYzaerd66YnXChXnq8dMRO5AcR.FP0omm12ri5IKody30DOL8Sndq")
        .append("class", "AppUser");
        mycollection.insert(doc);


    }

}
