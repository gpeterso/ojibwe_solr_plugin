/*    */ package edu.umn.dls.ojibwe;
/*    */ 
/*    */ import java.io.Reader;
/*    */ import org.apache.lucene.analysis.CharTokenizer;
/*    */ 
/*    */ public class OjibweTokenizer extends CharTokenizer
/*    */ {
/* 22 */   private Boolean acceptHyphens = Boolean.valueOf(true);
/*    */ 
/*    */   public OjibweTokenizer(Reader reader)
/*    */   {
/* 26 */     this(reader, Boolean.valueOf(false));
/*    */   }
/*    */ 
/*    */   public OjibweTokenizer(Reader reader, Boolean acceptHyphens)
/*    */   {
/* 31 */     super(reader);
/* 32 */     this.acceptHyphens = acceptHyphens;
/*    */   }
/*    */ 
/*    */   protected boolean isTokenChar(char c)
/*    */   {
/* 46 */     return (('a' <= c) && (c <= 'z')) || (('A' <= c) && (c <= 'Z')) || (('0' <= c) && (c <= '9')) || (c == '\'') || (c == '&') || (c == '#') || (c == ';') || ((c == '-') && (this.acceptHyphens.booleanValue()));
/*    */   }
/*    */ }

/* Location:           /Users/kalow007/ojibwe_solr/
 * Qualified Name:     edu.umn.dls.ojibwe.OjibweTokenizer
 * JD-Core Version:    0.6.2
 */