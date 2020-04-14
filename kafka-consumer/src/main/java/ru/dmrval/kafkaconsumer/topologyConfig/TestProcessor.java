package ru.dmrval.kafkaconsumer.topologyConfig;

import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.processor.Processor;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.apache.kafka.streams.processor.ProcessorSupplier;
import org.apache.kafka.streams.processor.PunctuationType;
import org.apache.kafka.streams.state.KeyValueIterator;
import org.apache.kafka.streams.state.KeyValueStore;
import ru.dmrval.kafkaconsumer.model.BankAccount;

public class TestProcessor implements ProcessorSupplier<String, BankAccount> {
  private ProcessorContext context;
  private KeyValueStore<String, BankAccount> kvStore;

  @SuppressWarnings("unchecked")
  public void init(ProcessorContext context) {
    // keep the processor context locally because we need it in punctuate() and commit()
    this.context = context;

    // retrieve the key-value store named "Counts"
    kvStore = (KeyValueStore) context.getStateStore("myValueTransformState");

    // schedule a punctuate() method every 1000 milliseconds based on stream-time
    this.context.schedule(
        1000,
        PunctuationType.STREAM_TIME,
        (timestamp) -> {
          KeyValueIterator<String, BankAccount> iter = this.kvStore.all();
          while (iter.hasNext()) {
            KeyValue<String, BankAccount> entry = iter.next();
            context.forward(entry.key, entry.value.toString());
          }
          iter.close();

          // commit the current processing progress
          context.commit();
        });
  }


    @Override
    public Processor<String, BankAccount> get() {
        return new Processor<String, BankAccount>() {
            @Override
            public void init(ProcessorContext processorContext) {

            }

            @Override
            public void process(String s, BankAccount bankAccount) {

            }

            @Override
            public void close() {

            }
        };
    }
}
