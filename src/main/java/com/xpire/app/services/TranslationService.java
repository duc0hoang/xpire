package com.xpire.app.services;

import com.xpire.app.dtos.OxfordTranslateRequest;
import com.xpire.app.dtos.ResponseDTO;

public interface TranslationService {
    ResponseDTO translate(OxfordTranslateRequest request);
}
