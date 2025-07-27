package io.embry.robotic.settings

import com.intellij.openapi.options.Configurable
import javax.swing.JComponent
import javax.swing.JPanel
import javax.swing.JTextField
import javax.swing.JLabel
import javax.swing.BoxLayout

class RoboticSettingsConfigurable : Configurable {
    private val panel = JPanel()
    private val apiKeyField = JTextField()
    private val apiEndpointField = JTextField()
    private val modelNameField = JTextField()

    init {
        panel.layout = BoxLayout(panel, BoxLayout.Y_AXIS)
        panel.add(JLabel("API Key:"))
        panel.add(apiKeyField)
        panel.add(JLabel("API Endpoint:"))
        panel.add(apiEndpointField)
        panel.add(JLabel("Model Name:"))
        panel.add(modelNameField)
    }

    override fun createComponent(): JComponent = panel

    override fun isModified(): Boolean = true

    override fun apply() {
        // Save settings (implement persistent storage)
    }

    override fun getDisplayName(): String = "Robotic Settings"
}