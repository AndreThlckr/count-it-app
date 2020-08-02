package com.andrethlckr.countit

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

/**
 * Example of a unit test.
 *
 * Use the @TestInstance(TestInstance.Lifecycle.PER_CLASS) annotation on every test, or change the
 * default JUnit lifecycle in junit-platform.properties.
 *
 * See best practices in (https://phauer.com/2018/best-practices-unit-testing-kotlin/).
 */
class ExampleUnitTest {
    /**
     * Instantiate your fields as immutable, non-nullable vals.
     *
     * Use .apply {} for more complex instantiations.
     *
     * Avoid using vars, lateinit fields and etcetera.
     */
    private val fieldExample = String().apply {
        this.capitalize()
    }

    /**
     * If the instantiation is too complex or confusing, use the init block.
     */
    init {}

    /**
     * Use @BeforeEach annotation for reseting mocks and values if necessary.
     */
    @BeforeEach
    fun resetFields() {}

    /**
     * Use the given/when/then format, each one separated by one empty line.
     * Add the "actual" and "expected" prefixes to tested values.
     *
     * If needed, use parameterized tests to avoid repeating test logic for different values.
     * @MethodSource is especially useful alongside Kotlin data classes.
     */
    @Test
    fun `method should return something`() {
        // Given this data

        // When this occurs

        // Then assert the result
    }

    @Nested
    inner class FunctionalityTestGroupExample {
        @Test
        fun `should return that`() {}
        @Test
        fun `should do this`() {}
        @Test
        fun `should show error if`() {}
    }


}