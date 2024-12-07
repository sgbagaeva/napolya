package com.example.napolya.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nonnull;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Objects;

/**
 * ProviderField
 */
@Table(name = "provider_field")
public class ProviderField {

    @Id
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("provider_id")
    private Integer providerId;

    @JsonProperty("field_id")
    private Integer fieldId;

    public ProviderField id(Integer id) {
        this.id = id;
        return this;
    }

    /**
     * Уникальный идентификатор связи между провайдером и полем
     * @return id
     */
    @Nonnull
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ProviderField providerId(Integer providerId) {
        this.providerId = providerId;
        return this;
    }

    /**
     * ID провайдера
     * @return providerId
     */
    public Integer getProviderId() {
        return providerId;
    }

    public void setProviderId(Integer providerId) {
        this.providerId = providerId;
    }

    public ProviderField fieldId(Integer fieldId) {
        this.fieldId = fieldId;
        return this;
    }

    /**
     * ID поля, которое предоставляется провайдером
     * @return fieldId
     */
    public Integer getFieldId() {
        return fieldId;
    }

    public void setFieldId(Integer fieldId) {
        this.fieldId = fieldId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProviderField providerField = (ProviderField) o;
        return Objects.equals(this.id, providerField.id) &&
                Objects.equals(this.providerId, providerField.providerId) &&
                Objects.equals(this.fieldId, providerField.fieldId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, providerId, fieldId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ProviderField {\n");
        sb.append(" id: ").append(toIndentedString(id)).append("\n");
        sb.append(" providerId: ").append(toIndentedString(providerId)).append("\n");
        sb.append(" fieldId: ").append(toIndentedString(fieldId)).append("\n");
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
        return o.toString().replace("\n", "\n ");
    }
}
