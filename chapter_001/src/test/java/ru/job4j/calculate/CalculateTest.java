package ru.job4j.calculate;

/**
 * Test.
 *
 * @author Roman.Markov
 * @version 1
 * @since 08.03.2019
 */
 public class CalculateTest {
  /**
 * Test echo.
 */

	@Test
	 public void whenTakeNameThenThreeEchoPlusName() {
	    String input = "qwerty";
	    String expect = "Echo, echo, echo : qwerty"; 
	    Calculate calc = new Calculate();
	    String result = calc.echo(input);
	    assertThat(result, is(expect));
	 }
}