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
public class Pronunciation {
    private String audioFile;
    private List<String> dialects;
    private String phoneticNotation;
    private String phoneticSpelling;
    private List<Data> regions;
    private List<Data> registers;
}
