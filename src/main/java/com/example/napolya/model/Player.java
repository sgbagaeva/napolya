package com.example.napolya.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Player
 */
@Table(name = "player")
public class Player   {
  @Id
  @JsonProperty("id")
  private Integer id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("surname")
  private String surname;

  @JsonProperty("email")
  private String email;

  @JsonProperty("password")
  private String password;

  @JsonProperty("role")
  private String role = "ADMIN";

  @JsonProperty("registration_date")
  @Column("registration_date")
  @DateTimeFormat
  private LocalDateTime registrationDate;

  @JsonProperty("rating")
  private Integer rating = 0;

  /*
  @JsonProperty("games_ids")
  private List<Integer> gamesIds = null;
   */
  @JsonProperty("entries_amount")
  @Column("entries_amount")
  private Integer entriesAmount = 0;

  public Player id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Уникальный идентификатор игрока
   * @return id
  */


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Player name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Имя игрока
   * @return name
  */


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Player surname(String surname) {
    this.surname = surname;
    return this;
  }

  /**
   * Get surname
   * @return surname
  */


  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public Player email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
  */

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Player password(String password) {
    this.password = password;
    return this;
  }

  /**
   * Пароль игрока
   * @return password
  */


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Player role(String role) {
    this.role = role;
    return this;
  }

  /**
   * Роль игрока
   * @return role
  */


  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public Player registrationDate(LocalDateTime registrationDate) {
    this.registrationDate = registrationDate;
    return this;
  }

  /**
   * Get registrationDate
   * @return registrationDate
  */

  public LocalDateTime getRegistrationDate() {
    return registrationDate;
  }

  public void setRegistrationDate(LocalDateTime registrationDate) {
    this.registrationDate = registrationDate;
  }

  public Player rating(Integer rating) {
    this.rating = rating;
    return this;
  }

  /**
   * Рейтинг игрока
   * @return rating
  */


  public Integer getRating() {
    return rating;
  }

  public void setRating(Integer rating) {
    this.rating = rating;
  }

  /*
  public Player gamesIds(List<Integer> gamesIds) {
    this.gamesIds = gamesIds;
    return this;
  }

  public Player addGamesIdsItem(Integer gamesIdsItem) {
    if (this.gamesIds == null) {
      this.gamesIds = new ArrayList<>();
    }
    this.gamesIds.add(gamesIdsItem);
    return this;
  }

   */

  /**
   * Список id игр, на которые записан игрок
   * @return gamesIds
  */

  /*
  public List<Integer> getGamesIds() {
    return gamesIds;
  }

  public void setGamesIds(List<Integer> gamesIds) {
    this.gamesIds = gamesIds;
  }
  */

  public Player entriesAmount(Integer entriesAmount) {
    this.entriesAmount = entriesAmount;
    return this;
  }

  /**
   * Количество записей на игры
   * @return entriesAmount
  */


  public Integer getEntriesAmount() {
    return entriesAmount;
  }

  public void setEntriesAmount(Integer entriesAmount) {
    this.entriesAmount = entriesAmount;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Player player = (Player) o;
    return Objects.equals(this.id, player.id) &&
        Objects.equals(this.name, player.name) &&
        Objects.equals(this.surname, player.surname) &&
        Objects.equals(this.email, player.email) &&
        Objects.equals(this.password, player.password) &&
        Objects.equals(this.role, player.role) &&
        Objects.equals(this.registrationDate, player.registrationDate) &&
        Objects.equals(this.rating, player.rating) &&
        //Objects.equals(this.gamesIds, player.gamesIds) &&
        Objects.equals(this.entriesAmount, player.entriesAmount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, surname, email, password, role, registrationDate, rating, /*gamesIds,*/ entriesAmount);
  }

  private static <T> int hashCodeNullable(T a) {
    return (a == null) ? 1 : a.hashCode();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Player {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    surname: ").append(toIndentedString(surname)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
    sb.append("    registrationDate: ").append(toIndentedString(registrationDate)).append("\n");
    sb.append("    rating: ").append(toIndentedString(rating)).append("\n");
    //sb.append("    gamesIds: ").append(toIndentedString(gamesIds)).append("\n");
    sb.append("    entriesAmount: ").append(toIndentedString(entriesAmount)).append("\n");
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

