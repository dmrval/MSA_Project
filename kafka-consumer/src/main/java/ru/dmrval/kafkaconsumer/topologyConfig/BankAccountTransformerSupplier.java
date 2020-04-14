package ru.dmrval.kafkaconsumer.topologyConfig;

import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.Transformer;
import org.apache.kafka.streams.kstream.TransformerSupplier;
import org.apache.kafka.streams.processor.ProcessorContext;
import ru.dmrval.kafkaconsumer.model.Address;
import ru.dmrval.kafkaconsumer.model.BankAccount;
import ru.dmrval.kafkaconsumer.model.BankAccountInfo;

public class BankAccountTransformerSupplier
    implements TransformerSupplier<String, BankAccount, KeyValue<String, BankAccountInfo>> {

  @Override
  public Transformer<String, BankAccount, KeyValue<String, BankAccountInfo>> get() {
    return new Transformer<String, BankAccount, KeyValue<String, BankAccountInfo>>() {
      @Override
      public void init(ProcessorContext processorContext) {}

      @Override
      public KeyValue<String, BankAccountInfo> transform(String s, BankAccount bankAccount) {
        return KeyValue.pair(s, new BankAccountInfo(bankAccount, new Address("A", "A", "A")));
      }

      @Override
      public void close() {}
    };
  }
}
