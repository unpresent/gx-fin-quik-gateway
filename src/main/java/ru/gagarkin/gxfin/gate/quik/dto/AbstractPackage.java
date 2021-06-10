package ru.gagarkin.gxfin.gate.quik.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AbstractPackage {
    @JsonProperty(value = "package_size")
    public int packageSize;
}
