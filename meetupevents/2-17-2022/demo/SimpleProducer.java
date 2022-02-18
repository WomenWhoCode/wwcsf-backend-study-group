import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class SimpleProducer {

   public static void main(String[] args) throws Exception{

      String topicName = "quickstart-events";

      // setup producer configs
      Properties props = new Properties();
      props.put("bootstrap.servers", "localhost:9092"); // broker address

      // create producer object
      Producer<String, String> producer = new KafkaProducer<String, String>(props);

      // create dummy record to send
      for (int i = 0; i < 10; i++) {
          ProducerRecord<String, String> record = new ProducerRecord<String, String>(topicName, "Hello world!", "Women Who Code");
          producer.send(record);
          TimeUnit.SECONDS.sleep(1);
      }

      // gracefully close
      producer.close();
   }
}
