package com.dyma.naissanceapi.exceptions;

public record ErrorEntity (
        String code,
        String message
){ }
