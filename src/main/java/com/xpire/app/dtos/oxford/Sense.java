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
public class Sense {
    private List<Antonym> antonyms;
    private List<Construction> constructions;
    private List<String> crossReferenceMarkers;
    private List<Data> crossReferences;
    private List<Link> datasetCrossLinks;
    private List<String> definitions;
    private List<Data> domainClasses;
    private List<Data> domains;
    private List<String> etymologies;
    private List<Example> examples;
    private String id;
    private List<Inflection> inflections;
    private List<Data> notes;
    private List<Pronunciation> pronunciations;
    private List<Data> regions;
    private List<Data> registers;
    private List<Data> semanticClasses;
    private List<String> shortDefinitions;
    private List<Detail> synonyms;
    private List<Link> thesaurusLinks;
    private List<Translation> translations;
    private List<VariantForm> variantForms;
}
