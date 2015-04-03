/*    */ import groovy.lang.Binding;
/*    */ import groovy.lang.Closure;
/*    */ import groovy.lang.Reference;
/*    */ import groovy.lang.Script;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import org.codehaus.groovy.runtime.GStringImpl;
/*    */ import org.codehaus.groovy.runtime.GeneratedClosure;
/*    */ import org.codehaus.groovy.runtime.ScriptBytecodeAdapter;
/*    */ import org.codehaus.groovy.runtime.callsite.CallSite;
/*    */ import org.codehaus.groovy.runtime.typehandling.DefaultTypeTransformation;
/*    */ 
/*    */ public class TestOjibweStemmer extends Script
/*    */ {
/*    */   public TestOjibweStemmer()
/*    */   {
/*    */     TestOjibweStemmer this;
/*    */     CallSite[] arrayOfCallSite = $getCallSiteArray();
/*    */     while (true)
/*    */       return;
/*    */   }
/*    */ 
/*    */   public TestOjibweStemmer(Binding arg1)
/*    */   {
/*    */     Binding context;
/*    */     CallSite[] arrayOfCallSite = $getCallSiteArray();
/*    */     ScriptBytecodeAdapter.invokeMethodOnSuperN($get$$class$groovy$lang$Script(), this, "setBinding", new Object[] { context });
/*    */     while (true)
/*    */       return;
/*    */   }
/*    */ 
/*    */   public static void main(String[] args)
/*    */   {
/*    */     CallSite[] arrayOfCallSite = $getCallSiteArray();
/*    */     arrayOfCallSite[0].call($get$$class$org$codehaus$groovy$runtime$InvokerHelper(), $get$$class$TestOjibweStemmer(), args);
/*    */     return;
/*    */     while (true)
/*    */       return;
/*    */   }
/*    */ 
/*    */   public Object run()
/*    */   {
/* 32 */     CallSite[] arrayOfCallSite = $getCallSiteArray();
/*    */     String tmp6_4 = "([^\",]*|\"((?:\"\"|[^\"])*)\"),"; ScriptBytecodeAdapter.setGroovyObjectProperty(tmp6_4, $get$$class$TestOjibweStemmer(), this, "CVS_FIELD_RX"); tmp6_4;
/*    */ 
/* 48 */     Object fileName = "data/WEBOJ5t1.csv";
/*    */     Object tmp42_37 = arrayOfCallSite[1].call(arrayOfCallSite[2].callConstructor($get$$class$java$io$File(), fileName)); ScriptBytecodeAdapter.setGroovyObjectProperty(tmp42_37, $get$$class$TestOjibweStemmer(), this, "lines"); tmp42_37;
/*    */     Object tmp85_80 = arrayOfCallSite[3].callCurrent(this, arrayOfCallSite[4].call(arrayOfCallSite[5].callGroovyObjectGetProperty(this), $const$0)); ScriptBytecodeAdapter.setGroovyObjectProperty(tmp85_80, $get$$class$TestOjibweStemmer(), this, "headers"); tmp85_80;
/*    */     Map tmp103_100 = ScriptBytecodeAdapter.createMap(new Object[0]); ScriptBytecodeAdapter.setGroovyObjectProperty(tmp103_100, $get$$class$TestOjibweStemmer(), this, "allItems"); tmp103_100;
/* 57 */     arrayOfCallSite[6].call(ScriptBytecodeAdapter.createRange($const$1, arrayOfCallSite[7].call(arrayOfCallSite[8].callGroovyObjectGetProperty(this)), false), new TestOjibweStemmer._run_closure1(this));
/*    */     Object tmp171_166 = arrayOfCallSite[9].callConstructor($get$$class$edu$umn$dls$ojibwe$OjibweStemmer()); ScriptBytecodeAdapter.setGroovyObjectProperty(tmp171_166, $get$$class$TestOjibweStemmer(), this, "stemmer"); tmp171_166;
/*    */ 
/* 119 */     arrayOfCallSite[10].callCurrent(this);
/*    */     while (true) return arrayOfCallSite[11].callCurrent(this);
/*    */   }
/*    */ 
/*    */   public Object zip(Object ???, Object arg2)
/*    */   {
/* 23 */     Object x = new Reference(???); Object y = new Reference(???); CallSite[] arrayOfCallSite = $getCallSiteArray();
/*    */     Map tmp33_30 = ScriptBytecodeAdapter.createMap(new Object[0]); ScriptBytecodeAdapter.setGroovyObjectProperty(tmp33_30, $get$$class$TestOjibweStemmer(), this, "map"); tmp33_30;
/* 24 */     arrayOfCallSite[12].call(ScriptBytecodeAdapter.createRange($const$0, arrayOfCallSite[13].call(x.get()), false), new TestOjibweStemmer._zip_closure2(this, y, x));
/*    */     while (true)
/*    */     {
/* 27 */       return arrayOfCallSite[14].callGroovyObjectGetProperty(this);
/*    */     }
/*    */   }
/*    */ 
/*    */   public Object parseCSV(Object line)
/*    */   {
/* 34 */     CallSite[] arrayOfCallSite = $getCallSiteArray(); (line = arrayOfCallSite[15].call(line, ","));
/*    */     List tmp26_23 = ScriptBytecodeAdapter.createList(new Object[0]); ScriptBytecodeAdapter.setGroovyObjectProperty(tmp26_23, $get$$class$TestOjibweStemmer(), this, "fieldList"); tmp26_23;
/*    */     Object tmp69_64 = arrayOfCallSite[16].call(arrayOfCallSite[17].call($get$$class$java$util$regex$Pattern(), arrayOfCallSite[18].callGroovyObjectGetProperty(this)), line); ScriptBytecodeAdapter.setGroovyObjectProperty(tmp69_64, $get$$class$TestOjibweStemmer(), this, "matcher"); tmp69_64;
/* 37 */     while (DefaultTypeTransformation.booleanUnbox(arrayOfCallSite[19].call(arrayOfCallSite[20].callGroovyObjectGetProperty(this)))) {
/* 38 */       if (ScriptBytecodeAdapter.compareNotEqual(arrayOfCallSite[21].call(arrayOfCallSite[22].callGroovyObjectGetProperty(this), $const$2), null))
/* 39 */         arrayOfCallSite[23].call(arrayOfCallSite[24].callGroovyObjectGetProperty(this), arrayOfCallSite[25].call(arrayOfCallSite[26].call(arrayOfCallSite[27].callGroovyObjectGetProperty(this), $const$2), "\"\"", "\""));
/*    */       else
/* 41 */         arrayOfCallSite[28].call(arrayOfCallSite[29].callGroovyObjectGetProperty(this), arrayOfCallSite[30].call(arrayOfCallSite[31].callGroovyObjectGetProperty(this), $const$1));
/*    */     }
/*    */     while (true)
/* 44 */       return arrayOfCallSite[32].callGroovyObjectGetProperty(this);  } 
/* 68 */   public Object testNouns() { for (CallSite[] arrayOfCallSite = $getCallSiteArray(); ; return arrayOfCallSite[33].call(ScriptBytecodeAdapter.createList(new Object[] { "NPLUR", "NLOCA", "NDIMI", "N1POS", "N1POS2", "N1POS3", "N2POS", "N3POS" }), new TestOjibweStemmer._testNouns_closure3(this))); } 
/* 91 */   public Object testVerbs() { for (CallSite[] arrayOfCallSite = $getCallSiteArray(); ; return arrayOfCallSite[34].call(ScriptBytecodeAdapter.createList(new Object[] { "V1SIN", "V1SIN2", "V1SIN3", "V3SIN", "V3SINNG", "V3SINNG2", "V3SCO", "V3SPA", "V0SINNG", "V0SCO", "V0SPA" }), new TestOjibweStemmer._testVerbs_closure4(this))); } 
/*    */   static { void tmp10_7 = new Long(0L);
/*    */     __timeStamp__239_neverHappen1315343972370 = (Long)tmp10_7;
/*    */     tmp10_7;
/*    */     void tmp28_25 = new Long(1315343972370L);
/*    */     __timeStamp = (Long)tmp28_25;
/*    */     tmp28_25;
/*    */     void tmp45_42 = new Integer(2);
/*    */     $const$2 = (Integer)tmp45_42;
/*    */     tmp45_42;
/*    */     void tmp62_59 = new Integer(1);
/*    */     $const$1 = (Integer)tmp62_59;
/*    */     tmp62_59;
/*    */     void tmp79_76 = new Integer(0);
/*    */     $const$0 = (Integer)tmp79_76;
/*    */     tmp79_76;
/*    */     Class tmp99_96 = ((Class)ScriptBytecodeAdapter.castToType($get$$class$TestOjibweStemmer(), $get$$class$java$lang$Class()));
/*    */     $ownClass = (Class)tmp99_96;
/*    */     tmp99_96;
/*    */     return;
/*    */     while (true) return;  } 
/*    */   class _run_closure1 extends Closure implements GeneratedClosure { public _run_closure1(Object _thisObject) { super(_thisObject);
/*    */       while (true) return;  } 
/* 58 */     public Object doCall(Object ???) { Object n = new Reference(???); CallSite[] arrayOfCallSite = $getCallSiteArray();
/*    */       Object tmp47_42 = arrayOfCallSite[0].callCurrent(this, arrayOfCallSite[1].call(arrayOfCallSite[2].callGroovyObjectGetProperty(this), n.get())); ScriptBytecodeAdapter.setGroovyObjectProperty(tmp47_42, $get$$class$TestOjibweStemmer$_run_closure1(), this, "fields"); tmp47_42;
/*    */       Object tmp86_81 = arrayOfCallSite[3].call(arrayOfCallSite[4].callGroovyObjectGetProperty(this), new Integer(1)); ScriptBytecodeAdapter.setGroovyObjectProperty(tmp86_81, $get$$class$TestOjibweStemmer$_run_closure1(), this, "lemma"); tmp86_81;
/* 60 */       if (!ScriptBytecodeAdapter.compareEqual(arrayOfCallSite[5].callGetProperty(arrayOfCallSite[6].callGroovyObjectGetProperty(this)), arrayOfCallSite[7].callGetProperty(arrayOfCallSite[8].callGroovyObjectGetProperty(this)))) ScriptBytecodeAdapter.assertFailed("(fields.size == headers.size)", arrayOfCallSite[9].call(arrayOfCallSite[10].call(arrayOfCallSite[11].call(arrayOfCallSite[12].call(arrayOfCallSite[13].callGroovyObjectGetProperty(this), arrayOfCallSite[14].callGetProperty(arrayOfCallSite[15].callGroovyObjectGetProperty(this))), " fields, "), arrayOfCallSite[16].callGetProperty(arrayOfCallSite[17].callGroovyObjectGetProperty(this))), " headers")); Object localObject1 = arrayOfCallSite[21].callCurrent(this, arrayOfCallSite[22].callGroovyObjectGetProperty(this), arrayOfCallSite[23].callGroovyObjectGetProperty(this)); for (arrayOfCallSite[18].call(arrayOfCallSite[19].callGroovyObjectGetProperty(this), arrayOfCallSite[20].callGroovyObjectGetProperty(this), localObject1); ; return localObject1); } 
/*    */     static { Class tmp12_9 = ((Class)ScriptBytecodeAdapter.castToType($get$$class$TestOjibweStemmer$_run_closure1(), $get$$class$java$lang$Class()));
/*    */       $ownClass = (Class)tmp12_9;
/*    */       tmp12_9;
/*    */       return;
/*    */       while (true) return;  }  } 
/*    */   class _zip_closure2 extends Closure implements GeneratedClosure { private Reference y;
/*    */     private Reference x;
/*    */ 
/*    */     public _zip_closure2(Object _thisObject, Reference y, Reference x) { super(_thisObject);
/*    */       Reference tmp12_11 = y;
/*    */       this.y = ((Reference)tmp12_11);
/*    */       tmp12_11;
/*    */       Reference tmp24_22 = x;
/*    */       this.x = ((Reference)tmp24_22);
/*    */       tmp24_22;
/*    */       while (true) return;  } 
/* 25 */     public Object doCall(Object ???) { Object n = new Reference(???); CallSite[] arrayOfCallSite = $getCallSiteArray(); Object localObject1 = arrayOfCallSite[3].call(this.y.get(), n.get()); for (arrayOfCallSite[0].call(arrayOfCallSite[1].callGroovyObjectGetProperty(this), arrayOfCallSite[2].call(this.x.get(), n.get()), localObject1); ; return localObject1); } 
/*    */     public Object getY() { CallSite[] arrayOfCallSite = $getCallSiteArray();
/*    */       while (true) return this.y.get();  } 
/*    */     public Object getX() { CallSite[] arrayOfCallSite = $getCallSiteArray();
/*    */       while (true) return this.x.get();  } 
/*    */     static { Class tmp12_9 = ((Class)ScriptBytecodeAdapter.castToType($get$$class$TestOjibweStemmer$_zip_closure2(), $get$$class$java$lang$Class()));
/*    */       $ownClass = (Class)tmp12_9;
/*    */       tmp12_9;
/*    */       return;
/*    */       while (true) return;  }  } 
/*    */   class _testNouns_closure3 extends Closure implements GeneratedClosure { public _testNouns_closure3(Object _thisObject) { super(_thisObject);
/*    */       while (true) return;  } 
/* 69 */     public Object doCall(Object ???) { Object field = new Reference(???); CallSite[] arrayOfCallSite = $getCallSiteArray(); arrayOfCallSite[0].callCurrent(this, arrayOfCallSite[1].call(arrayOfCallSite[2].call("--------- ", field.get()), " ---------"));
/*    */       while (true) return arrayOfCallSite[3].call(arrayOfCallSite[4].callGroovyObjectGetProperty(this), new TestOjibweStemmer._testNouns_closure3_closure5(this, getThisObject(), field));  } 
/*    */     static
/*    */     {
/*    */       Class tmp12_9 = ((Class)ScriptBytecodeAdapter.castToType($get$$class$TestOjibweStemmer$_testNouns_closure3(), $get$$class$java$lang$Class()));
/*    */       $ownClass = (Class)tmp12_9;
/*    */       tmp12_9;
/*    */       return;
/*    */       while (true)
/*    */         return;
/*    */     } }
/*    */ 
/*    */   class _testVerbs_closure4 extends Closure implements GeneratedClosure
/*    */   {
/*    */     public _testVerbs_closure4(Object _thisObject)
/*    */     {
/*    */       super(_thisObject);
/*    */       while (true)
/*    */         return;
/*    */     }
/*    */ 
/*    */     public Object doCall(Object ???) {
/* 94 */       Object field = new Reference(???); CallSite[] arrayOfCallSite = $getCallSiteArray(); arrayOfCallSite[0].callCurrent(this, new GStringImpl(new Object[] { field.get() }, new String[] { "--------- ", " ---------" }));
/*    */       while (true) return arrayOfCallSite[1].call(arrayOfCallSite[2].callGroovyObjectGetProperty(this), new TestOjibweStemmer._testVerbs_closure4_closure6(this, getThisObject(), field));
/*    */     }
/*    */ 
/*    */     static
/*    */     {
/*    */       Class tmp12_9 = ((Class)ScriptBytecodeAdapter.castToType($get$$class$TestOjibweStemmer$_testVerbs_closure4(), $get$$class$java$lang$Class()));
/*    */       $ownClass = (Class)tmp12_9;
/*    */       tmp12_9;
/*    */       return;
/*    */       while (true)
/*    */         return;
/*    */     }
/*    */   }
/*    */ }

/* Location:           /Users/kalow007/ojibwe_solr/
 * Qualified Name:     TestOjibweStemmer
 * JD-Core Version:    0.6.2
 */