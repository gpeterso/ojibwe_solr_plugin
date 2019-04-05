package edu.umn.dls.ojibwe;

import org.apache.lucene.analysis.TokenStream;

import java.util.List;
import java.util.Map;

public class OjibweStemmerFilter extends StemmerFilter {
  public OjibweStemmerFilter(TokenStream in, Map<String, List<StemRule>> ruleset) throws Exception {
    super(new OjibweStemmer(ruleset), in);
  }
}
