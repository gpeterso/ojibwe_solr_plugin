package edu.umn.dls.ojibwe;

import java.util.List;
import java.util.Map;
import org.apache.lucene.analysis.TokenStream;

public class OjibweStemmerFilter extends StemmerFilter
{
    public OjibweStemmerFilter(TokenStream in, Map<String, List<StemRule>> ruleset) throws Exception
    {
        super(new OjibweStemmer(ruleset), in);
    }
}
