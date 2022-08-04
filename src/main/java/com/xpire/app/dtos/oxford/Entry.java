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
public class Entry {
    private List<String> crossReferenceMarkers;
    private List<Data> crossReferences;
    private List<String> etymologies;
    private List<Data> grammaticalFeatures;
    private String homographNumber;
    private List<Inflection> inflections;
    private List<Data> notes;
    private List<Pronunciation> pronunciations;
    private List<Sense> senses;
    private List<VariantForm> variantForms;
}
