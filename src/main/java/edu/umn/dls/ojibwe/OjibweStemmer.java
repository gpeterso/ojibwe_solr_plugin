package edu.umn.dls.ojibwe;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class OjibweStemmer extends Stemmer
{
    public static final String DEFAULT_RULES_FILE_NAME = "data/StemRules.xml";
    private Iterator<String> iterator = null;
    private final Map<String, List<StemRule>> rules;
    private TreeSet<String> stems;

    Set<String> analyzeAsNouns(Set<String> wordSet)
    {
        Set results = new HashSet(wordSet);

        Set tempWordSet = new HashSet();
        tempWordSet.addAll(StemRule.apply((Collection)this.rules.get("locativeRules"), wordSet));
        tempWordSet.addAll(StemRule.apply((Collection)this.rules.get("pluralAndObviativeRules"), wordSet));
        results.addAll(tempWordSet);
        results.addAll(StemRule.apply((Collection)this.rules.get("preteriteRules"), tempWordSet));
        results.addAll(StemRule.apply((Collection)this.rules.get("vocativeRules"), wordSet));

        Set possessedWordSet = new HashSet();
        possessedWordSet.addAll(StemRule.apply((Collection)this.rules.get("1stPersonPrefixRules"), results));

        possessedWordSet.addAll(StemRule.apply((Collection)this.rules.get("2ndPersonPrefixRules"), results));

        possessedWordSet.addAll(StemRule.apply((Collection)this.rules.get("3rdPersonPrefixRules"), results));

        results.addAll(possessedWordSet);
        results.addAll(StemRule.apply((Collection)this.rules.get("possesssorPluralRules"), possessedWordSet));

        results.addAll(StemRule.apply((Collection)this.rules.get("pejorativeRules"), results));

        results.addAll(StemRule.apply((Collection)this.rules.get("possesssorThemeRules"), results));

        results.addAll(StemRule.apply((Collection)this.rules.get("pejorativeRules"), results));

        Set wordSet2 = new HashSet();
        wordSet2.addAll(StemRule.apply((Collection)this.rules.get("diminutiveRules"), results));
        wordSet2.addAll(StemRule.apply((Collection)this.rules.get("contemptiveRules"), results));
        results.addAll(wordSet2);

        results.addAll(StemRule.apply((Collection)this.rules.get("singularRules"), results));

        return results;
    }

    Set<String> analyzeAsVerbs(Set<String> wordSet)
    {
        Set results = new HashSet();

        Set pronounWordSet = new HashSet(wordSet);
        pronounWordSet.addAll(StemRule.apply((Collection)this.rules.get("1stPersonPrefixRules"), wordSet));

        pronounWordSet.addAll(StemRule.apply((Collection)this.rules.get("2ndPersonPrefixRules"), wordSet));

        pronounWordSet.addAll(StemRule.apply((Collection)this.rules.get("3rdPersonPrefixRules"), wordSet));

        pronounWordSet.addAll(StemRule.apply((Collection)this.rules.get("preverbRules"), pronounWordSet));

        Set conjunctWordSet = new HashSet(wordSet);
        conjunctWordSet.addAll(StemRule.apply((Collection)this.rules.get("conjunctLengthRules"), wordSet));

        results.addAll(StemRule.apply((Collection)this.rules.get("vaiIndependentRules"), pronounWordSet));

        results.addAll(StemRule.apply((Collection)this.rules.get("vaiPreteriteRules"), pronounWordSet));

        results.addAll(StemRule.apply((Collection)this.rules.get("vaiDubitativeRules"), pronounWordSet));

        results.addAll(StemRule.apply((Collection)this.rules.get("vaiDubitativePreteriteRules"), pronounWordSet));

        results.addAll(StemRule.apply((Collection)this.rules.get("vaiImperativeRules"), pronounWordSet));

        results.addAll(StemRule.apply((Collection)this.rules.get("viiIndependentRules"), pronounWordSet));

        results.addAll(StemRule.apply((Collection)this.rules.get("viiPreteriteRules"), pronounWordSet));

        results.addAll(StemRule.apply((Collection)this.rules.get("viiDubitativeRules"), pronounWordSet));

        results.addAll(StemRule.apply((Collection)this.rules.get("viiDubitativePreteriteRules"), pronounWordSet));

        results.addAll(StemRule.apply((Collection)this.rules.get("vtaIndependentRules"), pronounWordSet));

        results.addAll(StemRule.apply((Collection)this.rules.get("vtaPreteriteRules"), pronounWordSet));

        results.addAll(StemRule.apply((Collection)this.rules.get("vtaDubitativeRules"), pronounWordSet));

        results.addAll(StemRule.apply((Collection)this.rules.get("vtaDubitativePreteriteRules"), pronounWordSet));

        results.addAll(StemRule.apply((Collection)this.rules.get("vtaImperativeRules"), pronounWordSet));

        results.addAll(StemRule.apply((Collection)this.rules.get("vtiIndependentRules"), pronounWordSet));

        results.addAll(StemRule.apply((Collection)this.rules.get("vtiImperativeRules"), pronounWordSet));

        results.addAll(StemRule.apply((Collection)this.rules.get("vaiConjunctRules"), conjunctWordSet));

        results.addAll(StemRule.apply((Collection)this.rules.get("vaiConjunctPreteriteRules"), conjunctWordSet));

        results.addAll(StemRule.apply((Collection)this.rules.get("vaiConjunctDubitativeRules"), conjunctWordSet));

        results.addAll(StemRule.apply((Collection)this.rules.get("vaiConjunctDubitativePreteriteRules"), conjunctWordSet));

        results.addAll(StemRule.apply((Collection)this.rules.get("vaiIterativeRules"), conjunctWordSet));

        results.addAll(StemRule.apply((Collection)this.rules.get("vaiParticipleRules"), conjunctWordSet));

        results.addAll(StemRule.apply((Collection)this.rules.get("vaiParticiplePreteriteRules"), conjunctWordSet));

        results.addAll(StemRule.apply((Collection)this.rules.get("vaiParticipleDubitativeRules"), conjunctWordSet));

        results.addAll(StemRule.apply((Collection)this.rules.get("vaiParticipleDubitativePreteriteRules"), conjunctWordSet));

        results.addAll(StemRule.apply((Collection)this.rules.get("viiConjunctRules"), conjunctWordSet));

        results.addAll(StemRule.apply((Collection)this.rules.get("viiConjunctPreteriteRules"), conjunctWordSet));

        results.addAll(StemRule.apply((Collection)this.rules.get("viiConjunctDubitativeRules"), conjunctWordSet));

        results.addAll(StemRule.apply((Collection)this.rules.get("viiConjunctDubitativePreteriteRules"), conjunctWordSet));

        results.addAll(StemRule.apply((Collection)this.rules.get("viiConjunctIterativeRules"), conjunctWordSet));

        results.addAll(StemRule.apply((Collection)this.rules.get("viiParticipleRules"), conjunctWordSet));

        results.addAll(StemRule.apply((Collection)this.rules.get("viiParticiplePreteriteRules"), conjunctWordSet));

        results.addAll(StemRule.apply((Collection)this.rules.get("viiParticipleDubitativeRules"), conjunctWordSet));

        results.addAll(StemRule.apply((Collection)this.rules.get("viiParticiplePreteriteDubitativeRules"), conjunctWordSet));

        results.addAll(StemRule.apply((Collection)this.rules.get("vtaConjunctRules"), conjunctWordSet));

        results.addAll(StemRule.apply((Collection)this.rules.get("vtaParticipleRules"), conjunctWordSet));

        results.addAll(StemRule.apply((Collection)this.rules.get("vtiConjunctRules"), conjunctWordSet));

        results.addAll(StemRule.apply((Collection)this.rules.get("vtiConjunctPreteriteRules"), conjunctWordSet));

        results.addAll(StemRule.apply((Collection)this.rules.get("vtiConjunctParticipleRules"), conjunctWordSet));

        return results;
    }

    Set<String> analyze(Set<String> wordSet)
    {
        Set results = new HashSet(wordSet);

        results.addAll(analyzeAsNouns(wordSet));
        results.addAll(analyzeAsVerbs(wordSet));

        return results;
    }

    public OjibweStemmer()
    {
        this(Collections.EMPTY_MAP);
    }

    public OjibweStemmer(Map<String, List<StemRule>> rules)
    {
        if (rules.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.rules = rules;
    }

    public boolean hasNext()
    {
        return (this.iterator != null) && (this.iterator.hasNext());
    }

    public String next()
    {
        return (String)this.iterator.next();
    }

    public void setToken(String token)
    {
        this.stems = new TreeSet();
        this.stems.add(token);
        this.stems.addAll(analyze(this.stems));
        this.iterator = this.stems.iterator();
    }

    public Set<String> getStems()
    {
    return this.stems;
    }

    public static void main(String[] args)
    {
    }
}
