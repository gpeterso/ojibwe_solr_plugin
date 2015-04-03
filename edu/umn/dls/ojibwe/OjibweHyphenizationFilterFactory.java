/*    */ package edu.umn.dls.ojibwe;
/*    */ 
/*    */ import org.apache.lucene.analysis.TokenStream;
/*    */ import org.apache.solr.analysis.BaseTokenFilterFactory;
/*    */ 
/*    */ public class OjibweHyphenizationFilterFactory extends BaseTokenFilterFactory
/*    */ {
/*    */   public OjibweHyphenizationFilter create(TokenStream input)
/*    */   {
/* 24 */     return new OjibweHyphenizationFilter(input);
/*    */   }
/*    */ }

/* Location:           /Users/kalow007/ojibwe_solr/
 * Qualified Name:     edu.umn.dls.ojibwe.OjibweHyphenizationFilterFactory
 * JD-Core Version:    0.6.2
 */