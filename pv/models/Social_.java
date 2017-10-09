package com.pv.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Social_ {

@SerializedName("twitter")
@Expose
private Twitter_ twitter;

/**
* 
* @return
* The twitter
*/
public Twitter_ getTwitter() {
return twitter;
}

/**
* 
* @param twitter
* The twitter
*/
public void setTwitter(Twitter_ twitter) {
this.twitter = twitter;
}

}
