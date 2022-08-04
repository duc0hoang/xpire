package com.xpire.app.documents;

import com.xpire.app.dtos.oxford.Result;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.Instant;
import java.util.List;

@Document(collection = "translations")
@Getter
@Setter
@NoArgsConstructor
public class Translation {
    @Id
    private String id;

    @Field(name = "results")
    private List<Result> results;

    @Field(name = "count")
    private Long count;

    @CreatedDate
    private Instant createdAt = Instant.now();

    @LastModifiedDate
    private Instant updatedAt = Instant.now();

    public void updateCount(){
        count += 1;
    }
}
