package edu.umn.dls.ojibwe;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.lucene.analysis.TokenStream;
import org.apache.solr.analysis.BaseTokenFilterFactory;
import org.apache.solr.common.ResourceLoader;

public class OjibweFuzzyFilterFactory extends BaseTokenFilterFactory
{
    private Boolean removeHyphens = Boolean.valueOf(false);

    public void inform(ResourceLoader loader)
    {
        try
        {
            this.removeHyphens = Boolean.valueOf("true".equalsIgnoreCase((String)getArgs().get("removeHyphens")));
        } catch (Exception ex) {
            Logger.getLogger(OjibweFuzzyFilterFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public OjibweFuzzyFilter create(TokenStream input)
    {
        return new OjibweFuzzyFilter(input, this.removeHyphens.booleanValue());
    }
}