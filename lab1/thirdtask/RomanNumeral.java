package thirdtask;

public class RomanNumeral {

  private final int arabic;
  private final String roman;

  public RomanNumeral(String input) {
    roman = input.toUpperCase();
    if (!checkIfValidRoman(roman)) {
      throw new NumberFormatException("Illegal Roman Numeral");
    }
    arabic = toArabic(roman);
  }

  public int getArabic() {
    return arabic;
  }

  public String getRoman() {
    return roman;
  }

  private int toArabic(String number) {
    if (number.isEmpty()) return 0;
    if (number.startsWith("M"))
      return 1000 + toArabic(number.substring(1, number.length()));
    if (number.startsWith("CM"))
      return 900 + toArabic(number.substring(2, number.length()));
    if (number.startsWith("D"))
      return 500 + toArabic(number.substring(1, number.length()));
    if (number.startsWith("CD"))
      return 400 + toArabic(number.substring(2, number.length()));
    if (number.startsWith("C"))
      return 100 + toArabic(number.substring(1, number.length()));
    if (number.startsWith("XC"))
      return 90 + toArabic(number.substring(2, number.length()));
    if (number.startsWith("L"))
      return 50 + toArabic(number.substring(1, number.length()));
    if (number.startsWith("XL"))
      return 40 + toArabic(number.substring(2, number.length()));
    if (number.startsWith("X"))
      return 10 + toArabic(number.substring(1, number.length()));
    if (number.startsWith("IX"))
      return 9 + toArabic(number.substring(2, number.length()));
    if (number.startsWith("V"))
      return 5 + toArabic(number.substring(1, number.length()));
    if (number.startsWith("IV"))
      return 4 + toArabic(number.substring(2, number.length()));
    if (number.startsWith("I"))
      return 1 + toArabic(number.substring(1, number.length()));
    return 0;
  }

  private boolean checkIfValidRoman(String roman) {
    return roman.matches("M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})");
  }

}
