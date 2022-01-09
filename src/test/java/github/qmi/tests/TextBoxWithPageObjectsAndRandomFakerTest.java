package github.qmi.tests;

import github.qmi.page.Gender;
import github.qmi.page.Hobbies;
import github.qmi.page.RegistrationFormPage;
import org.junit.jupiter.api.Test;

import static github.qmi.page.Gender.MALE;
import static github.qmi.tests.TestData.*;

public class TextBoxWithPageObjectsAndRandomFakerTest extends TestBase {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @Test
    void TextBoxWithPageObjectsAndRandomFakerTest() {
        registrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .typeEmail(email)
                .selectGender(MALE)
                .typeNumber(userNumber);
        registrationFormPage.calendar.setDate(DAY, MONTH, YEAR);
        registrationFormPage.typeSubjects(SUBJECT)
                .selectHobbies(Hobbies.MUSIC)
                .uploadFile(FILE_NAME)
                .typeCurrentAddress(address)
                .selectState(STATE)
                .selectCity(CITY)
                .submitButton();

        registrationFormPage.checkModalForm("Student Name", firstName + " " + lastName)
                .checkModalForm("Student Email", email)
                .checkModalForm("Gender", Gender.MALE.name())
                .checkModalForm("Mobile", userNumber)
                .checkModalForm("Date of Birth", DAY + " " + MONTH + "," + YEAR)
                .checkModalForm("Subjects", SUBJECT)
                .checkModalForm("Hobbies", Hobbies.MUSIC.name())
                .checkModalForm("Picture", FILE_NAME)
                .checkModalForm("Address", address)
                .checkModalForm("State and City", STATE + " " + CITY);
    }
}

