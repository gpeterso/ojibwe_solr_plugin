package edu.umn.dls.ojibwe;

import java.util.NoSuchElementException;

public class Stemmer {
  private String token = null;

  public boolean hasNext() {
    return this.token != null;
  }

  public String next() {
    String value = this.token;
    this.token = null;
    if (value == null) {
      throw new NoSuchElementException();
    }
    return value;
  }

  public void setToken(String token) {
    this.token = token;
  }
}
