package com.sams.membership.payout.batch.steps;

import static org.junit.Assert.assertEquals;

import org.jbehave.core.annotations.BeforeStories;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.sams.membership.payout.util.Step;

@Step
public class SumStep {
	private int a;
	private int b;
	private int sum;

	@BeforeStories
	public void before() {
		System.out.println("before");
		a = 0;
		b = 0;
		sum = 0;
	}

	@Given("Two number $a and $b")
	public void givenTwoNumbers(int a, int b) {
		this.a = a;
		this.b = b;
	}

	@When("I add them")
	public void whenAdd() {
		this.sum = this.a + this.b;
	}

	@Then("I can verify the sum is $sum")
	public void verifyResult(int sum) {
		assertEquals(this.sum, sum);
	}

}
