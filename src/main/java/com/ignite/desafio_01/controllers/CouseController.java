package com.ignite.desafio_01.controllers;

import com.ignite.desafio_01.dtos.courses.CreateCourseDto;
import com.ignite.desafio_01.dtos.courses.EditCourseDto;
import com.ignite.desafio_01.entities.Course;
import com.ignite.desafio_01.exceptions.ErrorResponse;
import com.ignite.desafio_01.services.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cursos")
@Tag(name = "Controller de cursos")
public class CouseController {

    @Autowired
    CourseService courseService;

    @PostMapping
    @Operation(summary = "Criação de curso",
               description = "Essa função é responsável por cadastrar um novo curso")
    ResponseEntity<Void> createCourse(@RequestBody @Valid CreateCourseDto userDto){
        Course createdCourse = courseService.createCourse(userDto);

        return ResponseEntity.ok().build();
    }

    @GetMapping
    @Operation(summary = "Busca de cursos",
            description = "Essa função é responsável por buscar todos cursos na base de dados")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Course[].class))
            })
    })
    ResponseEntity<List<Course>> getAllCourses(){
        List<Course> allCourses = this.courseService.getAllCourses();
        return ResponseEntity.ok(allCourses);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Edição de atributos do curso",
            description = "Essa função é responsável por editar os campos name ou category de um curso")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Course.class))
            }),
            @ApiResponse(responseCode = "400", description = "Curso não encontrado", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
            })
    })
    ResponseEntity<Course> editCourse(@RequestBody EditCourseDto courseDto, @PathVariable UUID id){
        Course editCourse = courseService.editCourse(id, courseDto);

        return ResponseEntity.ok(editCourse);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleção de curso",
            description = "Essa função é responsável por deletar um curso do banco de dados")
    @ApiResponses({
            @ApiResponse(responseCode = "400", description = "Curso não encontrado", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
            })
    })
    ResponseEntity<Course> deleteCourse(@PathVariable UUID id){
        courseService.deleteCourse(id);

        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}/active")
    @Operation(summary = "Edição da propriedade active/inactive",
            description = "Essa função é responsável por alterar o atributo active/inactive")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Course.class))
            }),
            @ApiResponse(responseCode = "400", description = "Curso não encontrado", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
            })
    })
    ResponseEntity<Course> toggleActive(@PathVariable UUID id){
        Course updatedCourse = courseService.toggleActive(id);
        return ResponseEntity.ok(updatedCourse);
    }
}
