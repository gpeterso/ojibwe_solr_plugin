/*     */ package edu.umn.dls.ojibwe;
/*     */ 
/*     */ import java.text.MessageFormat;
/*     */ import java.util.Collection;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ 
/*     */ public class StemRule
/*     */ {
/*     */   public final Pattern pattern;
/*     */   public final String format;
/*     */ 
/*     */   public static Set<String> apply(Collection<StemRule> rules, String word)
/*     */   {
/*  52 */     Set results = new HashSet();
/*  53 */     for (StemRule rule : rules) {
/*  54 */       String x = rule.apply(word);
/*  55 */       if (x != null)
/*     */       {
/*  57 */         results.add(x);
/*     */       }
/*     */     }
/*  60 */     return results;
/*     */   }
/*     */ 
/*     */   public static Set<String> apply(Collection<StemRule> rules, Collection<String> words)
/*     */   {
/*  74 */     Set results = new HashSet();
/*  75 */     for (String word : words) {
/*  76 */       results.addAll(apply(rules, word));
/*     */     }
/*  78 */     return results;
/*     */   }
/*     */ 
/*     */   public StemRule(Pattern pattern, String format)
/*     */   {
/*  95 */     this.pattern = pattern;
/*  96 */     this.format = format;
/*     */   }
/*     */ 
/*     */   public StemRule(String regex, String format)
/*     */   {
/* 108 */     this.pattern = Pattern.compile(regex);
/* 109 */     this.format = format;
/*     */   }
/*     */ 
/*     */   public String apply(String word)
/*     */   {
/* 125 */     Matcher matcher = this.pattern.matcher(word);
/* 126 */     if (matcher.matches())
/*     */     {
/* 128 */       Object[] groups = new Object[matcher.groupCount() + 1];
/* 129 */       for (int i = 0; i <= matcher.groupCount(); i++) {
/* 130 */         groups[i] = matcher.group(i);
/*     */       }
/* 132 */       return MessageFormat.format(this.format, groups);
/*     */     }
/* 134 */     return null;
/*     */   }
/*     */ }

/* Location:           /Users/kalow007/ojibwe_solr/
 * Qualified Name:     edu.umn.dls.ojibwe.StemRule
 * JD-Core Version:    0.6.2
 */