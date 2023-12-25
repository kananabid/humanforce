package humanforce.test.elements;

import org.openqa.selenium.By;

public class UserStoryPOM {
    public static By usernameInput = By.id("UserName");
    public static By passwordInput = By.id("Password");
    public static By yesBtn = By.id("yesButton");
    public static By logoHumanforce = By.xpath("//img[@src='/logo.svg']");
    public static By timeAndAttendanceImg = By.className("aspect-[4/3]");
    public static By continueHereBtn = By.xpath("//*[text()='Continue here']");
    public static By addNewRecordBtn = By.xpath("//*[text()='Add new record']");
    public static By saveBtn = By.xpath("//*[text()='Save']");
    public static By helpfulResources = By.xpath("//*[text()='Helpful resources']");
    public static By welcomePopUpClose = By.cssSelector("div[class='wm-close-button walkme-x-button']");
    public static By actualBenefitsArticle = By.className("o-container");
    public static By dashboardElement = By.xpath("//*[text()='Overview']");
    public static By helloName = By.cssSelector("span[class='home-header__info__name']");
    public static By hfAcademy = By.cssSelector("div[class='walkme-icon-image-div walkme-launcher-image-div']");
    public static By announceModel = By.cssSelector("div[class='announcekit-booster-modal-header']");
    public static By hfAcademyPopUp = By.id("walkme-menu");
    public static By questionInput = By.xpath("(//input[@type='search'])[1]");
    public static By personalResultTitle = By.cssSelector("div[title='How do I view or update my details?']");
    public static By employeeBtn = By.id("Employee");
    public static By popupCloseBtn = By.cssSelector("div[title='Close']");
    public static By logOutBtn = By.id("MenuFooter_Logout");
    public static By logInBtn = By.id("btnSubmit");
    public static By userInfodatapopUp = By.xpath("(//div[@data-role='draggable'])[3]");
    public static By nameInput = By.id("Name");
    public static By shortNameInput = By.id("ShortName");
    public static By exportCodeInput = By.id("ExportCode");
    public static By itemsText = By.cssSelector("span[class='k-pager-info k-label']");

}
