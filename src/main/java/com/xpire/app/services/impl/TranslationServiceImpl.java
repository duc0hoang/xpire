package com.xpire.app.services.impl;

import com.xpire.app.documents.Translation;
import com.xpire.app.dtos.OxfordTranslateRequest;
import com.xpire.app.dtos.ResponseDTO;
import com.xpire.app.dtos.oxford.OxfordTranslateDTO;
import com.xpire.app.repositories.TranslationRepository;
import com.xpire.app.services.OxfordService;
import com.xpire.app.services.TranslationService;
import com.xpire.app.utils.ResponseUtils;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Service
@Transactional(rollbackFor = {Exception.class})
@AllArgsConstructor
public class TranslationServiceImpl implements TranslationService {
    private OxfordService oxfordService;
    private TranslationRepository translationRepository;

    @Override
    public ResponseDTO translate(OxfordTranslateRequest request) {
        String id = DigestUtils.md5DigestAsHex(request.toString().getBytes(StandardCharsets.UTF_8));

        Optional<Translation> optionalTranslation = translationRepository.findById(id);
        if (optionalTranslation.isPresent()) {
            return updateCount(optionalTranslation.get());
        }

        OxfordTranslateDTO oxfordTranslateDTO = oxfordService.translate(request);
        return createTranslation(oxfordTranslateDTO, id);
    }

    private ResponseDTO updateCount(Translation translation) {
        translation.updateCount();
        translationRepository.save(translation);
        return ResponseUtils.get(new OxfordTranslateDTO(translation.getResults()), HttpStatus.OK);
    }

    private ResponseDTO createTranslation(OxfordTranslateDTO oxfordTranslateDTO, String id) {
        Translation translation = new Translation();
        translation.setId(id);
        translation.setResults(oxfordTranslateDTO.getResults());
        translation.setCount(1L);
        translationRepository.save(translation);
        return ResponseUtils.get(oxfordTranslateDTO, HttpStatus.OK);
    }
}
