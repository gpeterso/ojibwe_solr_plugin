package edu.umn.dls.ojibwe;

import java.io.Reader;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.lucene.analysis.util.TokenizerFactory;
import org.apache.solr.common.ResourceLoader;

public class OjibweTokenizerFactory extends TokenizerFactory
{
    private Boolean acceptHyphens = Boolean.valueOf(false);

    public void inform(ResourceLoader loader)
    {
        try
        {
            this.acceptHyphens = Boolean.valueOf("true".equalsIgnoreCase((String)getArgs().get("acceptHyphens")));
        } catch (Exception ex) {
            Logger.getLogger(OjibweTokenizerFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public OjibweTokenizer create(Reader input)
    {
        return new OjibweTokenizer(input, this.acceptHyphens);
    }
}
