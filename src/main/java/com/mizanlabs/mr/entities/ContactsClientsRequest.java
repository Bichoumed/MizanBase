package com.mizanlabs.mr.entities;

public class ContactsClientsRequest {
	  private Long contactId;
	    private Long clientId;
	    private Boolean isPrincipal;
		public Long getContactId() {
			return contactId;
		}
		public void setContactId(Long contactId) {
			this.contactId = contactId;
		}
		public Long getClientId() {
			return clientId;
		}
		public void setClientId(Long clientId) {
			this.clientId = clientId;
		}
		public Boolean getIsPrincipal() {
			return isPrincipal;
		}
		public void setIsPrincipal(Boolean isPrincipal) {
			this.isPrincipal = isPrincipal;
		}

}
