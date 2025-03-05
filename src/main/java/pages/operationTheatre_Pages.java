package pages;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class operationTheatre_Pages extends StartupPage {
	
//	Locators for TC-1 
	By usernameTextbox = By.xpath("//input[@id='username_id']");
	By passwordTextbox = By.xpath("//input[@id='password']");
	By signInButton = By.xpath("//button[@id='login']");
	By registeredPatientTextElement = By.xpath("//p[contains(text(), 'Registered Patient')]");
//	Locators for TC-2
	By operationTheatreModule = By.xpath("//span[.='OperationTheatre']");
	By hospitalNumberByElement = By.xpath("//span[contains(text(), 'Hospital Number')]");
//	Locators for TC-3
	By newOtButtonByElement = By.xpath("//button[contains(text(), 'New OT Booking')]");
	By bookingOTScheduleFormsTitleNameByElement = By.xpath("//span[contains(text(), 'Booking OT Schedule  | New Patient')]");
//	Locators for TC-4
	By selectpatientTextboxElement = By.xpath("//input[@id='srch_PatientList']");
	By diagnosisTextboxElement = By.xpath("//input[@id='Diagnosis']");
	By surgeryTypeTextboxElement = By.xpath("//textarea[@id='surgeryType']");
//	Locators for TC-5
	By remarksTextAreaByElement = By.xpath("//textarea[@id='remarks']");
//	Locators for TC-6
	By remarkTextboxElement = By.xpath("//textarea[@placeholder='Remarks']");
	By surgenNameTextFieldElement = By.xpath("//input[@id='id_input_currentRequestedByDoctor_selectReferral']");
	By surgenNameFirstButtonElement = By.xpath("//ul[@class='select-list']//li[1]");
//	Locators for TC-7
	By externalCheckBoxElement = By.xpath("//label[@class='is-ref mt-checkbox mt-checkbox-outline']//span");
//	Locators for TC-8	
	By plusIconButtonElement = By.xpath("//a[@class='btn blue btn-xs btn-ext']");
	By addButtonOfAddExternalReferralByElement = By.xpath("//button[contains(text(), 'Add')]");
	By errorMessageOfAddExternalReferralFormsByElement = By.xpath("//span[contains(text(), 'Referrer Name is required')]");
	
	String pageName = this.getClass().getSimpleName();
	public operationTheatre_Pages(WebDriver driver) {
		super(driver);
	}

	/**@Test1.1
	 * about this method loginTohealthAppByGivenValidCredetial() 
	 * @param : Map<String, String>
	 * @description : fill usernameTextbox & passwordTextbox and click on sign in button
	 * @return : Boolean
	 * @author : Yaksha
	 */
	public boolean loginToHealthAppByGivenValidCredetial(Map<String, String> expectedData) throws Exception {
		Boolean textIsDisplayed = false;
		try {
			WebElement usernametextFieldWebElement = commonEvents.findElement(usernameTextbox);
			commonEvents.highlightElement(usernametextFieldWebElement);
			commonEvents.sendKeys(usernameTextbox,expectedData.get("username"));

			WebElement passwordtextFieldWebElement = commonEvents.findElement(passwordTextbox);
			commonEvents.highlightElement(passwordtextFieldWebElement);
			commonEvents.sendKeys(passwordTextbox,expectedData.get("password"));

			WebElement signinButtonWebElement = commonEvents.findElement(signInButton);
			commonEvents.highlightElement(signinButtonWebElement);
			commonEvents.click(signInButton);

			if(commonEvents.isDisplayed(registeredPatientTextElement))
			{   
				WebElement registeredPatientTextWebElement = commonEvents.findElement(registeredPatientTextElement);
				commonEvents.highlightElement(registeredPatientTextWebElement);
				textIsDisplayed=true;
			}
		}catch(Exception e) {
			throw e;
		}
		return textIsDisplayed;
	}

	/**@Test1.2
	 * about this method verifyTitleOfThePage() 
	 * @param : null
	 * @description : it will navigate to the URL and validate the title of the current page.
	 * @return : String
	 * @author : YAKSHA
	 */
	public String verifyTitleOfThePage() throws Exception {
		String pageTitle = "";
		try {
			pageTitle = commonEvents.getTitle();
			System.out.println("title of the page is  :" + pageTitle );
		}catch(Exception e) {
			throw e;
		}	
		return pageTitle;
	}

	/**@Test1.3
	 * about this method verifyURLOfThePage() 
	 * @param : null
	 * @description : it will navigate to the URL and validate the URL of the current page.
	 * @return : String
	 * @author : YAKSHA
	 */
	public String verifyURLOfThePage() throws Exception {
		String urlofThepage = "";
		try {
			urlofThepage = commonEvents.getCurrentUrl();
			System.out.println("URL of the page is  :" + urlofThepage );
		}catch(Exception e) {
			throw e;
		}	
		return urlofThepage;
	}

	/**@Test2
	 * about this method verifyOperationTheatreModuleIsPresentAndGoToOperationTheatreTab() 
	 * @param : null
	 * @description : Verify that OperationTheatre module is present and Go to OperationTheatre Tab.
	 * @return : String
	 * @author : YAKSHA
	 */
	public String goToOperationTheatreModuleVerifyTableHeaderName() throws Exception {
		String tableHeaderNameIsDisplayed = "";
		try {
			if(commonEvents.isDisplayed(operationTheatreModule)){
				commonEvents.click(operationTheatreModule);
				Thread.sleep(3000);
			}

			if(commonEvents.isDisplayed(hospitalNumberByElement)) {
				tableHeaderNameIsDisplayed = commonEvents.getText(hospitalNumberByElement);

				System.out.println("table header name is : " + tableHeaderNameIsDisplayed);
				return tableHeaderNameIsDisplayed;
			}

		}catch(Exception e) {
			throw e;
		}	
		return tableHeaderNameIsDisplayed;
	}


	/**@Test3
	 * about this method verifyBookingOTScheduleFormByClickingOnNewOTBookingButton() 
	 * @param : null
	 * @description : verify the button & text 
	 * @return : String
	 * @author : YAKSHA
	 */
	public String verifyBookingOTScheduleFormByClickingOnNewOTBookingButton() throws Exception {
		String bookingOTScheduleFormsName = "";
		try {
			commonEvents.click(newOtButtonByElement);
			Thread.sleep(2000);
			bookingOTScheduleFormsName = commonEvents.getText(bookingOTScheduleFormsTitleNameByElement);
			System.out.println("booking OT Schedule Form's Title Name" + bookingOTScheduleFormsName );
		}catch(Exception e) {
			throw e;
		}	
		return bookingOTScheduleFormsName;
	}

	/**@Test4
	 * about this method verifyTexboxIsPresentAndValidateEnteredValue() 
	 * @param : null
	 * @description : verify text box , then send value to that text box and validate the entered value
	 * @return : String
	 * @author : YAKSHA
	 */
	public String verifyTexboxIsPresentAndValidateEnteredValue(Map<String, String> expectedData) throws Exception {

		String selectPatientTextboxValue = "";
		try {
			if(commonEvents.isDisplayed(bookingOTScheduleFormsTitleNameByElement)) {
				commonEvents.sendKeys(selectpatientTextboxElement, expectedData.get("patientName"));
				commonEvents.sendKeys(diagnosisTextboxElement, expectedData.get("diagnosisValue"));
				commonEvents.sendKeys(surgeryTypeTextboxElement, expectedData.get("surgeryTypeValue"));

				selectPatientTextboxValue = commonEvents.getAttribute(selectpatientTextboxElement, "value");
				System.out.println("attribute value of select patient Textbox : " + selectPatientTextboxValue );
			}
		}catch(Exception e) {
			throw e;
		}	
		return selectPatientTextboxValue;
	}

	/**@Test5
	 * about this method verifyPlaceholderNameOfTexboxIfTextboxIsEnabled() 
	 * @param : null
	 * @description : verify the placeholder name of text box if text box is enabled
	 * @return : String
	 * @author : YAKSHA
	 */
	public String verifyPlaceholderNameOfTexboxIfTextboxIsEnabled() throws Exception {
		String placeholderNameOfRemarkasTextarea = "";
		try {
			if(commonEvents.isDisplayed(remarksTextAreaByElement) &&
					commonEvents.isEnabled(remarksTextAreaByElement)) {
				commonEvents.click(remarksTextAreaByElement);
				Thread.sleep(2000);
				placeholderNameOfRemarkasTextarea = commonEvents.getAttribute(remarksTextAreaByElement, "placeholder");
				System.out.println("booking OT Schedule Form's Title Name" + placeholderNameOfRemarkasTextarea );
				return placeholderNameOfRemarkasTextarea;
			}
		}catch(Exception e) {
			throw e;
		}	
		return placeholderNameOfRemarkasTextarea;
	}

	/**@Test6
	 * about this method verifyButtonIsPresentAfterSendValueToSurgenNameTextfield() 
	 * @param : null
	 * @description : verify the button is present after send the value to the text box
	 * @return : String
	 * @author : YAKSHA
	 */
	public String verifyButtonIsPresentAfterSendValueToSurgenNameTextfield(Map<String, String> expectedData) throws Exception {
		String surgenNameButtonAttributeValue = "";
		try {
			if(commonEvents.isDisplayed(surgenNameTextFieldElement)) {
				commonEvents.sendKeys(surgenNameTextFieldElement, expectedData.get("surgenNameValue1"));
				commonEvents.sendKeys(surgenNameTextFieldElement, Keys.ENTER);
				Thread.sleep(2000);
				commonEvents.click(remarkTextboxElement);
				Thread.sleep(2000);
				commonEvents.isDisplayed(surgenNameFirstButtonElement);
				surgenNameButtonAttributeValue = commonEvents.getText(surgenNameFirstButtonElement);
				System.out.println("attribute value of surgen Name : " + surgenNameButtonAttributeValue );
			}
		}catch(Exception e) {
			throw e;
		}	
		return surgenNameButtonAttributeValue;
	}

	/**@Test7
	 * about this method verifyPlusButtonIsPresentAfterClickOnExternalCheckbox() 
	 * @param : null
	 * @description : click on check box and verify check box is selected or not and verify the + (plus) icon after click on check box
	 * @return : Boolean
	 * @author : YAKSHA
	 */
	public Boolean verifyPlusButtonIsPresentAfterClickOnExternalCheckbox() throws Exception {
		boolean plusIconIsDisplayed = false;
		try {
			commonEvents.isDisplayed(externalCheckBoxElement);
			commonEvents.click(externalCheckBoxElement);
			Thread.sleep(3000);

			commonEvents.isSelected(externalCheckBoxElement);
			commonEvents.isDisplayed(plusIconButtonElement);
			plusIconIsDisplayed = true;

		}catch(Exception e) {
			throw e;
		}	
		return plusIconIsDisplayed;
	}

	/**@Test8
	 * about this method verifyErrorMessageInAddExternalReferralForms() 
	 * @param : null
	 * @description : verify the error message
	 * @return : String
	 * @author : YAKSHA
	 */
	public String verifyErrorMessageInAddExternalReferralForms() throws Exception {
		String errorMessageOfAddExternalReferralForms = "";
		try {
			if(commonEvents.isDisplayed(plusIconButtonElement)) {
				commonEvents.click(plusIconButtonElement);
				Thread.sleep(2000);
				commonEvents.click(addButtonOfAddExternalReferralByElement);
				Thread.sleep(2000);
				commonEvents.isDisplayed(errorMessageOfAddExternalReferralFormsByElement);
				errorMessageOfAddExternalReferralForms = commonEvents.getText(errorMessageOfAddExternalReferralFormsByElement);
				System.out.println("error Message Of Add External Referral Forms : " + errorMessageOfAddExternalReferralForms );
				return errorMessageOfAddExternalReferralForms;
			}
		}catch(Exception e) {
			throw e;
		}
		return errorMessageOfAddExternalReferralForms;
	}



}
