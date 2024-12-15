package com.example.napolya.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Player
 */
@Table(name = "user")
public class User {
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
  private String role = "PLAYER";

  @JsonProperty("registration_date")
  //@Column("registration_date")
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

  @JsonProperty("akk_id")
  private Integer akkId;

  public User id(Integer id) {
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

  public User name(String name) {
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

  public User surname(String surname) {
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

  public User email(String email) {
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

  public User password(String password) {
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

  public User role(String role) {
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

  public User registrationDate(LocalDateTime registrationDate) {
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

  public User rating(Integer rating) {
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
  public User gamesIds(List<Integer> gamesIds) {
    this.gamesIds = gamesIds;
    return this;
  }

  public User addGamesIdsItem(Integer gamesIdsItem) {
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

  public User entriesAmount(Integer entriesAmount) {
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

  public User akkId(Integer akkId) {
    this.akkId = akkId;
    return this;
  }

  /**
   * Уникальный идентификатор игрока
   * @return id
   */


  public Integer getAkkId() {
    return akkId;
  }

  public void setAkkId(Integer akkId) {
    this.akkId = akkId;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(this.id, user.id) &&
        Objects.equals(this.name, user.name) &&
        Objects.equals(this.surname, user.surname) &&
        Objects.equals(this.email, user.email) &&
        Objects.equals(this.password, user.password) &&
        Objects.equals(this.role, user.role) &&
        Objects.equals(this.registrationDate, user.registrationDate) &&
        Objects.equals(this.rating, user.rating) &&
        //Objects.equals(this.gamesIds, player.gamesIds) &&
        Objects.equals(this.entriesAmount, user.entriesAmount) &&
        Objects.equals(this.akkId, user.akkId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, surname, email, password, role, registrationDate, rating, /*gamesIds,*/ entriesAmount, akkId);
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
    sb.append("    akkId: ").append(toIndentedString(akkId)).append("\n");
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

