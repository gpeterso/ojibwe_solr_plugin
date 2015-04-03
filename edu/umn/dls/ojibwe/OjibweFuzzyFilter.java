/*    */ package edu.umn.dls.ojibwe;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import org.apache.lucene.analysis.TokenStream;
/*    */ 
/*    */ public class OjibweFuzzyFilter extends RewriteFilter
/*    */ {
/* 25 */   private static final String[][] SUBSTITUTIONS = { { "-", "" }, { "tch", "ch" }, { "tc", "ch" }, { "ch", "X" }, { "c", "sh" }, { "X", "ch" }, { "qu", "kw" }, { "qw", "kw" }, { "dj", "j" }, { "ah", "aa" }, { "auh", "aa" }, { "au", "aa" }, { "ae", "e" }, { "ee", "ii" }, { "eh", "e" }, { "ey", "e" }, { "ih", "i" }, { "oh", "oo" }, { "ou", "oo" }, { "uh", "a" }, { "u", "a" } };
/*    */ 
/*    */   public OjibweFuzzyFilter(TokenStream in, boolean removeHyphens)
/*    */   {
/* 85 */     super(in, removeHyphens ? SUBSTITUTIONS : (String[][])Arrays.copyOfRange(SUBSTITUTIONS, 1, SUBSTITUTIONS.length - 1));
/*    */   }
/*    */ }

/* Location:           /Users/kalow007/ojibwe_solr/
 * Qualified Name:     edu.umn.dls.ojibwe.OjibweFuzzyFilter
 * JD-Core Version:    0.6.2
 */