package com.xpire.app.dtos.oxford;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LexicalEntry {
    private List<Detail> compounds;
    private List<Detail> derivativeOf;
    private List<Detail> derivatives;
    private List<Entry> entries;
    private List<Data> grammaticalFeatures;
    private String language;
    private Data lexicalCategory;
    private List<Data> notes;
    private List<Detail> phrasalVerbs;
    private List<Detail> phrases;
    private List<Pronunciation> pronunciations;
    private String root;
    private String text;
    private List<VariantForm> variantForms;
}
