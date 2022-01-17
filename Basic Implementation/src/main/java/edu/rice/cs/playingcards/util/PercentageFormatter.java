// Copyrights (c) 2021, Rice University.

package edu.rice.cs.playingcards.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * A utility class facilitating formatting of double values representing percentage (from 0 through
 * 100).
 *
 * @author aps@rice.edu, Alexei Stolboushkin
 */
public final class PercentageFormatter {
  private static final NumberFormat NF = DecimalFormat.getPercentInstance();

  static {
    NF.setMaximumFractionDigits(2);
    NF.setMinimumFractionDigits(2);
    NF.setMaximumIntegerDigits(3);
    NF.setMinimumIntegerDigits(1);
  }

  /**
   * Given a double value, formats it to string with exactly two decimal digits.
   */
  public static String format(double pct) {
    return NF.format(pct);
  }
}
