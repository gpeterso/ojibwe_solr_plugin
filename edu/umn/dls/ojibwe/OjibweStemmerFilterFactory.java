/*     */ package edu.umn.dls.ojibwe;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import javax.xml.parsers.DocumentBuilder;
/*     */ import javax.xml.parsers.DocumentBuilderFactory;
/*     */ import javax.xml.parsers.ParserConfigurationException;
/*     */ import org.apache.lucene.analysis.TokenStream;
/*     */ import org.apache.solr.analysis.BaseTokenFilterFactory;
/*     */ import org.apache.solr.common.ResourceLoader;
/*     */ import org.apache.solr.util.plugin.ResourceLoaderAware;
/*     */ import org.w3c.dom.Document;
/*     */ import org.w3c.dom.Element;
/*     */ import org.w3c.dom.NodeList;
/*     */ import org.xml.sax.SAXException;
/*     */ 
/*     */ public class OjibweStemmerFilterFactory extends BaseTokenFilterFactory
/*     */   implements ResourceLoaderAware
/*     */ {
/*  40 */   private Map<String, List<StemRule>> ruleset = null;
/*     */ 
/*     */   public void inform(ResourceLoader loader)
/*     */   {
/*     */     try
/*     */     {
/*  54 */       String rulesFileName = (String)getArgs().get("ruleset");
/*  55 */       this.ruleset = loadRulesFile(loader, rulesFileName);
/*     */     } catch (Exception ex) {
/*  57 */       Logger.getLogger(OjibweStemmerFilterFactory.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */   }
/*     */ 
/*     */   public static Map<String, List<StemRule>> loadRulesFile(ResourceLoader loader, String fileName)
/*     */     throws ParserConfigurationException, SAXException, IOException
/*     */   {
/*  85 */     Map map = new HashMap();
/*     */ 
/*  88 */     InputStream rulesStream = loader.openResource(fileName);
/*     */ 
/*  91 */     Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(rulesStream);
/*     */ 
/*  95 */     Element root = (Element)doc.getElementsByTagName("stem-rules").item(0);
/*     */ 
/*  98 */     NodeList ruleSetNodes = root.getElementsByTagName("rule-set");
/*  99 */     for (int i = 0; i < ruleSetNodes.getLength(); i++) {
/* 100 */       Element ruleSetNode = (Element)ruleSetNodes.item(i);
/*     */ 
/* 103 */       List ruleList = new ArrayList();
/*     */ 
/* 106 */       NodeList ruleNodes = ruleSetNode.getElementsByTagName("rule");
/* 107 */       for (int j = 0; j < ruleNodes.getLength(); j++) {
/* 108 */         Element ruleNode = (Element)ruleNodes.item(j);
/*     */ 
/* 111 */         ruleList.add(new StemRule(ruleNode.getAttribute("regex"), ruleNode.getAttribute("format")));
/*     */       }
/*     */ 
/* 116 */       map.put(ruleSetNode.getAttribute("name"), ruleList);
/*     */     }
/*     */ 
/* 120 */     return map;
/*     */   }
/*     */ 
/*     */   public OjibweStemmerFilter create(TokenStream input)
/*     */   {
/*     */     try
/*     */     {
/* 133 */       return new OjibweStemmerFilter(input, this.ruleset);
/*     */     } catch (Exception ex) {
/* 135 */       Logger.getLogger(OjibweStemmerFilterFactory.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/* 137 */     return null;
/*     */   }
/*     */ }

/* Location:           /Users/kalow007/ojibwe_solr/
 * Qualified Name:     edu.umn.dls.ojibwe.OjibweStemmerFilterFactory
 * JD-Core Version:    0.6.2
 */