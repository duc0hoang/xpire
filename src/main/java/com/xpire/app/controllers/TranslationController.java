package com.xpire.app.controllers;

import com.xpire.app.dtos.OxfordTranslateRequest;
import com.xpire.app.dtos.ResponseDTO;
import com.xpire.app.services.TranslationService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api/translation")
@AllArgsConstructor
public class TranslationController {
    private TranslationService translationService;

    @PostMapping("/translate")
    public Mono<ResponseDTO> translate(@Validated @RequestBody OxfordTranslateRequest request) {
        return Mono.just(translationService.translate(request));
    }
}
