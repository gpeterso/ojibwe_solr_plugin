/*    */ package edu.umn.dls.ojibwe;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import org.apache.lucene.analysis.TokenStream;
/*    */ 
/*    */ public class OjibweStemmerFilter extends StemmerFilter
/*    */ {
/*    */   public OjibweStemmerFilter(TokenStream in, Map<String, List<StemRule>> ruleset)
/*    */     throws Exception
/*    */   {
/* 32 */     super(new OjibweStemmer(ruleset), in);
/*    */   }
/*    */ }

/* Location:           /Users/kalow007/ojibwe_solr/
 * Qualified Name:     edu.umn.dls.ojibwe.OjibweStemmerFilter
 * JD-Core Version:    0.6.2
 */