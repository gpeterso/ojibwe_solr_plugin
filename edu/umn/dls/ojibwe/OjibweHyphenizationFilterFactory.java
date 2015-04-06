package edu.umn.dls.ojibwe;

import org.apache.lucene.analysis.TokenStream;
import org.apache.solr.analysis.BaseTokenFilterFactory;

public class OjibweHyphenizationFilterFactory extends BaseTokenFilterFactory
{
    public OjibweHyphenizationFilter create(TokenStream input)
    {
        return new OjibweHyphenizationFilter(input);
    }
}
