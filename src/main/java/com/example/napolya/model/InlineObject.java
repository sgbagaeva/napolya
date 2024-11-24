package com.example.napolya.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import jakarta.annotation.Generated;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;

import java.util.Objects;

/**
 * InlineObject
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-11-22T19:51:05.893207800+03:00[Europe/Moscow]")
public class InlineObject   {
  @JsonProperty("username")
  private String username;

  @Nullable
  @JsonProperty("surname")
  private String surname;

  @Nullable
  @JsonProperty("email")
  private String email;

  @JsonProperty("password")
  private String password;

  public InlineObject username(String username) {
    this.username = username;
    return this;
  }

  /**
   * Get username
   * @return username
  */
  @ApiModelProperty(example = "Света", required = true, value = "")
  @Nonnull


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public InlineObject surname(String surname) {
    this.surname = surname;
    return this;
  }

  /**
   * Фамилия игрока
   * @return surname
  */
  @ApiModelProperty(example = "Багаева", value = "Фамилия игрока")


  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public InlineObject email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Электронная почта игрока
   * @return email
  */
  @ApiModelProperty(example = "sveta@gmail.com", value = "Электронная почта игрока")


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public InlineObject password(String password) {
    this.password = password;
    return this;
  }

  /**
   * Get password
   * @return password
  */
  @ApiModelProperty(example = "666#999", required = true, value = "")
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
    InlineObject inlineObject = (InlineObject) o;
    return Objects.equals(this.username, inlineObject.username) &&
        Objects.equals(this.surname, inlineObject.surname) &&
        Objects.equals(this.email, inlineObject.email) &&
        Objects.equals(this.password, inlineObject.password);
  }

  private static <T> boolean equalsNullable(T a, T b) {
    return (a == b) || (a != null && b != null && a.equals(b));
  }

  @Override
  public int hashCode() {
    return Objects.hash(username, surname, email, password);
  }

  private static <T> int hashCodeNullable(T a) {
    if (a == null) {
      return 1; // Фиксированное значение для null
    }
    return a.hashCode(); // Используем метод hashCode() для ненулевых значений
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineObject {\n");
    
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    surname: ").append(toIndentedString(surname)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
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

