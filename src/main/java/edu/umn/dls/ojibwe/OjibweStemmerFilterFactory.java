package edu.umn.dls.ojibwe;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.util.TokenFilterFactory;
import org.apache.lucene.analysis.util.ResourceLoader;
import org.apache.lucene.analysis.util.ResourceLoaderAware;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class OjibweStemmerFilterFactory extends TokenFilterFactory
  implements ResourceLoaderAware
{
    private Map<String, List<StemRule>> ruleset = null;

    public OjibweStemmerFilterFactory(Map<String, String> args) {
        super(args);
    }

    public void inform(ResourceLoader loader)
    {
        try
        {
            String rulesFileName = "StemRules.xml";
            this.ruleset = loadRulesFile(loader, rulesFileName);
        } catch (Exception ex) {
            Logger.getLogger(OjibweStemmerFilterFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Map<String, List<StemRule>> loadRulesFile(ResourceLoader loader, String fileName)
    throws ParserConfigurationException, SAXException, IOException
    {
        Map map = new HashMap();

        InputStream rulesStream = loader.openResource(fileName);

        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(rulesStream);

        Element root = (Element)doc.getElementsByTagName("stem-rules").item(0);

        NodeList ruleSetNodes = root.getElementsByTagName("rule-set");
        for (int i = 0; i < ruleSetNodes.getLength(); i++) {
            Element ruleSetNode = (Element)ruleSetNodes.item(i);

            List ruleList = new ArrayList();

            NodeList ruleNodes = ruleSetNode.getElementsByTagName("rule");
            for (int j = 0; j < ruleNodes.getLength(); j++) {
                Element ruleNode = (Element)ruleNodes.item(j);

                ruleList.add(new StemRule(ruleNode.getAttribute("regex"), ruleNode.getAttribute("format")));
            }

            map.put(ruleSetNode.getAttribute("name"), ruleList);
        }

        return map;
    }

    public OjibweStemmerFilter create(TokenStream input)
    {
        try
        {
            return new OjibweStemmerFilter(input, this.ruleset);
        } catch (Exception ex) {
            Logger.getLogger(OjibweStemmerFilterFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
