import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class customProducer {

   public static void main(String[] args) throws Exception{

      String topicName = "demo-temperature";

      // setup producer configs
      Properties props = new Properties();
      props.put("bootstrap.servers", "localhost:9092"); // broker address
      props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
      props.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");

      // create producer object
      Producer<String, String> producer = new KafkaProducer<String, String>(props);

      // create dummy record to send
      for (int i = 0; i < 10; i++) {
					System.out.println("Producing record...");
          ProducerRecord<String, String> record = new ProducerRecord<String, String>(topicName, "Custom Producer", "100");
          producer.send(record);
          TimeUnit.SECONDS.sleep(1);
      }

      // gracefully close
      producer.close();
   }
}
