package br.com.api.rest;

public record Item(
        Integer id,
        String name,
        String description
) {}