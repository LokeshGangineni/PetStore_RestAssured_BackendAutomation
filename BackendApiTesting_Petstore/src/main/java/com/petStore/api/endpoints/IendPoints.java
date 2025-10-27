package com.petStore.api.endpoints;

public interface IendPoints {

	//pet
	String addnewPetToStore = "/pet";
	String updateExistPet = "/pet";
	String uploadImage = "/pet/{petId}/uploadImage";
	String findPetsStatus ="/pet/findByStatus";
	String findPetByID = "/pet/{petId}";
	String updatePetInStoreByFormData = "/pet/{petId}";
	String deletePet = "/pet/{petId}";
	
	
	//Store
	String returnPetInventoryByStatus = "/store/inventory";
	String placeOrderForPet = "/store/order";
	String findPurchaseOrderByID = "/store/order/{orderId}";
	String deletePurchaseOrderByID = "/store/order/{orderId}";
	
	
	//User
	String createListOfUserWithArray = "/user/createWithList";
	String getUserByUserName = "/user/{username}";
	String updateUser = "/user/{username}";
	String deleteUser  = "/user/{username}";
	String logsUserIntoSystem = "/user/login";
	String logoutFromCurrentUserSession = "/user/logout";
	String createUser = "/user";
}
