package jp.co.fullhouse.lespos.lesposapplication.utils.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import jp.co.fullhouse.lespos.lesposapplication.utils.constant.InvoiceStatus;

public class InvoiceStatusSerializer extends JsonSerializer<InvoiceStatus> {

  @Override
  public void serialize(InvoiceStatus value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
    gen.writeStartObject();
    gen.writeNumberField("code", value.getCode());
    gen.writeStringField("name", value.getName());
    gen.writeEndObject();
  }
}
