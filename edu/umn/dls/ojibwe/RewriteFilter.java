/*    */ package edu.umn.dls.ojibwe;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import org.apache.lucene.analysis.TokenFilter;
/*    */ import org.apache.lucene.analysis.TokenStream;
/*    */ import org.apache.lucene.analysis.tokenattributes.TermAttribute;
/*    */ 
/*    */ public class RewriteFilter extends TokenFilter
/*    */ {
/*    */   private final String[][] substitutions;
/*    */   private final TermAttribute termAttribute;
/*    */ 
/*    */   public RewriteFilter(TokenStream in, String[][] substitutions)
/*    */   {
/* 37 */     super(in);
/* 38 */     this.substitutions = substitutions;
/* 39 */     this.termAttribute = ((TermAttribute)addAttribute(TermAttribute.class));
/*    */   }
/*    */ 
/*    */   public final boolean incrementToken()
/*    */     throws IOException
/*    */   {
/* 46 */     if (this.input.incrementToken()) {
/* 47 */       String token = this.termAttribute.term();
/* 48 */       for (String[] pair : this.substitutions) {
/* 49 */         token = token.replaceAll(pair[0], pair[1]);
/*    */       }
/* 51 */       this.termAttribute.setTermBuffer(token);
/* 52 */       return true;
/*    */     }
/* 54 */     return false;
/*    */   }
/*    */ }

/* Location:           /Users/kalow007/ojibwe_solr/
 * Qualified Name:     edu.umn.dls.ojibwe.RewriteFilter
 * JD-Core Version:    0.6.2
 */