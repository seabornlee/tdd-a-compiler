package scanner.detector;

import org.junit.jupiter.api.Test;
import scanner.detector.ValueDetector;

import static org.fest.assertions.api.Assertions.assertThat;

class ValueDetectorTest {

    @Test
    void should_detect_string_value() {
        assertThat(new ValueDetector().match("\"sum =%d\n\"")).isTrue();
    }
}