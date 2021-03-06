package edu.umn.dls.ojibwe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

public class OjibweHyphenizationFilter extends TokenFilter
{
    private final CharTermAttribute termAttribute;
    private final PositionIncrementAttribute positionAttribute;
    private OffsetAttribute offSetAttribute;
    private final List<String> tokensList = new ArrayList();

    public OjibweHyphenizationFilter(TokenStream in)
    {
        super(in);
        this.termAttribute = addAttribute(CharTermAttribute.class);
        this.positionAttribute = addAttribute(PositionIncrementAttribute.class);
        this.offSetAttribute = (addAttribute(OffsetAttribute.class));
    }

    public final boolean incrementToken() throws IOException
    {
        if (!this.tokensList.isEmpty())
        {
            this.positionAttribute.setPositionIncrement(0);
            this.termAttribute.setEmpty().append(this.tokensList.remove(0).trim());
            return true;
        }

        while (this.input.incrementToken()) {
            String token = new String(
                    this.termAttribute.buffer(),
                    0,
                    this.offSetAttribute.endOffset() - this.offSetAttribute.startOffset() - 1
            );
            hyphenate(token);
            if (!this.tokensList.isEmpty()) {
                this.positionAttribute.setPositionIncrement(1);
                this.termAttribute.setEmpty().append(this.tokensList.remove(0));
                return true;
            }
        }
        return false;

    }

    private void hyphenate(String term)
    {
        this.tokensList.add(term.replaceAll("-", ""));
        int i;
        if ((i = term.indexOf('-')) > 0) {
            this.tokensList.add(term.substring(0, i));
            hyphenate(term.substring(i + 1));
        }
    }
}