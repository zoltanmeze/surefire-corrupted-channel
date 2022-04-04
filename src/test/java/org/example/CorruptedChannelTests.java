package org.example;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CorruptedChannelTests {

    private static final Logger logger = LoggerFactory.getLogger(CorruptedChannelTests.class);

    /**
     * <p>Corrupted channel by directly writing to native stream in forked JVM 1.</p>
     *
     * <p>(N * 1024 - 1) 1-byte characters + single 2-byte unicode character.</p>
     */
    @Test
    public void testCorruptedChannel() {
        String text = RandomStringUtils.randomAlphabetic(1 * 1024 - 1); // N * 1024 - 1
        String suffix = "Ő";

        logger.info("First text bytes length: {}", text.getBytes().length);
        logger.info("Second text bytes length: {}", suffix.getBytes().length);

        String joinedText = text + suffix;

        logger.info("{}", joinedText);
    }
}
