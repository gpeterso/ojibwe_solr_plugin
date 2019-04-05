package edu.umn.dls.ojibwe;

import java.io.Reader;
import org.apache.lucene.analysis.util.CharTokenizer;

public class OjibweTokenizer extends CharTokenizer
{
    private Boolean acceptHyphens = Boolean.valueOf(true);

    public OjibweTokenizer()
    {
        this(Boolean.valueOf(false));
    }

    public OjibweTokenizer(Boolean acceptHyphens)
    {
        super();
        this.acceptHyphens = acceptHyphens;
    }

    protected boolean isTokenChar(int c)
    {
        return (('a' <= c) && (c <= 'z')) || (('A' <= c) && (c <= 'Z')) || (('0' <= c) && (c <= '9')) || (c == '\'') || (c == '&') || (c == '#') || (c == ';') || ((c == '-') && (this.acceptHyphens.booleanValue()));
    }
}
