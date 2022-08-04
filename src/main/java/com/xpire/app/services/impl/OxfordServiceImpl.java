package com.xpire.app.services.impl;

import com.xpire.app.dtos.OxfordTranslateRequest;
import com.xpire.app.dtos.oxford.OxfordTranslateDTO;
import com.xpire.app.services.OxfordService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

@Service
public class OxfordServiceImpl implements OxfordService {
    @Value("${oxford.host}")
    private String host;
    @Value("${oxford.app_id}")
    private String appId;
    @Value("${oxford.app_key}")
    private String appKey;

    @Override
    public OxfordTranslateDTO translate(OxfordTranslateRequest request) {
        String url = host + "/api/v2/translations/{sourceLangTranslate}/{targetLangTranslate}/{wordId}";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = createHeader();
        HttpEntity<?> entity = new HttpEntity<>(headers);
        Map<String, Object> params = new HashMap<>();
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("strictMatch", "{strictMatch}");
        bindingParams(params, request, uriComponentsBuilder);
        String urlTemplate = uriComponentsBuilder.encode()
                .toUriString();

        HttpEntity<OxfordTranslateDTO> response = restTemplate.exchange(
                urlTemplate,
                HttpMethod.GET,
                entity,
                OxfordTranslateDTO.class,
                params
        );
        return response.getBody();
    }

    private HttpHeaders createHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        headers.set("app_id", appId);
        headers.set("app_key", appKey);
        return headers;
    }

    private void bindingParams(Map<String, Object> params,
                               OxfordTranslateRequest request,
                               UriComponentsBuilder uriComponentsBuilder) {
        params.put("sourceLangTranslate", request.getSourceLangTranslate().toLowerCase());
        params.put("targetLangTranslate", request.getTargetLangTranslate().toLowerCase());
        params.put("wordId", request.getWordId().toLowerCase());
        params.put("strictMatch", request.getIsStrictMatch());

        if (request.getFields() != null) {
            uriComponentsBuilder.queryParam("fields", "{fields}");
            params.put("fields", String.join(",", request.getFields()));
        }
        if (request.getGrammaticalFeatures() != null) {
            uriComponentsBuilder.queryParam("grammaticalFeatures", "{grammaticalFeatures}");
            params.put("grammaticalFeatures", request.getGrammaticalFeatures());
        }
        if (request.getLexicalCategory() != null) {
            uriComponentsBuilder.queryParam("lexicalCategory", "{lexicalCategory}");
            params.put("lexicalCategory", request.getLexicalCategory());
        }
        if (request.getDomains() != null) {
            uriComponentsBuilder.queryParam("domains", "{domains}");
            params.put("domains", request.getDomains());
        }
        if (request.getRegisters() != null) {
            uriComponentsBuilder.queryParam("registers", "{registers}");
            params.put("registers", request.getRegisters());
        }
    }
}
