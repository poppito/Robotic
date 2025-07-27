package io.embry.robotic.action

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.ui.Messages

class RoboticChatAction : AnAction("Robotic Chat") {
    override fun actionPerformed(e: AnActionEvent) {
        Messages.showMessageDialog(
            e.project,
            "This is where the chat interface will be implemented.",
            "Robotic Chat",
            Messages.getInformationIcon()
        )
    }
}