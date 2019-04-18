/*-
 * #%L
 * Code Kata
 * %%
 * Copyright (C) 2019 Chrysocode
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */

package kata;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static testasyouthink.TestAsYouThink.givenSutClass;
import static testasyouthink.TestAsYouThink.resultOf;

class FizzBuzzTest {

    @Test
    void should_get_a_list_of_fizzbuzzified_numbers_given_1() {
        givenSutClass(FizzBuzz.class)
                .whenSutReturns(sut -> sut
                        .fizzbuzzify()
                        .until(1))
                .then(result -> {
                    assertThat(result)
                            .isInstanceOf(List.class)
                            .hasSize(1);
                });
    }

    @Test
    void should_get_fizzbuzzified_numbers_given_100_as_an_upper_bound() {
        givenSutClass(FizzBuzz.class)
                .whenSutReturns(sut -> sut
                        .fizzbuzzify()
                        .until(100))
                .then(result -> {
                    assertThat(result)
                            .hasSize(100)
                            .allMatch(fizzbuzzified -> fizzbuzzified.matches("^[1-9]{0,1}[0-9]|(Fizz|Buzz|FizzBuzz)$"));
                });
    }

    @Nested
    class Given_not_a_multiple {

        @Test
        void should_get_1_given_1() {
            resultOf(() -> new FizzBuzz().fizzbuzzify(1)).isEqualTo("1");
        }

        @Test
        void should_get_2_given_2() {
            resultOf(() -> new FizzBuzz().fizzbuzzify(2)).isEqualTo("2");
        }
    }

    @Nested
    class Given_a_multiple_of_3 {

        @Test
        void should_get_Fizz_given_3() {
            resultOf(() -> new FizzBuzz().fizzbuzzify(3)).isEqualTo("Fizz");
        }

        @Test
        void should_get_Fizz_given_6() {
            resultOf(() -> new FizzBuzz().fizzbuzzify(6)).isEqualTo("Fizz");
        }
    }

    @Nested
    class Given_a_multiple_of_5 {

        @Test
        void should_get_Buzz_given_5() {
            resultOf(() -> new FizzBuzz().fizzbuzzify(5)).isEqualTo("Buzz");
        }

        @Test
        void should_get_Buzz_given_10() {
            resultOf(() -> new FizzBuzz().fizzbuzzify(10)).isEqualTo("Buzz");
        }
    }

    @Nested
    class Given_a_multiple_of_3_and_5 {

        @Test
        void should_get_FizzBuzz_given_15() {
            resultOf(() -> new FizzBuzz().fizzbuzzify(15)).isEqualTo("FizzBuzz");
        }

        @Test
        void should_get_FizzBuzz_given_30() {
            resultOf(() -> new FizzBuzz().fizzbuzzify(30)).isEqualTo("FizzBuzz");
        }
    }
}
