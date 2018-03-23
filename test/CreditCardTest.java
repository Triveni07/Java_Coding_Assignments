package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import challenge.CreditCard;


import static org.junit.Assert.assertEquals;

class CreditCardTest {
	
	    @Test
	    public void shouldMaskDigitsForBasicCreditCards() {
	        assertEquals("5###########0694", CreditCard.maskify("5512103073210694"));
	    }

	    @Test
	    public void shouldNotMaskDigitsForShortCreditCards() {
	        assertEquals("54321", CreditCard.maskify("54321"));
	    }
	    
	    @Test
	    public void shouldNotMaskNonDigitsCreditCards() {
	        assertEquals("Skippyyy", CreditCard.maskify("Skippyyy"));
	        assertEquals("7###-####-####-4521", CreditCard.maskify("7234-5632-7896-4521"));
	    }
	    @Test
	    public void shouldHandleBlankCreditCards() {
	        assertEquals("", CreditCard.maskify(""));
	    }

	}
