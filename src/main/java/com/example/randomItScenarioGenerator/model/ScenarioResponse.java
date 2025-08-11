package com.example.randomItScenarioGenerator.model;

public record ScenarioResponse(
        String technology,
        String role,
        String environment,
        String challenge,
        String incident,
        String troubleshootingStep
) {}