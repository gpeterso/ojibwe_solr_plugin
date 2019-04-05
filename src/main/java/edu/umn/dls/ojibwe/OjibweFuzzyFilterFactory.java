package edu.umn.dls.ojibwe;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.util.ResourceLoader;
import org.apache.lucene.analysis.util.TokenFilterFactory;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OjibweFuzzyFilterFactory extends TokenFilterFactory {
  private Boolean removeHyphens = Boolean.valueOf(false);

  public OjibweFuzzyFilterFactory(Map<String, String> args) {
    super(args);
  }

  public void inform(ResourceLoader loader) {
    try {
      this.removeHyphens = Boolean.valueOf("true".equalsIgnoreCase(this.get(this.getOriginalArgs(), "removeHyphens")));
    } catch (Exception ex) {
      Logger.getLogger(OjibweFuzzyFilterFactory.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public OjibweFuzzyFilter create(TokenStream input) {
    return new OjibweFuzzyFilter(input, this.removeHyphens.booleanValue());
  }
}