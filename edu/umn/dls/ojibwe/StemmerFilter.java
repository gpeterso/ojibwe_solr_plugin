/*    */ package edu.umn.dls.ojibwe;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import org.apache.lucene.analysis.TokenFilter;
/*    */ import org.apache.lucene.analysis.TokenStream;
/*    */ import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;
/*    */ import org.apache.lucene.analysis.tokenattributes.TermAttribute;
/*    */ 
/*    */ public class StemmerFilter extends TokenFilter
/*    */ {
/*    */   private final Stemmer stemmer;
/*    */   private TermAttribute termAttribute;
/*    */   private PositionIncrementAttribute positionAttribute;
/*    */ 
/*    */   public StemmerFilter(Stemmer stemmer, TokenStream in)
/*    */   {
/* 39 */     super(in);
/* 40 */     this.stemmer = stemmer;
/* 41 */     this.termAttribute = ((TermAttribute)addAttribute(TermAttribute.class));
/* 42 */     this.positionAttribute = ((PositionIncrementAttribute)addAttribute(PositionIncrementAttribute.class));
/*    */   }
/*    */ 
/*    */   public final boolean incrementToken()
/*    */     throws IOException
/*    */   {
/* 50 */     if (this.stemmer.hasNext())
/*    */     {
/* 52 */       this.positionAttribute.setPositionIncrement(0);
/* 53 */       this.termAttribute.setTermBuffer(this.stemmer.next());
/* 54 */       return true;
/*    */     }
/*    */ 
/* 57 */     while (this.input.incrementToken()) {
/* 58 */       this.stemmer.setToken(this.termAttribute.term());
/* 59 */       if (this.stemmer.hasNext()) {
/* 60 */         this.positionAttribute.setPositionIncrement(1);
/* 61 */         this.termAttribute.setTermBuffer(this.stemmer.next());
/* 62 */         return true;
/*    */       }
/*    */     }
/* 65 */     return false;
/*    */   }
/*    */ }

/* Location:           /Users/kalow007/ojibwe_solr/
 * Qualified Name:     edu.umn.dls.ojibwe.StemmerFilter
 * JD-Core Version:    0.6.2
 */