package com.example.randomItScenarioGenerator.service;

import com.example.randomItScenarioGenerator.model.ScenarioRequest;
import com.example.randomItScenarioGenerator.model.ScenarioResponse;

import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class ScenarioServiceImpl implements ScenarioService {

    private static final Map<String, List<String>> CHALLENGES = Map.of(
        "Cloud Computing", List.of(
            "Managing cloud resource allocation.",
            "Ensuring cloud service availability.",
            "Handling cloud security compliance.",
            "Optimizing cloud costs without sacrificing performance.",
            "Managing multi-cloud environment complexity.",
            "Automating cloud infrastructure provisioning."
        ),
        "Cybersecurity", List.of(
            "Detecting unauthorized access.",
            "Preventing phishing attacks.",
            "Responding to malware infections.",
            "Implementing zero-trust security models.",
            "Conducting regular vulnerability assessments.",
            "Managing insider threat detection."
        ),
        "DevOps", List.of(
            "Automating deployment pipelines.",
            "Monitoring continuous integration failures.",
            "Scaling container orchestration.",
            "Ensuring rollback capabilities on failed deployments.",
            "Integrating security into CI/CD workflows.",
            "Managing infrastructure as code version control."
        ),
        "AI/ML", List.of(
            "Automating deployment pipelines.",
            "Monitoring continuous integration failures.",
            "Scaling container orchestration.",
            "Handling model drift in production environments.",
            "Ensuring data quality for training datasets.",
            "Optimizing inference latency for real-time applications."
        )
    );

    private static final Map<String, List<String>> INCIDENTS = Map.of(
        "System Administrator", List.of(
            "Server outage due to network misconfiguration.",
            "Backup failures during scheduled jobs.",
            "Unexpected permission changes.",
            "DNS resolution failures causing service disruptions.",
            "Storage system reaching capacity limits.",
            "Hardware degradation causing intermittent failures."
        ),
        "Software Engineer", List.of(
            "Application crashing under load.",
            "Memory leak detected in production.",
            "API latency spikes.",
            "Deadlocks in concurrent processing.",
            "Unexpected exceptions not handled in code.",
            "Deployment failures due to configuration errors."
        ),
        "Cloud Data Engineer", List.of(
            "ETL job failed causing delayed data updates.",
            "Data duplication detected in cloud data lake.",
            "Access control misconfiguration exposing sensitive data.",
            "Schema mismatch causing pipeline failures.",
            "Data pipeline latency exceeding SLA limits.",
            "Inconsistent data across multiple cloud regions."
        ),
        "Data Scientist", List.of(
            "Packet loss detected.",
            "VPN connectivity issues.",
            "Firewall misconfiguration causing downtime.",
            "Model training taking excessively long times.",
            "Data preprocessing errors leading to inaccurate results.",
            "Insufficient labeled data impacting model accuracy."
        )
    );

    private static final Map<String, List<String>> TROUBLESHOOTING_STEPS = Map.of(
        "Enterprise Network", List.of(
            "Restart the affected network switches.",
            "Review firewall rules and logs.",
            "Run network diagnostic tools.",
            "Perform traceroute to identify network bottlenecks.",
            "Update firmware on network devices.",
            "Check for IP conflicts on the subnet."
        ),
        "Cloud Infrastructure", List.of(
            "Check cloud provider status and logs.",
            "Validate IAM roles and permissions.",
            "Scale up instances and monitor.",
            "Review auto-scaling group policies.",
            "Clear unused resources to free capacity.",
            "Examine service limits and quotas."
        ),
        "On-Prem Data Center", List.of(
            "Inspect physical server hardware.",
            "Review system logs for errors.",
            "Perform power cycle on problematic devices.",
            "Check for overheating issues in server racks.",
            "Verify UPS and power backup health.",
            "Audit patch and firmware versions on servers."
        ),
        "Hybrid Cloud", List.of(
            "Verify cross-cloud network setup.",
            "Synchronize on-prem and cloud data.",
            "Monitor hybrid deployment health.",
            "Check VPN or direct connect link status.",
            "Test latency between cloud and on-prem nodes.",
            "Validate unified monitoring dashboards."
        )
    );

    private final Random random = new Random();

    @Override
    public ScenarioResponse generateScenario(ScenarioRequest request) {
        // Defensive validation (optional, because controller validates inputs)
        if (!CHALLENGES.containsKey(request.technology())) {
            throw new IllegalArgumentException("Invalid technology provided");
        }
        if (!INCIDENTS.containsKey(request.role())) {
            throw new IllegalArgumentException("Invalid role provided");
        }
        if (!TROUBLESHOOTING_STEPS.containsKey(request.environment())) {
            throw new IllegalArgumentException("Invalid environment provided");
        }
        
        String challenge = getRandomFromMap(CHALLENGES, request.technology());
        String incident = getRandomFromMap(INCIDENTS, request.role());
        String troubleshootingStep = getRandomFromMap(TROUBLESHOOTING_STEPS, request.environment());

        return new ScenarioResponse(
                request.technology(),
                request.role(),
                request.environment(),
                challenge,
                incident,
                troubleshootingStep
        );
    }

    private String getRandomFromMap(Map<String, List<String>> map, String key) {
        List<String> list = map.getOrDefault(key, List.of("No data available."));
        return list.get(random.nextInt(list.size()));
    }
}