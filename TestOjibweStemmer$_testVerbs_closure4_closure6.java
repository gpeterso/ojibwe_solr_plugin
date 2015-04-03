/*     */ import groovy.lang.Closure;
/*     */ import groovy.lang.Reference;
/*     */ import org.codehaus.groovy.runtime.GStringImpl;
/*     */ import org.codehaus.groovy.runtime.GeneratedClosure;
/*     */ import org.codehaus.groovy.runtime.ScriptBytecodeAdapter;
/*     */ import org.codehaus.groovy.runtime.callsite.CallSite;
/*     */ import org.codehaus.groovy.runtime.typehandling.DefaultTypeTransformation;
/*     */ 
/*     */ class TestOjibweStemmer$_testVerbs_closure4_closure6 extends Closure
/*     */   implements GeneratedClosure
/*     */ {
/*     */   private Reference field;
/*     */ 
/*     */   public TestOjibweStemmer$_testVerbs_closure4_closure6(Object _outerInstance, Object _thisObject, Reference field)
/*     */   {
/*     */     super(_outerInstance, _thisObject);
/*     */     Reference tmp12_11 = field;
/*     */     this.field = ((Reference)tmp12_11);
/*     */     tmp12_11;
/*     */     while (true)
/*     */       return;
/*     */   }
/*     */ 
/*     */   public Object doCall(Object ???, Object arg2)
/*     */   {
/*  96 */     Object lemma = new Reference(???); Object fields = new Reference(???); CallSite[] arrayOfCallSite = $getCallSiteArray();
/*     */     Object tmp43_38 = arrayOfCallSite[0].call(fields.get(), "VSTEM"); ScriptBytecodeAdapter.setGroovyObjectProperty(tmp43_38, $get$$class$TestOjibweStemmer$_testVerbs_closure4_closure6(), this, "stem"); tmp43_38;
/*     */     Object tmp76_71 = arrayOfCallSite[1].call(fields.get(), this.field.get()); ScriptBytecodeAdapter.setGroovyObjectProperty(tmp76_71, $get$$class$TestOjibweStemmer$_testVerbs_closure4_closure6(), this, "word"); tmp76_71;
/*  98 */     while (ScriptBytecodeAdapter.compareEqual(arrayOfCallSite[3].callGroovyObjectGetProperty(this), null));
/*  98 */     if (DefaultTypeTransformation.booleanUnbox(ScriptBytecodeAdapter.compareEqual(arrayOfCallSite[2].callGroovyObjectGetProperty(this), null) ? Boolean.TRUE : Boolean.FALSE)) {
/*  99 */       arrayOfCallSite[4].callCurrent(this, new GStringImpl(new Object[] { this.field.get(), lemma.get(), arrayOfCallSite[5].callGroovyObjectGetProperty(this), arrayOfCallSite[6].callGroovyObjectGetProperty(this) }, new String[] { "****** ", ": NULL ", " / ", " / ", " ********" }));
/*     */     }
/*     */ 
/* 104 */     if ((!DefaultTypeTransformation.booleanUnbox(arrayOfCallSite[7].call(arrayOfCallSite[8].callGroovyObjectGetProperty(this))) ? 1 : 0) != 0);
/* 104 */     if (DefaultTypeTransformation.booleanUnbox((!DefaultTypeTransformation.booleanUnbox(arrayOfCallSite[9].call(arrayOfCallSite[10].callGroovyObjectGetProperty(this), "-")) ? 1 : 0) != 0 ? Boolean.TRUE : Boolean.FALSE));
/* 104 */     if (DefaultTypeTransformation.booleanUnbox((!DefaultTypeTransformation.booleanUnbox(arrayOfCallSite[11].call(arrayOfCallSite[12].callGroovyObjectGetProperty(this))) ? 1 : 0) != 0 ? Boolean.TRUE : Boolean.FALSE))
/*     */     {
/* 106 */       if (DefaultTypeTransformation.booleanUnbox(arrayOfCallSite[13].call(arrayOfCallSite[14].callGroovyObjectGetProperty(this), "gaawiin ")))
/*     */       {
/*     */         Object tmp434_429 = arrayOfCallSite[15].call(arrayOfCallSite[16].callGroovyObjectGetProperty(this), new Integer(8)); ScriptBytecodeAdapter.setGroovyObjectProperty(tmp434_429, $get$$class$TestOjibweStemmer$_testVerbs_closure4_closure6(), this, "word"); tmp434_429;
/*     */       }
/*     */ 
/* 110 */       arrayOfCallSite[17].call(arrayOfCallSite[18].callGroovyObjectGetProperty(this), arrayOfCallSite[19].callGroovyObjectGetProperty(this));
/* 111 */       if ((!DefaultTypeTransformation.booleanUnbox(arrayOfCallSite[20].call(arrayOfCallSite[21].call(arrayOfCallSite[22].callGroovyObjectGetProperty(this)), arrayOfCallSite[23].callGroovyObjectGetProperty(this))) ? 1 : 0) != 0)
/* 112 */         return arrayOfCallSite[24].callCurrent(this, arrayOfCallSite[25].call(arrayOfCallSite[26].call(arrayOfCallSite[27].call(arrayOfCallSite[28].call(lemma.get(), ": "), arrayOfCallSite[29].callGroovyObjectGetProperty(this)), " -> "), arrayOfCallSite[30].callGroovyObjectGetProperty(this))); else return null;  } for (goto 629; ; return null);
/*     */   }
/*     */ 
/*     */   public Object call(Object ???, Object arg2)
/*     */   {
/*     */     Object lemma = new Reference(???);
/*     */     Object fields = new Reference(???);
/*     */     CallSite[] arrayOfCallSite = $getCallSiteArray();
/*     */     while (true)
/*     */       return arrayOfCallSite[31].callCurrent(this, lemma.get(), fields.get());
/*     */   }
/*     */ 
/*     */   public Object getField()
/*     */   {
/*     */     CallSite[] arrayOfCallSite = $getCallSiteArray();
/*     */     while (true)
/*     */       return this.field.get();
/*     */   }
/*     */ 
/*     */   static
/*     */   {
/*     */     Class tmp12_9 = ((Class)ScriptBytecodeAdapter.castToType($get$$class$TestOjibweStemmer$_testVerbs_closure4_closure6(), $get$$class$java$lang$Class()));
/*     */     $ownClass = (Class)tmp12_9;
/*     */     tmp12_9;
/*     */     return;
/*     */     while (true)
/*     */       return;
/*     */   }
/*     */ }

/* Location:           /Users/kalow007/ojibwe_solr/
 * Qualified Name:     TestOjibweStemmer._testVerbs_closure4_closure6
 * JD-Core Version:    0.6.2
 */