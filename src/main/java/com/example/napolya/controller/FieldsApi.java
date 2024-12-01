/**
 * NOTE: This class is auto-generated.
 * Do not edit the class manually.
 */
package com.example.napolya.controller;

import com.example.napolya.model.Field;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;

@Validated
public interface FieldsApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /fields : Получить список названий полей
     *
     * @return Успешный ответ с массивом названий полей (status code 200)
     */
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/fields",
            produces = {"application/json"}
    )
    default ResponseEntity<List<String>> fieldsGet() {
        getRequest().ifPresent(request -> {
            // Установите пример ответа
            // Если есть требуемые примеры, вы можете добавить их тут
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * DELETE /fields/{id} : Удалить поле
     *
     * @param id ID поля (required)
     * @return Поле успешно удалено (status code 204)
     * or Поле не найдено (status code 404)
     */
    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/fields/{id}"
    )
    default ResponseEntity<Void> fieldsIdDelete(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * GET /fields/{id} : Получить информацию о поле
     *
     * @param id ID поля (required)
     * @return Информация о поле (status code 200)
     * or Поле не найдено (status code 404)
     */
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/fields/{id}",
            produces = {"application/json"}
    )
    default ResponseEntity<Field> fieldsIdGet(@PathVariable("id") Integer id) {
        getRequest().ifPresent(request -> {
            // Установите пример ответа
            // Если есть требуемые примеры, вы можете добавить их тут
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * PUT /fields/{id} : Обновить информацию о поле
     *
     * @param id ID поля (required)
     * @param field (required)
     * @return Поле успешно обновлено (status code 200)
     * or Поле не найдено (status code 404)
     */
    @RequestMapping(
            method = RequestMethod.PUT,
            value = "/fields/{id}",
            produces = {"application/json"},
            consumes = {"application/json"}
    )
    default ResponseEntity<Field> fieldsIdPut(@PathVariable("id") Integer id, @RequestBody Field field) {
        getRequest().ifPresent(request -> {
            // Установите пример ответа
            // Если есть требуемые примеры, вы можете добавить их тут
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}

