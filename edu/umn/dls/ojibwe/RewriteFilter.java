package edu.umn.dls.ojibwe;

import java.io.IOException;
import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.TermAttribute;

public class RewriteFilter extends TokenFilter
{
    private final String[][] substitutions;
    private final TermAttribute termAttribute;

    public RewriteFilter(TokenStream in, String[][] substitutions)
    {
        super(in);
        this.substitutions = substitutions;
        this.termAttribute = ((TermAttribute)addAttribute(TermAttribute.class));
    }

    public final boolean incrementToken()
    throws IOException
    {
        if (this.input.incrementToken()) {
            String token = this.termAttribute.term();
            for (String[] pair : this.substitutions) {
                token = token.replaceAll(pair[0], pair[1]);
            }
            this.termAttribute.setTermBuffer(token);
            return true;
        }
        return false;
    }
}
