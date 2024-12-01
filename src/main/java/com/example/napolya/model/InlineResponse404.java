package com.example.napolya.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * InlineResponse404
 */
public class InlineResponse404   {
  @JsonProperty("message")
  private String message;

  public InlineResponse404 message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Get message
   * @return message
  */


  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineResponse404 inlineResponse404 = (InlineResponse404) o;
    return Objects.equals(this.message, inlineResponse404.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse404 {\n");
    
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
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

