package io.embry.robotic

import com.intellij.openapi.project.Project
import com.intellij.ui.components.JBScrollPane
import javax.swing.*
import java.awt.*
import java.awt.event.ActionEvent
import java.awt.event.ActionListener

class RoboticChatPanel(private val project: Project) : JPanel() {
    private val chatArea: JTextArea = JTextArea()
    private val inputField: JTextField = JTextField()
    private val sendButton: JButton = JButton("Send")

    init {
        layout = BorderLayout()

        // Chat area (non-editable)
        chatArea.isEditable = false
        chatArea.lineWrap = true
        chatArea.wrapStyleWord = true
        val chatScrollPane = JBScrollPane(chatArea)
        chatScrollPane.verticalScrollBarPolicy = JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
        add(chatScrollPane, BorderLayout.CENTER)

        // Input panel (text field + send button)
        val inputPanel = JPanel(BorderLayout())
        inputPanel.add(inputField, BorderLayout.CENTER)
        inputPanel.add(sendButton, BorderLayout.EAST)
        add(inputPanel, BorderLayout.SOUTH)

        // Add action listener for the send button
        sendButton.addActionListener(SendButtonListener())
        inputField.addActionListener(SendButtonListener()) // Pressing Enter also sends the message
    }

    private inner class SendButtonListener : ActionListener {
        override fun actionPerformed(e: ActionEvent?) {
            val userInput = inputField.text.trim()
            if (userInput.isNotEmpty()) {
                appendMessage("You: $userInput")
                inputField.text = ""

                // Simulate API call and response (replace with actual API integration)
                val response = callLLMApi(userInput)
                appendMessage("Robotic: $response")
            }
        }
    }

    private fun appendMessage(message: String) {
        chatArea.append("$message\n")
        chatArea.caretPosition = chatArea.document.length // Auto-scroll to the bottom
    }

    private fun callLLMApi(input: String): String {
        // Placeholder for API call logic
        return "This is a simulated response for: \"$input\""
    }
}