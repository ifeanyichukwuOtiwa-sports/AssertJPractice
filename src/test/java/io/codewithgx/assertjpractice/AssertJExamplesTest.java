package io.codewithgx.assertjpractice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by @author Ifeanyichukwu Otiwa
 * 25/07/2022
 */

public class AssertJExamplesTest {

    // tests for the list
    @DisplayName("Tests for the List")
    @Nested
    class ListTests {

        private List<Integer> list;

        @BeforeEach
        public void setup() {
            list = Arrays.asList(5, 2, 4);
        }

        @Test
        @DisplayName("List should have an intial size of 3")
        void ensureInitialSize() {
            assertThat(list).hasSize(3);
        }

        @Test
        @DisplayName("Check content of the array")
        void containsNumbersInAnyOrder() {
//            fail();
            assertThat(list).contains(5, 2, 4);
        }


        @Test
        void everyItemGreaterThan1() {
//            fail();
            assertThat(list).allMatch(this::greaterThan1);
        }

        private boolean greaterThan1(final Integer i) {
            return i > 1;
        }
    }

    @DisplayName("Tests for the array")
    @Nested
    class ArrayTests {
        private Integer[] ints;

        @BeforeEach
        public void setup() {
            ints = new Integer[] { 7, 5, 12, 16 };

        }

        @Test
        void arrayHasSizeOf4() {
            assertThat(ints).hasSize(4);
        }

        @Test
        void arrayContainsNumbersInGivenOrder() {
            //fail();
            assertThat(ints).containsExactly(7, 5, 12, 16);
        }
    }

    @DisplayName("Tests for the Task")
    @Nested
    class TaskTests {

        // class to be tested
        @Getter
        @Setter
        public class Task {

            private final long id;
            private String summary;
            private String description;
            private int year;

            public Task(long id, String summary, String description) {
                this.id = id;
                this.summary = summary;
                this.description = description;
            }

            // getters/setters
        }

        // tests for the Task
        @Test
        void objectHasSummaryProperty() {
            Task task = new Task(1, "Learn Hamcrest", "Important");
            //fail();
            assertThat(task).hasFieldOrProperty("summary");
        }

        @Test
        void objectHasCorrectSummaryValue() {
            Task task = new Task(1, "Learn Hamcrest", "Important");
//            fail();
            assertThat(task).hasFieldOrPropertyWithValue("summary", "Learn Hamcrest");
        }

        @Test
        void objectHasSameProperties() {
            Task todo1 = new Task(1, "Learn Hamcrest", "Important");
            Task todo2 = new Task(1, "Learn Hamcrest", "Important");
            //fail();

            assertThat(todo1).usingRecursiveComparison().isEqualTo(todo2);
        }
    }

    @DisplayName("Tests for String")
    @Nested
    class StringTests {
        // tests for string
        @Test
        void ensureThatAnEmptyStringIsEmpty() {
            String input = "";
            assertThat(input).isEmpty();
//            fail();
        }

        @Test
        void ensureThatAStringIsEitherNullOrEmpty() {
            String input = "";
            assertThat(input).isNullOrEmpty();
            //fail();
        }
    }
}
