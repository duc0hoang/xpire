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
public class Example {
    private List<Data> collocations;
    private List<String> crossReferenceMarkers;
    private List<Data> crossReferences;
    private List<String> definitions;
    private List<Data> domains;
    private List<Data> notes;
    private List<Data> regions;
    private List<Data> registers;
    private List<String> senseIds;
    private String text;
    private List<Translation> translations;
}
