package io.embry.robotic

import com.intellij.openapi.project.Project
import io.embry.robotic.settings.RoboticSettingsConfigurable
import javax.swing.*
import java.awt.BorderLayout

class RoboticSettingsDialog(project: Project) : JDialog() {
    init {
        title = "Robotic Settings"
        setSize(500, 300)
        setLocationRelativeTo(null)
        layout = BorderLayout()

        val configurable = RoboticSettingsConfigurable()
        val settingsPanel = configurable.createComponent()

        add(settingsPanel, BorderLayout.CENTER)

        val buttonPanel = JPanel()
        val applyButton = JButton("Apply")
        val cancelButton = JButton("Cancel")

        applyButton.addActionListener {
            configurable.apply()
            isVisible = false
        }
        cancelButton.addActionListener {
            isVisible = false
        }
        buttonPanel.add(applyButton)
        buttonPanel.add(cancelButton)
        add(buttonPanel, BorderLayout.SOUTH)
    }
}