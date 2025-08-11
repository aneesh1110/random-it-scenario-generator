package com.example.randomItScenarioGenerator.controller;

import com.example.randomItScenarioGenerator.model.ScenarioRequest;
import com.example.randomItScenarioGenerator.model.ScenarioResponse;
import com.example.randomItScenarioGenerator.service.ScenarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/scenario")
public class ScenarioController {

    private final ScenarioService scenarioService;

    public ScenarioController(ScenarioService scenarioService) {
        this.scenarioService = scenarioService;
    }

    @PostMapping("/generate")
    public ResponseEntity<ScenarioResponse> generateScenario(@Valid @RequestBody ScenarioRequest request) {
        ScenarioResponse response = scenarioService.generateScenario(request);
        return ResponseEntity.ok(response);
    }
}
