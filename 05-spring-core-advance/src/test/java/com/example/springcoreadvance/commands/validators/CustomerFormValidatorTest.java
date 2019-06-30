package com.example.springcoreadvance.commands.validators;

import org.junit.Before;
import org.junit.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.springcoreadvance.commands.CustomerForm;

public class CustomerFormValidatorTest {

    private Validator validator;
    private CustomerForm customerForm;
    private Errors errors;

    @Before
    public void setup() {
        validator = new CustomerFormValidator();
        customerForm = new CustomerForm();
        errors = new BeanPropertyBindingResult(customerForm, "customerForm");
    }

    @Test
    public void testNoErrors() {
        customerForm.setPasswordText("password");
        customerForm.setPasswordTextConf("password");

        validator.validate(customerForm, errors);

        assert errors.hasErrors() == false;
    }

    @Test
    public void testHasErrors() {
        customerForm.setPasswordText("password");
        customerForm.setPasswordTextConf("asdf");

        validator.validate(customerForm, errors);

        assert errors.hasErrors();
    }
}