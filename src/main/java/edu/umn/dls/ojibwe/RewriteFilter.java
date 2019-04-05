package edu.umn.dls.ojibwe;

import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

import java.io.IOException;

public class RewriteFilter extends TokenFilter {
  private final String[][] substitutions;
  private final CharTermAttribute termAttribute;

  public RewriteFilter(TokenStream in, String[][] substitutions) {
    super(in);
    this.substitutions = substitutions;
    this.termAttribute = (addAttribute(CharTermAttribute.class));
  }

  public final boolean incrementToken()
      throws IOException {
    if (this.input.incrementToken()) {
      char[] tokenCharArray = this.termAttribute.buffer();
      String token = new String(tokenCharArray).trim();
      for (String[] pair : this.substitutions) {
        token = token.replaceAll(pair[0], pair[1]);
      }
      this.termAttribute.setEmpty().append(token);
      return true;
    }
    return false;
  }
}
