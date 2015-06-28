package net.thebeardfamily.shack.model.domain.zigbee.zcl;

import org.junit.Test;

import static net.thebeardfamily.shack.model.domain.zigbee.zcl.FrameType.CLUSTER;
import static net.thebeardfamily.shack.model.domain.zigbee.zcl.FrameType.PROFILE;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Tests for the {@link FrameType} class.
 */
public class FrameTypeTest {

    @Test
    public void testFromControlValue() throws Exception {
        assertThat("0x00", FrameType.fromControlValue((byte)0x00),is(equalTo(PROFILE)));
        assertThat("0x01", FrameType.fromControlValue((byte)0x01),is(equalTo(PROFILE)));
        assertThat("0x02", FrameType.fromControlValue((byte)0x02),is(equalTo(PROFILE)));
        assertThat("0x04", FrameType.fromControlValue((byte)0x04),is(equalTo(PROFILE)));
        assertThat("0x08", FrameType.fromControlValue((byte)0x08),is(equalTo(PROFILE)));
        assertThat("0x10", FrameType.fromControlValue((byte)0x10),is(equalTo(PROFILE)));
        assertThat("0x20", FrameType.fromControlValue((byte)0x20),is(equalTo(PROFILE)));

        assertThat("0x40", FrameType.fromControlValue((byte)0x40), is(equalTo(CLUSTER)));
        assertThat("0x60", FrameType.fromControlValue((byte)0x60), is(equalTo(CLUSTER)));
        assertThat("0x70", FrameType.fromControlValue((byte)0x70), is(equalTo(CLUSTER)));
        assertThat("0x78", FrameType.fromControlValue((byte)0x78), is(equalTo(CLUSTER)));
        assertThat("0x7C", FrameType.fromControlValue((byte)0x7C), is(equalTo(CLUSTER)));
        assertThat("0x7E", FrameType.fromControlValue((byte)0x7E), is(equalTo(CLUSTER)));
        assertThat("0x7F", FrameType.fromControlValue((byte)0x7F), is(equalTo(CLUSTER)));
    }

    @Test
    public void testToString() throws Exception {
        assertThat(FrameType.fromControlValue((byte) 0x00),hasToString("PROFILE"));
        assertThat(FrameType.fromControlValue((byte) 0x40),hasToString("CLUSTER"));
        assertThat(FrameType.fromControlValue((byte) 0x80),hasToString("RESERVED"));
        assertThat(FrameType.fromControlValue((byte) 0xC0),hasToString("RESERVED"));
    }
}