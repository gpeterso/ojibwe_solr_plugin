/*    */ import groovy.lang.Closure;
/*    */ import groovy.lang.Reference;
/*    */ import org.codehaus.groovy.runtime.GStringImpl;
/*    */ import org.codehaus.groovy.runtime.GeneratedClosure;
/*    */ import org.codehaus.groovy.runtime.ScriptBytecodeAdapter;
/*    */ import org.codehaus.groovy.runtime.callsite.CallSite;
/*    */ import org.codehaus.groovy.runtime.typehandling.DefaultTypeTransformation;
/*    */ 
/*    */ class TestOjibweStemmer$_testNouns_closure3_closure5 extends Closure
/*    */   implements GeneratedClosure
/*    */ {
/*    */   private Reference field;
/*    */ 
/*    */   public TestOjibweStemmer$_testNouns_closure3_closure5(Object _outerInstance, Object _thisObject, Reference field)
/*    */   {
/*    */     super(_outerInstance, _thisObject);
/*    */     Reference tmp12_11 = field;
/*    */     this.field = ((Reference)tmp12_11);
/*    */     tmp12_11;
/*    */     while (true)
/*    */       return;
/*    */   }
/*    */ 
/*    */   public Object doCall(Object ???, Object arg2)
/*    */   {
/* 71 */     Object lemma = new Reference(???); Object fields = new Reference(???); CallSite[] arrayOfCallSite = $getCallSiteArray();
/*    */     Object tmp43_38 = arrayOfCallSite[0].call(fields.get(), "NSTEM"); ScriptBytecodeAdapter.setGroovyObjectProperty(tmp43_38, $get$$class$TestOjibweStemmer$_testNouns_closure3_closure5(), this, "stem"); tmp43_38;
/*    */ 
/* 73 */     if (DefaultTypeTransformation.booleanUnbox(arrayOfCallSite[1].call(arrayOfCallSite[2].callGroovyObjectGetProperty(this), "=")))
/*    */     {
/*    */       Object tmp113_108 = arrayOfCallSite[3].call(arrayOfCallSite[4].callGroovyObjectGetProperty(this), new Integer(1)); ScriptBytecodeAdapter.setGroovyObjectProperty(tmp113_108, $get$$class$TestOjibweStemmer$_testNouns_closure3_closure5(), this, "stem"); tmp113_108;
/*    */     }
/* 76 */     ScriptBytecodeAdapter.setGroovyObjectProperty(arrayOfCallSite[5].call(fields.get(), this.field.get()), $get$$class$TestOjibweStemmer$_testNouns_closure3_closure5(), this, "word");
/* 77 */     while (ScriptBytecodeAdapter.compareEqual(arrayOfCallSite[7].callGroovyObjectGetProperty(this), null));
/* 77 */     if (DefaultTypeTransformation.booleanUnbox(ScriptBytecodeAdapter.compareEqual(arrayOfCallSite[6].callGroovyObjectGetProperty(this), null) ? Boolean.TRUE : Boolean.FALSE)) {
/* 78 */       arrayOfCallSite[8].callCurrent(this, new GStringImpl(new Object[] { this.field.get(), lemma.get(), arrayOfCallSite[9].callGroovyObjectGetProperty(this), arrayOfCallSite[10].callGroovyObjectGetProperty(this) }, new String[] { "****** ", ": NULL ", " / ", " / ", " ********" }));
/*    */     }
/* 80 */     if ((!DefaultTypeTransformation.booleanUnbox(arrayOfCallSite[11].call(arrayOfCallSite[12].callGroovyObjectGetProperty(this))) ? 1 : 0) != 0);
/* 80 */     if (DefaultTypeTransformation.booleanUnbox((!DefaultTypeTransformation.booleanUnbox(arrayOfCallSite[13].call(arrayOfCallSite[14].callGroovyObjectGetProperty(this))) ? 1 : 0) != 0 ? Boolean.TRUE : Boolean.FALSE)) {
/* 81 */       arrayOfCallSite[15].call(arrayOfCallSite[16].callGroovyObjectGetProperty(this), arrayOfCallSite[17].callGroovyObjectGetProperty(this));
/* 82 */       if ((!DefaultTypeTransformation.booleanUnbox(arrayOfCallSite[18].call(arrayOfCallSite[19].call(arrayOfCallSite[20].callGroovyObjectGetProperty(this)), arrayOfCallSite[21].callGroovyObjectGetProperty(this))) ? 1 : 0) != 0)
/* 83 */         return arrayOfCallSite[22].callCurrent(this, arrayOfCallSite[23].call(arrayOfCallSite[24].call(arrayOfCallSite[25].call(arrayOfCallSite[26].call(lemma.get(), ": "), arrayOfCallSite[27].callGroovyObjectGetProperty(this)), " -> "), arrayOfCallSite[28].callGroovyObjectGetProperty(this))); else return null;  } for (goto 577; ; return null);
/*    */   }
/*    */ 
/*    */   public Object call(Object ???, Object arg2)
/*    */   {
/*    */     Object lemma = new Reference(???);
/*    */     Object fields = new Reference(???);
/*    */     CallSite[] arrayOfCallSite = $getCallSiteArray();
/*    */     while (true)
/*    */       return arrayOfCallSite[29].callCurrent(this, lemma.get(), fields.get());
/*    */   }
/*    */ 
/*    */   public Object getField()
/*    */   {
/*    */     CallSite[] arrayOfCallSite = $getCallSiteArray();
/*    */     while (true)
/*    */       return this.field.get();
/*    */   }
/*    */ 
/*    */   static
/*    */   {
/*    */     Class tmp12_9 = ((Class)ScriptBytecodeAdapter.castToType($get$$class$TestOjibweStemmer$_testNouns_closure3_closure5(), $get$$class$java$lang$Class()));
/*    */     $ownClass = (Class)tmp12_9;
/*    */     tmp12_9;
/*    */     return;
/*    */     while (true)
/*    */       return;
/*    */   }
/*    */ }

/* Location:           /Users/kalow007/ojibwe_solr/
 * Qualified Name:     TestOjibweStemmer._testNouns_closure3_closure5
 * JD-Core Version:    0.6.2
 */