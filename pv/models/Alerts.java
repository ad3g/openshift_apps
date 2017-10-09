package com.pv.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Alerts {

@SerializedName("timestamp")
@Expose
private String timestamp;
@SerializedName("upset")
@Expose
private Integer upset;
@SerializedName("redzone")
@Expose
private Integer redzone;

/**
* 
* @return
* The timestamp
*/
public String getTimestamp() {
return timestamp;
}

/**
* 
* @param timestamp
* The timestamp
*/
public void setTimestamp(String timestamp) {
this.timestamp = timestamp;
}

/**
* 
* @return
* The upset
*/
public Integer getUpset() {
return upset;
}

/**
* 
* @param upset
* The upset
*/
public void setUpset(Integer upset) {
this.upset = upset;
}

/**
* 
* @return
* The redzone
*/
public Integer getRedzone() {
return redzone;
}

/**
* 
* @param redzone
* The redzone
*/
public void setRedzone(Integer redzone) {
this.redzone = redzone;
}

}
