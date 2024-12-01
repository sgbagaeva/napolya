package com.example.napolya.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nonnull;

import java.util.Objects;

/**
 * InlineObject1
 */
public class InlineObject1   {
  @JsonProperty("name")
  private String name;

  @JsonProperty("password")
  private String password;

  public InlineObject1 name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public InlineObject1 password(String password) {
    this.password = password;
    return this;
  }

  /**
   * Get password
   * @return password
  */
  @Nonnull


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineObject1 inlineObject1 = (InlineObject1) o;
    return Objects.equals(this.name, inlineObject1.name) &&
        Objects.equals(this.password, inlineObject1.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, password);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineObject1 {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

