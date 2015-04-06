package edu.umn.dls.ojibwe;

import java.io.IOException;
import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;
import org.apache.lucene.analysis.tokenattributes.TermAttribute;

public class StemmerFilter extends TokenFilter
{
    private final Stemmer stemmer;
    private TermAttribute termAttribute;
    private PositionIncrementAttribute positionAttribute;

    public StemmerFilter(Stemmer stemmer, TokenStream in)
    {
        super(in);
        this.stemmer = stemmer;
        this.termAttribute = ((TermAttribute)addAttribute(TermAttribute.class));
        this.positionAttribute = ((PositionIncrementAttribute)addAttribute(PositionIncrementAttribute.class));
    }

    public final boolean incrementToken()
    throws IOException
    {
        if (this.stemmer.hasNext())
        {
            this.positionAttribute.setPositionIncrement(0);
            this.termAttribute.setTermBuffer(this.stemmer.next());
            return true;
        }

        while (this.input.incrementToken()) {
            this.stemmer.setToken(this.termAttribute.term());
            if (this.stemmer.hasNext()) {
                this.positionAttribute.setPositionIncrement(1);
                this.termAttribute.setTermBuffer(this.stemmer.next());
                return true;
            }
        }
        return false;
    }
}
