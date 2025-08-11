package com.example.randomItScenarioGenerator.service;

import com.example.randomItScenarioGenerator.model.ScenarioRequest;
import com.example.randomItScenarioGenerator.model.ScenarioResponse;

public interface ScenarioService {
    ScenarioResponse generateScenario(ScenarioRequest request);
}