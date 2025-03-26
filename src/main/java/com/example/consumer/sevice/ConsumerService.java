package com.example.consumer.sevice;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import java.io.FileWriter;
import java.io.IOException;
@Service
public class ConsumerService {



    @KafkaListener(topics = "test-topic", groupId = "my-group")
    public void consume(String message) {
        System.out.println("Received: " + message);

        // Process the message
        String processedMessage = message + " - Length: " + message.length();

        // Save to a new file
        saveToFile(processedMessage);
    }

    private void saveToFile(String data) {
        try (FileWriter writer = new FileWriter("output.txt", true)) {
            writer.write(data + "\n");
            System.out.println("Saved to file: " + data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

