package io.embry.robotic.services

import com.intellij.openapi.components.Service
import com.intellij.openapi.diagnostic.Logger
import org.yaml.snakeyaml.Yaml
import java.io.File

@Service
class RoboticService {
    private val logger = Logger.getInstance(RoboticService::class.java)
    var persona: String = ""
    var prompt: String = ""

    fun loadConfiguration(projectPath: String) {
        val configFile = File("$projectPath/.robotic.yml")
        if (configFile.exists()) {
            val yaml = Yaml()
            val config = yaml.load<Map<String, String>>(configFile.inputStream())
            persona = config["persona"] ?: ""
            prompt = config["prompt"] ?: ""
            logger.info("Loaded .robotic.yml: persona=$persona, prompt=$prompt")
        } else {
            logger.warn(".robotic.yml not found in project path: $projectPath")
        }
    }
}