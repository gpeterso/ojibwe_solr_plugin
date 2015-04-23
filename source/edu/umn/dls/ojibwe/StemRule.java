package edu.umn.dls.ojibwe;

import java.text.MessageFormat;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StemRule
{
    public final Pattern pattern;
    public final String format;

    public static Set<String> apply(Collection<StemRule> rules, String word)
    {
        Set results = new HashSet();
        for (StemRule rule : rules) {
            String x = rule.apply(word);
            if (x != null)
            {
                results.add(x);
            }
        }
        return results;
    }

    public static Set<String> apply(Collection<StemRule> rules, Collection<String> words)
    {
        Set results = new HashSet();
        for (String word : words) {
            results.addAll(apply(rules, word));
        }
        return results;
    }

    public StemRule(Pattern pattern, String format)
    {
        this.pattern = pattern;
        this.format = format;
    }

    public StemRule(String regex, String format)
    {
        this.pattern = Pattern.compile(regex);
        this.format = format;
    }

    public String apply(String word)
    {
        Matcher matcher = this.pattern.matcher(word);
        if (matcher.matches())
        {
            Object[] groups = new Object[matcher.groupCount() + 1];
            for (int i = 0; i <= matcher.groupCount(); i++) {
                groups[i] = matcher.group(i);
            }
            return MessageFormat.format(this.format, groups);
        }
        return null;
    }
}
