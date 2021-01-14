package dev.oleg.factors;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class FactorsJunit5Test {

  @ParameterizedTest
  @MethodSource("data")
  public void testAll(final int n, final List<Integer> expected) {
    assertIterableEquals(expected, new Factors().findFor(n));
  }

  static Stream<Arguments> data() {
    return Stream.of(
        of(0, List.of()),
        of(2, List.of(2)),
        of(4, List.of(2, 2)),
        of(8, List.of(2, 2, 2)),
        of(10, List.of(2, 5)),
        of(180, List.of(2, 2, 3, 3, 5)),
        of(7919, List.of(7919))
    );
  }
}
