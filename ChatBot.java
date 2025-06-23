import java.util.HashMap;
import java.util.Map;


public class ChatBot {
    private final Map<String, String> faq;

    public ChatBot() {
        faq = new HashMap<>();
        trainBot();
    }

    // Add rule-based questions and answers
    private void trainBot() {
        faq.put("hi", "Hello! How can I help you today?");
        faq.put("hello", "Hi there! Ask me anything.");
        faq.put("how are you", "I'm just a program, but I'm doing great!");
        faq.put("what is your name", "I am a Java AI Chatbot.");
        faq.put("bye", "Goodbye! Have a nice day!");
        faq.put("what is java", "Java is a high-level, object-oriented programming language.");
        faq.put("what is ai", "AI stands for Artificial Intelligence — machines simulating human intelligence.");
        faq.put("thanks", "You're welcome!");
    }

    // NLP logic: basic keyword matching
    public String getResponse(String userInput) {
        userInput = userInput.toLowerCase().trim();

        for (String question : faq.keySet()) {
            if (userInput.contains(question)) {
                return faq.get(question);
            }
        }

        return "I'm sorry, I don't understand that. Can you rephrase?";
    }
}
