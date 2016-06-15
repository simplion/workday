package com.workday.salesforce.actions.services;
import org.openqa.selenium.WebDriver;

import com.workday.salesforce.actions.services.BaseActions;

public class CsodCreateAggrementLineItemPageAction extends BaseActions {
	WebDriver driver;

	public CsodCreateAggrementLineItemPageAction(WebDriver driver){
			super(driver);
			this.driver = driver;
		}
		public void navigate_to_Agreement()
		{
			click("Agreements", "CSODModule");
			click("NewAgreement_button","CSODModule");
		}
		public void create_new_Agreement()
		{
			selectOptionByVisibleText("Agreementre_type_dropdown", "CSODModule","Training");
			click("Continue_button", "CSODModule");
			click("Agreement_status_dropdown", "CSODModule");
			click("Ineffect_status_dropdown", "CSODModule");
			click("Agreement_save_button", "CSODModule");
			click("Add_sku_button", "CSODModule");
			click("LodAgreement_Item_checkbox", "CSODModule");
		}
		public void enter_lod_quantity(String lodquantity)
		{
			writeTextInto("LodQuanity", "CSODModule", lodquantity);
			click("SaveAgreementLineItem_button", "CSODModule");
		}
		
		public void Verify_AgreementLineItem_NotAdded()
		{
//			if(selectlodagreementItem!=agreementlineitemLod)
//			{
//				System.out.println("Agreement line item is not added in LOD subscription section");
//			}
//			else
//			{
//				System.out.println("Agreement line item is added in LOD subscription section");
//			}
		}
}
