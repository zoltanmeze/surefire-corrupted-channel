package org.example;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JustHangingTests {

    private static final Logger logger = LoggerFactory.getLogger(JustHangingTests.class);

    /**
     * This test blocks surefire completely.
     *
     * <p>(N * 1024 - 1) 1-byte characters + single 4-byte unicode character.</p>
     *
     * <p>Same thing is happening with System.out.println</p>
     */
    @Test
    public void testThisWillOnlyHang() {
        String text = RandomStringUtils.randomAlphabetic(1 * 1024 - 1); // N * 1024 - 1
        String suffix = "\uD83D\uDE35"; // https://emojipedia.org/dizzy-face/

        logger.info("First text bytes length: {}", text.getBytes().length);
        logger.info("Second text bytes length: {}", suffix.getBytes().length);

        String joinedText = text + suffix;

        logger.info("{}", joinedText); // Same thing with sout
    }
}
