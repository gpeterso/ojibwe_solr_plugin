package edu.umn.dls.ojibwe;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.util.TokenFilterFactory;

import java.util.Map;

public class OjibweHyphenizationFilterFactory extends TokenFilterFactory {
  public OjibweHyphenizationFilterFactory(Map<String, String> args) {
    super(args);
  }

  public OjibweHyphenizationFilter create(TokenStream input) {
    return new OjibweHyphenizationFilter(input);
  }
}
