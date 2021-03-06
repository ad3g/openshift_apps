package com.pv.models;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Twitter_ {

@SerializedName("keywords")
@Expose
private List<String> keywords = new ArrayList<String>();
@SerializedName("accounts")
@Expose
private Accounts_ accounts;

/**
* 
* @return
* The keywords
*/
public List<String> getKeywords() {
return keywords;
}

/**
* 
* @param keywords
* The keywords
*/
public void setKeywords(List<String> keywords) {
this.keywords = keywords;
}

/**
* 
* @return
* The accounts
*/
public Accounts_ getAccounts() {
return accounts;
}

/**
* 
* @param accounts
* The accounts
*/
public void setAccounts(Accounts_ accounts) {
this.accounts = accounts;
}

}
