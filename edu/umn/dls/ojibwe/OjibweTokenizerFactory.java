/*    */ package edu.umn.dls.ojibwe;
/*    */ 
/*    */ import java.io.Reader;
/*    */ import java.util.Map;
/*    */ import java.util.logging.Level;
/*    */ import java.util.logging.Logger;
/*    */ import org.apache.solr.analysis.BaseTokenizerFactory;
/*    */ import org.apache.solr.common.ResourceLoader;
/*    */ 
/*    */ public class OjibweTokenizerFactory extends BaseTokenizerFactory
/*    */ {
/* 26 */   private Boolean acceptHyphens = Boolean.valueOf(false);
/*    */ 
/*    */   public void inform(ResourceLoader loader)
/*    */   {
/*    */     try
/*    */     {
/* 39 */       this.acceptHyphens = Boolean.valueOf("true".equalsIgnoreCase((String)getArgs().get("acceptHyphens")));
/*    */     } catch (Exception ex) {
/* 41 */       Logger.getLogger(OjibweTokenizerFactory.class.getName()).log(Level.SEVERE, null, ex);
/*    */     }
/*    */   }
/*    */ 
/*    */   public OjibweTokenizer create(Reader input)
/*    */   {
/* 48 */     return new OjibweTokenizer(input, this.acceptHyphens);
/*    */   }
/*    */ }

/* Location:           /Users/kalow007/ojibwe_solr/
 * Qualified Name:     edu.umn.dls.ojibwe.OjibweTokenizerFactory
 * JD-Core Version:    0.6.2
 */