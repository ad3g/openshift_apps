package com.pv.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class TabsArray {

@SerializedName("type")
@Expose
private String type;
@SerializedName("title")
@Expose
private String title;
@SerializedName("file")
@Expose
private String file;

/**
* 
* @return
* The type
*/
public String getType() {
return type;
}

/**
* 
* @param type
* The type
*/
public void setType(String type) {
this.type = type;
}

/**
* 
* @return
* The title
*/
public String getTitle() {
return title;
}

/**
* 
* @param title
* The title
*/
public void setTitle(String title) {
this.title = title;
}

/**
* 
* @return
* The file
*/
public String getFile() {
return file;
}

/**
* 
* @param file
* The file
*/
public void setFile(String file) {
this.file = file;
}

}
