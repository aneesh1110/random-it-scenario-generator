package com.example.randomItScenarioGenerator.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record ScenarioRequest(@NotBlank(message = "Technology must not be blank")
    @Pattern(regexp = "Cloud Computing|Cybersecurity|DevOps|AI/ML", message = "Invalid technology")
    String technology,

    @NotBlank(message = "Role must not be blank")
    @Pattern(regexp = "System Administrator|Software Engineer|Security Analyst|Data Scientist", message = "Invalid role")
    String role,

    @NotBlank(message = "Environment must not be blank")
    @Pattern(regexp = "Enterprise Network|Cloud Infrastructure|On-Prem Data Center|Hybrid Cloud", message = "Invalid environment")
    String environment) {}