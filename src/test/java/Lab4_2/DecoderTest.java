package Lab4_2;

import org.example.Lab4_2.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DecoderTest {

    @Test
    public void testVowelsDecoder() {
        assertEquals("testing", Decoder.vowelsDecoder("t2st3ng"));
        assertEquals("zebra", Decoder.vowelsDecoder("z2br1"));
    }

    @Test
    public void testConsonantsDecoder() {
        assertEquals("testing", Decoder.consonantsDecoder("uftujoh"));
        assertEquals("banana", Decoder.consonantsDecoder("cbobob"));
        assertEquals("123", Decoder.consonantsDecoder("123"));
    }

    @Test
    public void testDecipher() {
        assertEquals("testing", Decoder.decipher("t2st3ng"));
        assertEquals("testing", Decoder.decipher("uftujoh"));
        assertEquals("123", Decoder.decipher("123"));
    }
}
