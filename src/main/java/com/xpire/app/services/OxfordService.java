package com.xpire.app.services;

import com.xpire.app.dtos.OxfordTranslateRequest;
import com.xpire.app.dtos.oxford.OxfordTranslateDTO;

public interface OxfordService {
    OxfordTranslateDTO translate(OxfordTranslateRequest request);
}
