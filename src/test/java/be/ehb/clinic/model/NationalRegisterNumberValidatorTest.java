//package be.ehb.clinic.model;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//
//class NationalRegisterNumberValidatorTest {
//
//    static NationalRegisterNumberValidator validator;
//
//    @BeforeEach
//    void setUp() {
//        validator = new NationalRegisterNumberValidator();
//    }
//
//    @Test
//    void givenValidNationalRegisterNumber() {
//        String s = "90031139126";
//        boolean valid = validator.isValid(s, null);
//        assertTrue(valid);
//    }
//
//    @Test
//    void givenInvalidNationalRegisterNumber() {
//        String s = "90031139122";
//        boolean valid = validator.isValid(s, null);
//        assertFalse(valid);
//    }
//
//    @Test
//    void givenNullNationalRegisterNumber() {
//        String s = "";
//        boolean valid = validator.isValid(s, null);
//        assertFalse(valid);
//    }
//}