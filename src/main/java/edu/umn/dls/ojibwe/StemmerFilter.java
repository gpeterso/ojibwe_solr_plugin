package edu.umn.dls.ojibwe;

import java.io.IOException;
import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

public class StemmerFilter extends TokenFilter
{
    private final Stemmer stemmer;
    private CharTermAttribute termAttribute;
    private PositionIncrementAttribute positionAttribute;
    private OffsetAttribute offSetAttribute;

    public StemmerFilter(Stemmer stemmer, TokenStream in)
    {
        super(in);
        this.stemmer = stemmer;
        this.termAttribute = (addAttribute(CharTermAttribute.class));
        this.positionAttribute = (addAttribute(PositionIncrementAttribute.class));
        this.offSetAttribute = (addAttribute(OffsetAttribute.class));
    }

    public final boolean incrementToken()
    throws IOException
    {

        if (this.stemmer.hasNext())
        {
            String token = this.stemmer.next().trim();
            this.positionAttribute.setPositionIncrement(0);
            this.termAttribute.setEmpty().append(token);
            return true;
        }

        while (this.input.incrementToken()) {
            this.stemmer.setToken(new String(
                this.termAttribute.buffer(),
                0,
                (this.offSetAttribute.endOffset() - this.offSetAttribute.startOffset())
            ));
            if (this.stemmer.hasNext()) {
                String token = this.stemmer.next();
                this.positionAttribute.setPositionIncrement(1);
                this.termAttribute.setEmpty().append(token);
                return true;
            }
        }
        return false;
    }
}
