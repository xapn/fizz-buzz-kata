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

import org.junit.jupiter.api.Test;

import static java.lang.String.valueOf;
import static testasyouthink.TestAsYouThink.resultOf;

class FizzBuzzTest {

    String fizzbuzzify(int number) {
        if (number % 3 == 0 && number % 5 == 0) {
            return "Fizz" + "Buzz";
        } else if (number % 3 == 0) {
            return "Fizz";
        } else if (number % 5 == 0) {
            return "Buzz";
        } else {
            return valueOf(number);
        }
    }

    @Test
    void should_get_1_given_1() {
        resultOf(() -> fizzbuzzify(1)).isEqualTo("1");
    }

    @Test
    void should_get_2_given_2() {
        resultOf(() -> fizzbuzzify(2)).isEqualTo("2");
    }

    @Test
    void should_get_Fizz_given_3() {
        resultOf(() -> fizzbuzzify(3)).isEqualTo("Fizz");
    }

    @Test
    void should_get_Buzz_given_5() {
        resultOf(() -> fizzbuzzify(5)).isEqualTo("Buzz");
    }

    @Test
    void should_get_Fizz_given_6() {
        resultOf(() -> fizzbuzzify(6)).isEqualTo("Fizz");
    }

    @Test
    void should_get_Buzz_given_10() {
        resultOf(() -> fizzbuzzify(10)).isEqualTo("Buzz");
    }

    @Test
    void should_get_FizzBuzz_given_15() {
        resultOf(() -> fizzbuzzify(15)).isEqualTo("FizzBuzz");
    }

    @Test
    void should_get_FizzBuzz_given_30() {
        resultOf(() -> fizzbuzzify(30)).isEqualTo("FizzBuzz");
    }
}
