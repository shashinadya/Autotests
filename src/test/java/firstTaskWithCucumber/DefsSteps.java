package firstTaskWithCucumber;

import cucumber.api.java.ru.И;

public class DefsSteps {

    MainPage mainPage = new MainPage();

    @И("^настройка драйвера для браузера Chrome и инициализация драйвера$")
    public void propertiesOfDriver() {
        mainPage.propertiesOfDriver();
    }

    @И("^открыть сайт генератора паролей$")
    public void openPasswordsGeneratorSite() {
        mainPage.openPasswordsGeneratorSite();
    }

    @И("^нажать на кнопку \"Генерировать пароль\" для генерации пароля$")
    public void pushTheButtonForGeneratePassword() {
        mainPage.pushTheButtonForGeneratePassword();
    }

    @И("^получить значение сгенерированного пароля$")
    public void getPassword() {
        mainPage.getPassword();
    }

    @И("^проверить пароль на неравенство \"\"$")
    public void firstPasswordIsNotNullCheck() {
        mainPage.passwordIsNotNullCheck();
    }

    @И("^проверить, что пароль не равен предыдущему паролю$")
    public void secondPasswordIsNotEqualToTheFirstPassword() {
        mainPage.secondPasswordIsNotEqualToTheFirstPassword();
    }

    @И("^убрать галочку в чек-боксе \"Включить символы\"$")
    public void removeTheCheckboxWithSymbols() {
        mainPage.removeTheCheckboxWithSymbols();
    }

    @И("^выбрать в поле \"Длина пароля\" другое значение$")
    public void chooseOtherPasswordLength() {
        mainPage.chooseOtherPasswordLength();
    }

    @И("^проверить, что количество символов в пароле равно выбранному значению$")
    public void numberOfSymbolsInTheThirdPasswordCheck() {
        mainPage.numberOfSymbolsInTheThirdPasswordCheck();
    }

    @И("^закрытие окна браузера и прекращение работы драйвера$")
    public void closeBrowserWindowAndFinishWorkWithDriver() {
        mainPage.closeBrowserWindowAndFinishWorkWithDriver();
    }
}
