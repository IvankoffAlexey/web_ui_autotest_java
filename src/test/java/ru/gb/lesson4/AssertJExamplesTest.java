package ru.gb.lesson4;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertJExamplesTest {
    @Test
    void assertJExample() {
        assertThat(SqTriangle.isValid(0, 2, 3)).isTrue();
        assertThat(SqTriangle.isValid(1, 2, 3)).isTrue();
        assertThat(SqTriangle.isValid(2, 2, 3)).isFalse();
        List<String> strings = new ArrayList<>(Arrays.asList("test", "test1", "test2"));
        assertThat(strings).containsAnyOf("testz", "test2");
    }
}
