package net.thebeardfamily.shack.model.domain.zigbee;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

/**
 * Tests for the {@link SerialNumber}.
 */
public class SerialNumberTest {

    @Test
    public void testGetHigh() throws Exception {
        SerialNumber instance = new SerialNumber(0x2012201320142015L);
        assertThat(instance.getUpper(), is(equalTo(0x20122013)));
    }

    @Test
    public void testGetLow() throws Exception {
        SerialNumber instance = new SerialNumber(0x2012201320142015L);
        assertThat(instance.getLower(), is(equalTo(0x20142015)));
    }

    @Test
    public void testEquals() throws Exception {
        SerialNumber instance1 = new SerialNumber(0xCAFEBABEL);
        SerialNumber instance2 = new SerialNumber(0xCAFEBABEL);
        SerialNumber instance3 = new SerialNumber(0xDEADBEEFL);
        assertThat("instance1.equals(instance2)", instance1, is(equalTo(instance2)));
        assertThat("instance2.equals(instance1)", instance2, is(equalTo(instance1)));
        assertThat("!instance1.equals(instance3)", instance1, is(not(equalTo(instance3))));
        assertThat("!instance3.equals(instance1)", instance3, is(not(equalTo(instance1))));
    }

    @Test
    public void testHashCode() throws Exception {
        SerialNumber instance1 = new SerialNumber(0xCAFEBABEL);
        SerialNumber instance2 = new SerialNumber(0xCAFEBABEL);
        SerialNumber instance3 = new SerialNumber(0xDEADBEEFL);
        assertThat("instance1.hashCode() == instance2.hashCode()",
                   instance1.hashCode(), is(equalTo(instance2.hashCode())));
        assertThat("instance1.hashCode() != instance3.hashCode()",
                   instance1.hashCode(), is(not(equalTo(instance3.hashCode()))));
    }

    @Test
    public void testToString() throws Exception {
        SerialNumber instance = new SerialNumber(0xCAFEBABEDEADBEEFL);
        assertThat(instance.toString(), is(equalTo("0xCAFEBABE 0xDEADBEEF")));
    }
}