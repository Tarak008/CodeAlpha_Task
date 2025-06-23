import javax.swing.*;
import java.awt.*;

import java.util.HashMap;
import java.util.Map;

public class ChatBotGUI extends JFrame {

    private final JTextArea chatArea;
    private final JTextField userField;
    private final ChatBot bot;

    public ChatBotGUI() {
        bot = new ChatBot();

        setTitle("Java AI ChatBot");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Chat display area
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setFont(new Font("Arial", Font.PLAIN, 14));
        add(new JScrollPane(chatArea), BorderLayout.CENTER);

        // Input field panel
        JPanel inputPanel = new JPanel(new BorderLayout());
        userField = new JTextField();
        inputPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        inputPanel.add(userField, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);

        // Handle user input
        userField.addActionListener(_ -> handleUserInput());


        // Welcome message
        chatArea.append("🤖 ChatBot: Hello! Ask me anything...\n");

        setVisible(true);
    }

    private void handleUserInput() {
        String input = userField.getText().trim();
        if (input.isEmpty()) return;

        chatArea.append("👤 You: " + input + "\n");
        String reply = bot.getResponse(input);
        chatArea.append("🤖 ChatBot: " + reply + "\n\n");
        userField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ChatBotGUI::new);
    }
}

// Inner ChatBot class for logic
class ChatBot {
    private final Map<String, String> faq;

    public ChatBot() {
        faq = new HashMap<>();
        trainBot();
    }

    private void trainBot() {
        faq.put("hi", "Hello! How can I help you?");
        faq.put("hello", "Hi there! Ask me anything.");
        faq.put("how are you", "I'm just a program, but I'm doing well!");
        faq.put("what is your name", "I'm a Java ChatBot.");
        faq.put("bye", "Goodbye! Have a great day.");
        faq.put("thanks", "You're welcome!");
        faq.put("what is java", "Java is a high-level, object-oriented programming language.");
        faq.put("what is ai", "AI stands for Artificial Intelligence — machines that simulate human intelligence.");
    }

    public String getResponse(String input) {
        input = input.toLowerCase();

        for (String key : faq.keySet()) {
            if (input.contains(key)) {
                return faq.get(key);
            }
        }

        return "I'm not sure how to respond to that. Try rephrasing!";
    }
}
