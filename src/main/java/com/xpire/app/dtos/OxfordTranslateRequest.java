package com.xpire.app.dtos;

import com.xpire.app.utils.Language;
import com.xpire.app.validations.ValueOfEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.util.Set;

@Getter
@ToString
@Setter
@NoArgsConstructor
public class OxfordTranslateRequest {
    @ValueOfEnum(enumClass = Language.class)
    private String sourceLangTranslate;
    @ValueOfEnum(enumClass = Language.class)
    private String targetLangTranslate;
    @NotBlank
    private String wordId;
    private Boolean isStrictMatch = false;
    private Set<String> fields;
    private String grammaticalFeatures;
    private String lexicalCategory;
    private String domains;
    private String registers;
}
