package dev.oleg.factors;

import java.util.ArrayList;
import java.util.List;

public class Factors {

  public List<Integer> findFor(final int n) {

    if (n <= 0) {
      return List.of();
    }

    final var highestFactor = (int) Math.sqrt(n);
    for (var f = 2; f <= highestFactor; ++f) {
      if (n % f == 0) {
        return combine(f, findFor(n / f));
      }
    }
    return List.of(n);
  }

  private List<Integer> combine(final int f, final List<Integer> list) {
    final var factors = new ArrayList<Integer>();
    factors.add(f);
    factors.addAll(list);
    return factors;
  }
}
