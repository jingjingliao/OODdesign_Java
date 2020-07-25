//package finalCheatSheet;
//
//public class EqualsHashcodeToString {
//  @Override
//  public boolean equals(Object o) {
//    if (this == o) return true;
//    if (o == null || getClass() != o.getClass()) return false;
//    Book book = (Book) o;
//    return getPublicationYear() == book.getPublicationYear() &&
//        Objects.equals(getAuthor(), book.getAuthor()) &&
//        Objects.equals(getTitle(), book.getTitle());
//  }
//
//  @Override
//  public int hashCode() {
//    return Objects.hash(getAuthor(), getTitle(), getPublicationYear(), getPublisher(), getISBN());
//  }
//
//  @Test
//  public void testEquality() {
//    assertTrue(charge.equals(charge));
//    assertFalse(charge.equals(null));
//    assertTrue(charge.equals(sameCharge));
//    assertFalse(charge.equals(diffCharge));
//  }
//
//  assertTrue(pwCustom.equals(pwCustom));
//  assertTrue(!pwCustom.equals(null));
//  assertTrue(!pwCustom.equals("pwCustom"));
//  assertTrue(pwCustom.equals(new Password(3, 10, 1, 1, 1)));
//  assertTrue(!pwCustom.equals(new Password(2, 10, 1, 1, 1)));
//
//  @Test
//  public void testHashcode() {
//    assertTrue(charge.hashCode() == sameCharge.hashCode());
//  }
