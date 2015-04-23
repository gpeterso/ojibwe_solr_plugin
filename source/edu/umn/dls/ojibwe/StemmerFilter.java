package edu.umn.dls.ojibwe;

import java.io.IOException;
import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

public class StemmerFilter extends TokenFilter
{
    private final Stemmer stemmer;
    private CharTermAttribute termAttribute;
    private PositionIncrementAttribute positionAttribute;

    public StemmerFilter(Stemmer stemmer, TokenStream in)
    {
        super(in);
        this.stemmer = stemmer;
        this.termAttribute = (addAttribute(CharTermAttribute.class));
        this.positionAttribute = (addAttribute(PositionIncrementAttribute.class));
    }

    public final boolean incrementToken()
    throws IOException
    {
        if (this.stemmer.hasNext())
        {
            this.positionAttribute.setPositionIncrement(0);
            this.termAttribute.copyBuffer(this.stemmer.next().toCharArray(), 0, this.termAttribute.length());
            return true;
        }

        while (this.input.incrementToken()) {
            this.stemmer.setToken(new String(this.termAttribute.buffer()));
            if (this.stemmer.hasNext()) {
                this.positionAttribute.setPositionIncrement(1);
                this.termAttribute.copyBuffer(this.stemmer.next().toCharArray(),0,this.termAttribute.length());
                return true;
            }
        }
        return false;
    }
}
