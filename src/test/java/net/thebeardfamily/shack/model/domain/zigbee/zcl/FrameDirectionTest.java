package net.thebeardfamily.shack.model.domain.zigbee.zcl;

import org.hamcrest.Matchers;
import org.junit.Test;

import static net.thebeardfamily.shack.model.domain.zigbee.zcl.FrameDirection.CLIENT_TO_SERVER;
import static net.thebeardfamily.shack.model.domain.zigbee.zcl.FrameDirection.SERVER_TO_CLIENT;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Tests for the {@link FrameDirection}.
 */
public class FrameDirectionTest {

    @Test
    public void testGetControlValue() throws Exception {
        assertThat("CLIENT_TO_SERVER", CLIENT_TO_SERVER.getControlValue(), is(equalTo((byte)0x00)));
        assertThat("SERVER_TO_CLIENT", SERVER_TO_CLIENT.getControlValue(), is(equalTo((byte)0x10)));
    }

    @Test
    public void testFromControlValue() throws Exception {
        assertThat("0x00", FrameDirection.fromControlValue((byte)0x00),is(equalTo(CLIENT_TO_SERVER)));
        assertThat("0x01", FrameDirection.fromControlValue((byte)0x01),is(equalTo(CLIENT_TO_SERVER)));
        assertThat("0x02", FrameDirection.fromControlValue((byte)0x02),is(equalTo(CLIENT_TO_SERVER)));
        assertThat("0x04", FrameDirection.fromControlValue((byte)0x04),is(equalTo(CLIENT_TO_SERVER)));
        assertThat("0x08", FrameDirection.fromControlValue((byte)0x08),is(equalTo(CLIENT_TO_SERVER)));
        assertThat("0x10", FrameDirection.fromControlValue((byte)0x10),is(equalTo(SERVER_TO_CLIENT)));
        assertThat("0x20", FrameDirection.fromControlValue((byte)0x20),is(equalTo(CLIENT_TO_SERVER)));
        assertThat("0x40", FrameDirection.fromControlValue((byte)0x40),is(equalTo(CLIENT_TO_SERVER)));
        assertThat("0x80", FrameDirection.fromControlValue((byte)0x80),is(equalTo(CLIENT_TO_SERVER)));
    }
}