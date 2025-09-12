package effectivejava.item14;


public class WordList {

    public static void main(String[] args) {

    }

    public static final class CaseInsensitiveString implements Comparable<CaseInsensitiveString> {

        private String s;

        public int compareTo(CaseInsensitiveString cis) {
            return String.CASE_INSENSITIVE_ORDER.compare(s, cis.s);
        }
    }
}
