/*    */ package edu.umn.dls.ojibwe;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.apache.lucene.analysis.TokenFilter;
/*    */ import org.apache.lucene.analysis.TokenStream;
/*    */ import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;
/*    */ import org.apache.lucene.analysis.tokenattributes.TermAttribute;
/*    */ 
/*    */ public class OjibweHyphenizationFilter extends TokenFilter
/*    */ {
/*    */   private final TermAttribute termAttribute;
/*    */   private final PositionIncrementAttribute positionAttribute;
/* 30 */   private final List<String> tokensList = new ArrayList();
/*    */ 
/*    */   public OjibweHyphenizationFilter(TokenStream in)
/*    */   {
/* 34 */     super(in);
/* 35 */     this.termAttribute = ((TermAttribute)addAttribute(TermAttribute.class));
/* 36 */     this.positionAttribute = ((PositionIncrementAttribute)addAttribute(PositionIncrementAttribute.class));
/*    */   }
/*    */ 
/*    */   public final boolean incrementToken()
/*    */     throws IOException
/*    */   {
/* 44 */     if (!this.tokensList.isEmpty())
/*    */     {
/* 46 */       this.positionAttribute.setPositionIncrement(0);
/* 47 */       this.termAttribute.setTermBuffer((String)this.tokensList.remove(0));
/* 48 */       return true;
/*    */     }
/*    */ 
/* 51 */     while (this.input.incrementToken()) {
/* 52 */       hyphenate(this.termAttribute.term());
/* 53 */       if (!this.tokensList.isEmpty()) {
/* 54 */         this.positionAttribute.setPositionIncrement(1);
/* 55 */         this.termAttribute.setTermBuffer((String)this.tokensList.remove(0));
/* 56 */         return true;
/*    */       }
/*    */     }
/* 59 */     return false;
/*    */   }
/*    */ 
/*    */   private void hyphenate(String term)
/*    */   {
/* 65 */     this.tokensList.add(term.replaceAll("-", ""));
/*    */     int i;
/* 67 */     if ((i = term.indexOf('-')) > 0) {
/* 68 */       this.tokensList.add(term.substring(0, i));
/* 69 */       hyphenate(term.substring(i + 1));
/*    */     }
/*    */   }
/*    */ }

/* Location:           /Users/kalow007/ojibwe_solr/
 * Qualified Name:     edu.umn.dls.ojibwe.OjibweHyphenizationFilter
 * JD-Core Version:    0.6.2
 */