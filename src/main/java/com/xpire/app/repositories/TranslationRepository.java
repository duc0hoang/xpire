package com.xpire.app.repositories;

import com.xpire.app.documents.Translation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TranslationRepository extends MongoRepository<Translation, String> {
}
