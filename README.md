# Finnegan
Java word/text generator with mixable language themes
> Thaw! The last word in stolentelling!

James Joyce, Finnegan's Wake

> bababadalgharaghtakamminarronnkonnbronntonnerronntuonnthunntrovarrhounawnskawntoohoohoordenenthurnuk!

James Joyce, Finnegan's Wake

Finnegan is a tiny library meant to generate gibberish text that imitates an existing language or style of word. It is one file in the public domain, and you are not meant to require dependency management to use it -- just copy it into your source tree and change the package!

Currently, there's several generators already usable with a simple API, and a somewhat more complicated API if you need to make one from scratch. Of particular note is the ability to easily combine existing generators into a pidgin language or hybrid of the two. You can also add accented vowels and/or consonants to an existing generator, or remove accented characters from any String. The predefined constants for generators are:
 - `ENGLISH`, which sometimes comes close to Dutch, but uses lots of uncommon English spellings like "-ought"
   - "Mont tiste frot; mousation hauddes?"
 - `FRENCH`, which uses accented characters too frequently for "real French", but does appear reasonably close
   - "Fa veau, ja ri avé re orçe jai braï aisté."
 - `LOVECRAFT`, which is meant to imitate things like the occult texts and names of Great Old Ones in H.P. Lovecraft's Cthulhu Mythos
   - "Zvrugg pialuk, ya'as irlemrugle'eith iposh hmo-es nyeighi, glikreirk shaivro'ei!"
 - `GREEK_ROMANIZED`, which imitates the Greek language but uses the Latin alphabet entirely; will generate the same sounds as GREEK_AUTHENTIC given the same seed
   - "Psuilas alor; aipeomarta le liaspa..."
 - `GREEK_AUTHENTIC`, which imitates the Greek language using the actual Greek alphabet; will generate the same sounds as GREEK_ROMANIZED given the same seed
   - "Ψυιλασ αλορ; αιπεομαρτα λε λιασπα..."
 - `RUSSIAN_ROMANIZED`, which imitates the Russian language but uses something like "Passport" romanization to the Latin alphabet; will generate the same sounds as RUSSIAN_AUTHENTIC given the same seed
   - "Zhydotuf ruts pitsas, gogutiar shyskuchebab - gichapofeglor giunuz ieskaziuzhin."
 - `RUSSIAN_AUTHENTIC`, which imitates the Russian language using the actual Cyrillic alphabet; will generate the same sounds as RUSSIAN_ROMANIZED given the same seed
   - "Жыдотуф руц пйцас, гогутяр шыскучэбаб - гйчапофёглор гюнуз ъсказюжин."

You can mix two generators using the `mix()` method:
```java
Finnegan newGenerator = Finnegan.RUSSIAN_ROMANIZED.mix(Finnegan.ENGLISH, 0.35);
// args are the other Finnegan and the portion of it to use
```
This produces a generator that is roughly 1/3 English-style and roughly 2/3 romanized Russian-style. Example text: "Ulyailsiamets, sazieskod eskatite aforyll giugleshynkor tieldodka thren - drat, kydoy."

You can make a generator that uses no accented characters start using them using the `addAccents()` method:
```java
Finnegan newGenerator = Finnegan.ENGLISH.addAccents(0.5, 0.15);
// args are the fraction of vowels to add accents to, then consonants
```
This produces a generator that looks like english but with roughly 50% of vowels with accents and 15% of consonants having some addition. Example text: "Filısm busæzzåtē thőy iornaifĭwıff; pĭbbarmî, frārrös knǻmîly..."

To remove accents from a String that may contain accents (if you are displaying it in a font that may only support ASCII, for example), then you can use `removeAccents()`, which I should credit to [hashable](http://stackoverflow.com/a/1215117), to strip most accents from the String and replace "á" with "a", for example.

You can use a generator with the `word()` or `sentence()` methods:
```java
Finnegan fin = Finnegan.ENGLISH;
System.out.println(fin.word(0xbababadal, false)); // seed for RNG, false for no capitalizing
// this prints:
// issisate
fin.sentence(0xbababadal, 5, 10, new String[]{",", ",", ",", ";"},
    new String[]{".", ".", ".", "!", "?", "..."}, 0.17)
// the args for that are the seed, minimum words, maximum words, the possible separators after words,
// the possible ends to the sentence, and the fractional chance of a word having a separator appended.
// this prints:
// Issisate treid nalyor preasici tretchy.
```
You can and often should omit the seed argument. Using the same seed for the same `sentence()` call will result in the same sentence, and a dozen identical sentences are usually not the goal. If you omit the seed, the internal seed will change with every call, changing the generated words and sentences; you can get the seed with `getSeed()` or even set it with `setSeed()`.
