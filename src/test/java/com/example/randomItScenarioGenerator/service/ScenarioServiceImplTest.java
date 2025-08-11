package com.example.randomItScenarioGenerator.service;

import com.example.randomItScenarioGenerator.model.ScenarioRequest;
import com.example.randomItScenarioGenerator.model.ScenarioResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScenarioServiceImplTest {

    private final ScenarioService service = new ScenarioServiceImpl();

    @Test
    void generateScenario_shouldReturnValidScenario() {
        ScenarioRequest request = new ScenarioRequest("Cloud Computing", "System Administrator", "Cloud Infrastructure");
        ScenarioResponse response = service.generateScenario(request);

        assertEquals("Cloud Computing", response.technology());
        assertEquals("System Administrator", response.role());
        assertEquals("Cloud Infrastructure", response.environment());

        assertNotNull(response.challenge());
        assertFalse(response.challenge().isBlank());

        assertNotNull(response.incident());
        assertFalse(response.incident().isBlank());

        assertNotNull(response.troubleshootingStep());
        assertFalse(response.troubleshootingStep().isBlank());
    }

    @Test
    void generateScenario_shouldThrowExceptionForInvalidInput() {
        ScenarioRequest invalidRequest = new ScenarioRequest("InvalidTech", "InvalidRole", "InvalidEnv");

        assertThrows(IllegalArgumentException.class, () -> {
            service.generateScenario(invalidRequest);
        });
    }
}
