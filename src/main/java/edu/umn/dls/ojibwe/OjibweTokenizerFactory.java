package edu.umn.dls.ojibwe;

import java.io.Reader;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.lucene.analysis.util.TokenizerFactory;
import org.apache.lucene.util.AttributeFactory;
import org.apache.lucene.analysis.util.ResourceLoader;
import org.apache.solr.core.AbstractSolrEventListener;

public class OjibweTokenizerFactory extends TokenizerFactory
{
    private Boolean acceptHyphens = false;

    public OjibweTokenizerFactory(Map<String, String> args) {
        super(args);
    }

    public void inform(ResourceLoader loader)
    {
        try
        {
            this.acceptHyphens = "true".equalsIgnoreCase(this.get(this.getOriginalArgs(), "acceptHyphens"));
        } catch (Exception ex) {
            Logger.getLogger(OjibweTokenizerFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public OjibweTokenizer create(AttributeFactory attributeFactory)
    {
        // TODO: Consider replacing this with CharTokenizer.fromTokenCharPredicate(...)
        return new OjibweTokenizer(this.acceptHyphens);
    }
}
