import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;

public class customConsumer {

   public static void main(String[] args) throws Exception{

      String topicName = "demo-temperature";

      // setup consumer configs
      Properties props = new Properties();
      props.put("bootstrap.servers", "localhost:9092"); // broker address
      props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
      props.put("value.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
      props.put("group.id","customConsumer");

      // create consumer object
      Consumer<String, String> consumer = new KafkaConsumer<String, String>(props);
      consumer.subscribe(Collections.singletonList(topicName));

      while (true) {
            ConsumerRecords<String, String> consumerRecords = consumer.poll(1000);

            consumerRecords.forEach(record -> {
                System.out.printf("Consumer Record:(%s, %s, %d, %d)\n",
                        record.key(), record.value(),
                        record.partition(), record.offset());
            });

            consumer.commitAsync();
        }
   }
}
