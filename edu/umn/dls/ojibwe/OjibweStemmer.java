/*     */ package edu.umn.dls.ojibwe;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.TreeSet;
/*     */ 
/*     */ public class OjibweStemmer extends Stemmer
/*     */ {
/*     */   public static final String DEFAULT_RULES_FILE_NAME = "data/StemRules.xml";
/*  37 */   private Iterator<String> iterator = null;
/*     */   private final Map<String, List<StemRule>> rules;
/*     */   private TreeSet<String> stems;
/*     */ 
/*     */   Set<String> analyzeAsNouns(Set<String> wordSet)
/*     */   {
/*  43 */     Set results = new HashSet(wordSet);
/*     */ 
/*  48 */     Set tempWordSet = new HashSet();
/*  49 */     tempWordSet.addAll(StemRule.apply((Collection)this.rules.get("locativeRules"), wordSet));
/*  50 */     tempWordSet.addAll(StemRule.apply((Collection)this.rules.get("pluralAndObviativeRules"), wordSet));
/*  51 */     results.addAll(tempWordSet);
/*  52 */     results.addAll(StemRule.apply((Collection)this.rules.get("preteriteRules"), tempWordSet));
/*  53 */     results.addAll(StemRule.apply((Collection)this.rules.get("vocativeRules"), wordSet));
/*     */ 
/*  57 */     Set possessedWordSet = new HashSet();
/*  58 */     possessedWordSet.addAll(StemRule.apply((Collection)this.rules.get("1stPersonPrefixRules"), results));
/*     */ 
/*  60 */     possessedWordSet.addAll(StemRule.apply((Collection)this.rules.get("2ndPersonPrefixRules"), results));
/*     */ 
/*  62 */     possessedWordSet.addAll(StemRule.apply((Collection)this.rules.get("3rdPersonPrefixRules"), results));
/*     */ 
/*  64 */     results.addAll(possessedWordSet);
/*  65 */     results.addAll(StemRule.apply((Collection)this.rules.get("possesssorPluralRules"), possessedWordSet));
/*     */ 
/*  69 */     results.addAll(StemRule.apply((Collection)this.rules.get("pejorativeRules"), results));
/*     */ 
/*  71 */     results.addAll(StemRule.apply((Collection)this.rules.get("possesssorThemeRules"), results));
/*     */ 
/*  76 */     results.addAll(StemRule.apply((Collection)this.rules.get("pejorativeRules"), results));
/*     */ 
/*  80 */     Set wordSet2 = new HashSet();
/*  81 */     wordSet2.addAll(StemRule.apply((Collection)this.rules.get("diminutiveRules"), results));
/*  82 */     wordSet2.addAll(StemRule.apply((Collection)this.rules.get("contemptiveRules"), results));
/*  83 */     results.addAll(wordSet2);
/*     */ 
/*  86 */     results.addAll(StemRule.apply((Collection)this.rules.get("singularRules"), results));
/*     */ 
/*  88 */     return results;
/*     */   }
/*     */ 
/*     */   Set<String> analyzeAsVerbs(Set<String> wordSet)
/*     */   {
/*  93 */     Set results = new HashSet();
/*     */ 
/*  96 */     Set pronounWordSet = new HashSet(wordSet);
/*  97 */     pronounWordSet.addAll(StemRule.apply((Collection)this.rules.get("1stPersonPrefixRules"), wordSet));
/*     */ 
/*  99 */     pronounWordSet.addAll(StemRule.apply((Collection)this.rules.get("2ndPersonPrefixRules"), wordSet));
/*     */ 
/* 101 */     pronounWordSet.addAll(StemRule.apply((Collection)this.rules.get("3rdPersonPrefixRules"), wordSet));
/*     */ 
/* 103 */     pronounWordSet.addAll(StemRule.apply((Collection)this.rules.get("preverbRules"), pronounWordSet));
/*     */ 
/* 107 */     Set conjunctWordSet = new HashSet(wordSet);
/* 108 */     conjunctWordSet.addAll(StemRule.apply((Collection)this.rules.get("conjunctLengthRules"), wordSet));
/*     */ 
/* 112 */     results.addAll(StemRule.apply((Collection)this.rules.get("vaiIndependentRules"), pronounWordSet));
/*     */ 
/* 114 */     results.addAll(StemRule.apply((Collection)this.rules.get("vaiPreteriteRules"), pronounWordSet));
/*     */ 
/* 116 */     results.addAll(StemRule.apply((Collection)this.rules.get("vaiDubitativeRules"), pronounWordSet));
/*     */ 
/* 118 */     results.addAll(StemRule.apply((Collection)this.rules.get("vaiDubitativePreteriteRules"), pronounWordSet));
/*     */ 
/* 120 */     results.addAll(StemRule.apply((Collection)this.rules.get("vaiImperativeRules"), pronounWordSet));
/*     */ 
/* 122 */     results.addAll(StemRule.apply((Collection)this.rules.get("viiIndependentRules"), pronounWordSet));
/*     */ 
/* 124 */     results.addAll(StemRule.apply((Collection)this.rules.get("viiPreteriteRules"), pronounWordSet));
/*     */ 
/* 126 */     results.addAll(StemRule.apply((Collection)this.rules.get("viiDubitativeRules"), pronounWordSet));
/*     */ 
/* 128 */     results.addAll(StemRule.apply((Collection)this.rules.get("viiDubitativePreteriteRules"), pronounWordSet));
/*     */ 
/* 130 */     results.addAll(StemRule.apply((Collection)this.rules.get("vtaIndependentRules"), pronounWordSet));
/*     */ 
/* 132 */     results.addAll(StemRule.apply((Collection)this.rules.get("vtaPreteriteRules"), pronounWordSet));
/*     */ 
/* 134 */     results.addAll(StemRule.apply((Collection)this.rules.get("vtaDubitativeRules"), pronounWordSet));
/*     */ 
/* 136 */     results.addAll(StemRule.apply((Collection)this.rules.get("vtaDubitativePreteriteRules"), pronounWordSet));
/*     */ 
/* 138 */     results.addAll(StemRule.apply((Collection)this.rules.get("vtaImperativeRules"), pronounWordSet));
/*     */ 
/* 140 */     results.addAll(StemRule.apply((Collection)this.rules.get("vtiIndependentRules"), pronounWordSet));
/*     */ 
/* 142 */     results.addAll(StemRule.apply((Collection)this.rules.get("vtiImperativeRules"), pronounWordSet));
/*     */ 
/* 146 */     results.addAll(StemRule.apply((Collection)this.rules.get("vaiConjunctRules"), conjunctWordSet));
/*     */ 
/* 148 */     results.addAll(StemRule.apply((Collection)this.rules.get("vaiConjunctPreteriteRules"), conjunctWordSet));
/*     */ 
/* 150 */     results.addAll(StemRule.apply((Collection)this.rules.get("vaiConjunctDubitativeRules"), conjunctWordSet));
/*     */ 
/* 152 */     results.addAll(StemRule.apply((Collection)this.rules.get("vaiConjunctDubitativePreteriteRules"), conjunctWordSet));
/*     */ 
/* 154 */     results.addAll(StemRule.apply((Collection)this.rules.get("vaiIterativeRules"), conjunctWordSet));
/*     */ 
/* 156 */     results.addAll(StemRule.apply((Collection)this.rules.get("vaiParticipleRules"), conjunctWordSet));
/*     */ 
/* 158 */     results.addAll(StemRule.apply((Collection)this.rules.get("vaiParticiplePreteriteRules"), conjunctWordSet));
/*     */ 
/* 160 */     results.addAll(StemRule.apply((Collection)this.rules.get("vaiParticipleDubitativeRules"), conjunctWordSet));
/*     */ 
/* 162 */     results.addAll(StemRule.apply((Collection)this.rules.get("vaiParticipleDubitativePreteriteRules"), conjunctWordSet));
/*     */ 
/* 164 */     results.addAll(StemRule.apply((Collection)this.rules.get("viiConjunctRules"), conjunctWordSet));
/*     */ 
/* 166 */     results.addAll(StemRule.apply((Collection)this.rules.get("viiConjunctPreteriteRules"), conjunctWordSet));
/*     */ 
/* 168 */     results.addAll(StemRule.apply((Collection)this.rules.get("viiConjunctDubitativeRules"), conjunctWordSet));
/*     */ 
/* 170 */     results.addAll(StemRule.apply((Collection)this.rules.get("viiConjunctDubitativePreteriteRules"), conjunctWordSet));
/*     */ 
/* 172 */     results.addAll(StemRule.apply((Collection)this.rules.get("viiConjunctIterativeRules"), conjunctWordSet));
/*     */ 
/* 174 */     results.addAll(StemRule.apply((Collection)this.rules.get("viiParticipleRules"), conjunctWordSet));
/*     */ 
/* 176 */     results.addAll(StemRule.apply((Collection)this.rules.get("viiParticiplePreteriteRules"), conjunctWordSet));
/*     */ 
/* 178 */     results.addAll(StemRule.apply((Collection)this.rules.get("viiParticipleDubitativeRules"), conjunctWordSet));
/*     */ 
/* 180 */     results.addAll(StemRule.apply((Collection)this.rules.get("viiParticiplePreteriteDubitativeRules"), conjunctWordSet));
/*     */ 
/* 182 */     results.addAll(StemRule.apply((Collection)this.rules.get("vtaConjunctRules"), conjunctWordSet));
/*     */ 
/* 184 */     results.addAll(StemRule.apply((Collection)this.rules.get("vtaParticipleRules"), conjunctWordSet));
/*     */ 
/* 186 */     results.addAll(StemRule.apply((Collection)this.rules.get("vtiConjunctRules"), conjunctWordSet));
/*     */ 
/* 188 */     results.addAll(StemRule.apply((Collection)this.rules.get("vtiConjunctPreteriteRules"), conjunctWordSet));
/*     */ 
/* 190 */     results.addAll(StemRule.apply((Collection)this.rules.get("vtiConjunctParticipleRules"), conjunctWordSet));
/*     */ 
/* 193 */     return results;
/*     */   }
/*     */ 
/*     */   Set<String> analyze(Set<String> wordSet)
/*     */   {
/* 198 */     Set results = new HashSet(wordSet);
/*     */ 
/* 200 */     results.addAll(analyzeAsNouns(wordSet));
/* 201 */     results.addAll(analyzeAsVerbs(wordSet));
/*     */ 
/* 203 */     return results;
/*     */   }
/*     */ 
/*     */   public OjibweStemmer()
/*     */   {
/* 208 */     this(Collections.EMPTY_MAP);
/*     */   }
/*     */ 
/*     */   public OjibweStemmer(Map<String, List<StemRule>> rules)
/*     */   {
/* 213 */     if (rules.isEmpty()) {
/* 214 */       throw new IllegalArgumentException();
/*     */     }
/* 216 */     this.rules = rules;
/*     */   }
/*     */ 
/*     */   public boolean hasNext()
/*     */   {
/* 222 */     return (this.iterator != null) && (this.iterator.hasNext());
/*     */   }
/*     */ 
/*     */   public String next()
/*     */   {
/* 228 */     return (String)this.iterator.next();
/*     */   }
/*     */ 
/*     */   public void setToken(String token)
/*     */   {
/* 234 */     this.stems = new TreeSet();
/* 235 */     this.stems.add(token);
/* 236 */     this.stems.addAll(analyze(this.stems));
/* 237 */     this.iterator = this.stems.iterator();
/*     */   }
/*     */ 
/*     */   public Set<String> getStems()
/*     */   {
/* 242 */     return this.stems;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*     */   }
/*     */ }

/* Location:           /Users/kalow007/ojibwe_solr/
 * Qualified Name:     edu.umn.dls.ojibwe.OjibweStemmer
 * JD-Core Version:    0.6.2
 */