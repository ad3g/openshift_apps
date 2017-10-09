package com.mm;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Twitter {

private List<Object> keywords = new ArrayList<Object>();
private Accounts accounts;

/**
* 
* @return
* The keywords
*/
public List<Object> getKeywords() {
return keywords;
}

/**
* 
* @param keywords
* The keywords
*/
public void setKeywords(List<Object> keywords) {
this.keywords = keywords;
}

/**
* 
* @return
* The accounts
*/
public Accounts getAccounts() {
return accounts;
}

/**
* 
* @param accounts
* The accounts
*/
public void setAccounts(Accounts accounts) {
this.accounts = accounts;
}

}