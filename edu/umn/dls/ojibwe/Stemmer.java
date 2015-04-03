/*    */ package edu.umn.dls.ojibwe;
/*    */ 
/*    */ import java.util.NoSuchElementException;
/*    */ 
/*    */ public class Stemmer
/*    */ {
/* 21 */   private String token = null;
/*    */ 
/*    */   public boolean hasNext()
/*    */   {
/* 32 */     return this.token != null;
/*    */   }
/*    */ 
/*    */   public String next()
/*    */   {
/* 43 */     String value = this.token;
/* 44 */     this.token = null;
/* 45 */     if (value == null) {
/* 46 */       throw new NoSuchElementException();
/*    */     }
/* 48 */     return value;
/*    */   }
/*    */ 
/*    */   public void setToken(String token)
/*    */   {
/* 60 */     this.token = token;
/*    */   }
/*    */ }

/* Location:           /Users/kalow007/ojibwe_solr/
 * Qualified Name:     edu.umn.dls.ojibwe.Stemmer
 * JD-Core Version:    0.6.2
 */