package edu.umn.dls.ojibwe;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.util.TokenFilterFactory;

public class OjibweHyphenizationFilterFactory extends TokenFilterFactory
{
    public OjibweHyphenizationFilter create(TokenStream input)
    {
        return new OjibweHyphenizationFilter(input);
    }
}
