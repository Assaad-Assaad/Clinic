package be.ehb.clinic.model;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class NationalRegisterNumberValidator
        implements ConstraintValidator<NationalRegisterNumberConstraint, String> {


    @Override
    public void initialize(NationalRegisterNumberConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.length() != 11 || !value.matches("\\d{11}")) {
            return false;
        }

        // Extract the components
        String birthDatePart = value.substring(0, 6);
        String dayCounterPart = value.substring(6, 9);
        String checkNumberPart = value.substring(9, 11);

        int n;
        try {
            // Convert parts to integers
            int birthYear = Integer.parseInt(birthDatePart.substring(0, 2));
            int birthMonth = Integer.parseInt(birthDatePart.substring(2, 4));
            int birthDay = Integer.parseInt(birthDatePart.substring(4, 6));
            int dayCounter = Integer.parseInt(dayCounterPart);

            // Validate the birthdate
            if (!isValidDate(birthYear, birthMonth, birthDay)) {
                return false;
            }

            // Validate the day counter
            if (dayCounter < 1 || dayCounter > 998 || (dayCounter % 2 == 0 && dayCounter < 2)) {
                return false;
            }

            // Calculate the check number
            n = Integer.parseInt(value.substring(0, 9));
            if (birthYear >= 2000) {
                n += 2000000000;
            }

            int calculatedCheckNumber = 97 - (n % 97);
            int givenCheckNumber = Integer.parseInt(checkNumberPart);

            // Compare calculated and given check numbers
            return calculatedCheckNumber == givenCheckNumber;

        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isValidDate(int year, int month, int day) {
        try {
            if (month < 1 || month > 12 || day < 1 || day > 31) {
                return false;
            }
            // Add more precise checks for month-day validity (e.g., February)
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

