import james.joyce.Finnegan;

/**
 * A simple test of Finnegan. Not intended to be copied into your source code, just meant to test behavior.
 */
public class FinneganTest {
    public static void main(String[] args)
    {
        Finnegan fin = Finnegan.ENGLISH;
        fin.setSeed(0xbababadal);

        for (int i = 0; i < 40; i++) {
            System.out.println(fin.sentence(5, 10, new String[]{",", ",", ",", ";"},
                    new String[]{".", ".", ".", "!", "?", "..."}, 0.17));
        }
        fin = Finnegan.LOVECRAFT;
        for (int i = 0; i < 40; i++) {
            System.out.println(fin.sentence(3, 9, new String[]{",", ",", ";"},
                    new String[]{".", ".", "!", "!", "?", "...", "..."}, 0.15));
        }
        fin = Finnegan.GREEK_ROMANIZED;
        for (int i = 0; i < 40; i++) {
            System.out.println(fin.sentence(5, 11, new String[]{",", ",", ";"},
                    new String[]{".", ".", ".", "!", "?", "..."}, 0.2));
        }
        fin = Finnegan.GREEK_AUTHENTIC;
        for (int i = 0; i < 40; i++) {
            System.out.println(fin.sentence(5, 11, new String[]{",", ",", ";"},
                    new String[]{".", ".", ".", "!", "?", "..."}, 0.2));
        }
        fin = Finnegan.FRENCH;
        for (int i = 0; i < 40; i++) {
            System.out.println(fin.sentence(4, 12, new String[]{",", ",", ",", ";", ";"},
                    new String[]{".", ".", ".", "!", "?", "..."}, 0.17));
        }
        fin = Finnegan.RUSSIAN_ROMANIZED;
        for (int i = 0; i < 40; i++) {
            System.out.println(fin.sentence(6, 13, new String[]{",", ",", ",", ",", ";", " -"},
                    new String[]{".", ".", ".", "!", "?", "..."}, 0.25));
        }
        fin = Finnegan.RUSSIAN_AUTHENTIC;
        for (int i = 0; i < 40; i++) {
            System.out.println(fin.sentence(6, 13, new String[]{",", ",", ",", ",", ";", " -"},
                    new String[]{".", ".", ".", "!", "?", "..."}, 0.25));
        }

        fin = Finnegan.ENGLISH.mix(Finnegan.FRENCH, 0.5);
        for (int i = 0; i < 40; i++) {
            System.out.println(fin.sentence(5, 11, new String[]{",", ",", ";"},
                    new String[]{".", ".", "!", "?", "..."}, 0.18));
        }
        fin = Finnegan.RUSSIAN_ROMANIZED.mix(Finnegan.ENGLISH, 0.35);
        for (int i = 0; i < 40; i++) {
            System.out.println(fin.sentence(4, 10, new String[]{",", ",", ",", ",", ";", " -"},
                    new String[]{".", ".", ".", "!", "?", "..."}, 0.22));
        }
        fin = Finnegan.FRENCH.mix(Finnegan.GREEK_ROMANIZED, 0.55);
        for (int i = 0; i < 40; i++) {
            System.out.println(fin.sentence(6, 12, new String[]{",", ",", ",", ";"},
                    new String[]{".", ".", "!", "?", "..."}, 0.22));
        }
        fin = Finnegan.ENGLISH.mix(Finnegan.GREEK_AUTHENTIC, 0.25);
        for (int i = 0; i < 40; i++) {
            System.out.println(fin.sentence(5, 11, new String[]{",", ",", ";"},
                    new String[]{".", ".", "!", "?", "..."}, 0.18));
        }
        fin = Finnegan.ENGLISH.addAccents(0.5, 0.15);
        for (int i = 0; i < 40; i++) {
            System.out.println(fin.sentence(5, 12, new String[]{",", ",", ";"},
                    new String[]{".", ".", "!", "?", "..."}, 0.18));
        }

        System.out.println(Finnegan.ENGLISH.word(0xbababadal, false));

    }
}
