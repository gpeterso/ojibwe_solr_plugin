package edu.umn.dls.ojibwe;

import java.io.Reader;
import org.apache.lucene.analysis.CharTokenizer;

public class OjibweTokenizer extends CharTokenizer
{
    private Boolean acceptHyphens = Boolean.valueOf(true);

    public OjibweTokenizer(Reader reader)
    {
        this(reader, Boolean.valueOf(false));
    }

    public OjibweTokenizer(Reader reader, Boolean acceptHyphens)
    {
        super(reader);
        this.acceptHyphens = acceptHyphens;
    }

    protected boolean isTokenChar(char c)
    {
        return (('a' <= c) && (c <= 'z')) || (('A' <= c) && (c <= 'Z')) || (('0' <= c) && (c <= '9')) || (c == '\'') || (c == '&') || (c == '#') || (c == ';') || ((c == '-') && (this.acceptHyphens.booleanValue()));
    }
}
