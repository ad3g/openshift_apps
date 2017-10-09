package com.pv.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Social {

@SerializedName("twitter")
@Expose
private Twitter twitter;

/**
* 
* @return
* The twitter
*/
public Twitter getTwitter() {
return twitter;
}

/**
* 
* @param twitter
* The twitter
*/
public void setTwitter(Twitter twitter) {
this.twitter = twitter;
}

}
