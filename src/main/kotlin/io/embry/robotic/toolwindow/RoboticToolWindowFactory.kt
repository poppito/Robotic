package io.embry.robotic.toolwindow

import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import com.intellij.ui.content.ContentFactory
import io.embry.robotic.RoboticChatPanel
import io.embry.robotic.services.RoboticService
import javax.swing.JPanel
import javax.swing.JLabel
import javax.swing.BoxLayout

class RoboticToolWindowFactory : ToolWindowFactory {
    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {
        val chatPanel = RoboticChatPanel(project)
        val contentFactory = ContentFactory.getInstance()
        val content = contentFactory.createContent(chatPanel, "", false)
        toolWindow.contentManager.addContent(content)
    }
}