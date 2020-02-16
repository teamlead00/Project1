package CRM.Locators;

import org.openqa.selenium.By;

public class DashboardRepo {

    public static By toaster = By.xpath("//div[@class='toast-message ng-star-inserted']");

    //DASHBOARD
    public static By caseTracker = By.xpath ("//*[@id='CompanyLogoImageHeaderComponent']");
    public static By totalMembers = By.xpath ("//h4[contains(text(),'Total S_Members')]");
    public static By totalCases = By.xpath ("//h4[contains(text(),'Total No. of Cases')]");

    //S_Compass
    public static By compass = By.xpath ("//div[@id='HCDatanameCompassSpan']");
    public static By documents = By.xpath ("//button[@id='HCBtnChildDataDocuments']");
    public static By documentList = By.xpath ("//button[@id='HCBtnChildDataDocument List']");
    public static By compassSummary = By.xpath ("//button[@id='HCBtnChildDataCompass Summary']");

    /* //Quotes
    public static By quotes = By.xpath ("//mat-toolbar[@class='mat-toolbar mat-primary mat-toolbar-single-row']//span[contains(text(),'Quotes')]");
    public static By brokersVault = By.xpath ("//button[@class='mat-menu-item ng-star-inserted']");
    */

    //S_Dashboard
    public static By dashboard = By.xpath ("//*[@id='HCDatanameDashboardLink']");
    public static By TCaddedStatus = By.xpath("(//*[@id='CBRElementCallBackStatus1'])[1]");
    public static By TCaddedMem = By.xpath("(//*[@id='CBRElementMemberName'])[1]");



    //S_Members
    public static By members = By.xpath ("//*[@id='HCDatanameMembersSpan']");
    //public static By members = By.xpath ("//mat-sidenav-content[@class='mat-drawer-content mat-sidenav-content']//div[4]//div[1]");
    public static By uploadMemberList = By.xpath ("//button[contains(text(),'Upload Member List')]");
    public static By manageMasterData = By.xpath ("//button[contains(text(),'Manage Master Data Source')]");
    public static By manageSubData = By.xpath ("//button[contains(text(),'Manage Sub Data Source')]");
    public static By exclusionMember = By.xpath("//*[contains(text(),'Member Batch Exclusion')]");

    //Search Member
    public static By searchMember = By.xpath ("//*[@id='HCDatanameSearch MemberLink']");
    //public static By searchMember = By.xpath ("//mat-sidenav-content[@class='mat-drawer-content mat-sidenav-content']//div[5]");

    //S_Configuration
    public static By configuration = By.xpath ("//*[@id='HCDatanameConfigurationSpan']");
    public static By manageSourceType = By.xpath ("//button[contains(text(),'Manage Source Type')]");
    public static By manageUserRoles = By.xpath ("//button[contains(text(),'Manage User Roles & Permissions')]");
    public static By manageGroup = By.xpath ("//button[@id='HCBtnChildDataManage Group Roles']");
    public static By manageSymptomTag = By.xpath("//button[@id='HCBtnChildDataManage Symptoms Tag']");
    public static By manageCompanyName = By.xpath ("//button[@id='HCBtnChildDataManage Company Name']");
    public static By manageSME = By.xpath("//button[@id='HCBtnChildDataManage SME']");
    public static By groupCompanyMap = By.xpath("//button[@id='HCBtnChildDataGroup Company Map']");
    public static By offerMaster = By.xpath("//button[@id='HCBtnChildDataOffer Master']");
    public static By offerBySource = By.xpath("//button[@id='HCBtnChildDataOffer By Source']");
    public static By levelMaster = By.xpath("//button[@id='HCBtnChildDataLevel Master']");
    public static By levelBySource = By.xpath("//button[@id='HCBtnChildDataLevel By Source']");
    public static By product = By.xpath("//button[@id='HCBtnChildDataProduct']");
    public static By valueMaster = By.xpath("//button[@id='HCBtnChildDataManage Value Master']");
    public static By groupUser = By.xpath("//button[@id='HCBtnChildDataManage Group Users']");
    public static By deactivateReason = By.xpath("//button[@id='HCBtnChildDataDeactivate Reason Master']");
    public static By callbackStatus = By.xpath("//button[@id='HCBtnChildDataCallback Status Master']");

    //S_Reports
    public static By Reports = By.xpath("//*[@id='HCDatanameReportsSpan']");
    public static By notesReports = By.xpath("//*[@id='HCBtnChildDataNotes Report']");
    public static By membersBySource = By.xpath("//*[@id='HCBtnChildDataMembers by Source']");
    public static By callbackSummaryReports = By.xpath("//*[@id='HCBtnChildDataCallback Summary Report']");
    public static By surveyReports = By.xpath("//*[@id='HCBtnChildDataSurvey Report']");
    public static By surveyAnswers = By.xpath("//*[@id='HCBtnChildDataSurvey Answers']");
    public static By userAuditReports = By.xpath("//*[@id='HCBtnChildDataUser Audit Report']");
    public static By CQCReports = By.xpath("//*[@id='HCBtnChildDataCQC Verification Report']");
    public static By memberAuditReports = By.xpath("//*[@id='HCBtnChildDataMember Audit Report']");
    public static By APIAuditReports = By.xpath("//*[@id='HCBtnChildDataAPI Audit Report']");
    public static By userByCompany = By.xpath("//*[@id='HCBtnChildDataUser By Company']");

    //S_Settings
    public static By  settings = By.xpath("//*[@id='HCDatanameSettingsSpan']");
    public static By  changePwd = By.xpath("//*[@id='HCBtnChildDataChange Password']");

    //User Management
    public static By userMgnt = By.xpath("//div[@id='HCDatanameUser ManagementSpan']");
    public static By userList = By.xpath("//*[@id='HCBtnChildDataUser List']");
    public static By myProfile = By.xpath("//*[@id='HCBtnChildDataMy Profile']");
    public static By manageUser = By.xpath("//*[@id='HCBtnChildDataManage User']");



}
