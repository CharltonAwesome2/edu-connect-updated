/*
    StudentWorkspaceController.java
    Student Workspace Controller class
    Author: Nolwazi Zulu (220118876)
    Date: 10 November 2026
*/

package za.ac.cput.controller;

/*
    StudentWorkspaceController.java
    Student Workspace Controller class
    Author: Nolwazi Zulu (220118876)
    Date: 10 November 2026
*/

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import za.ac.cput.dto.StudentWorkspaceResponseDTO;
import za.ac.cput.service.StudentWorkspaceService;

@RestController
@RequestMapping("/api/student-workspace")
public class StudentWorkspaceController {

    private final StudentWorkspaceService studentWorkspaceService;

    public StudentWorkspaceController(
            StudentWorkspaceService studentWorkspaceService) {
        this.studentWorkspaceService = studentWorkspaceService;
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<StudentWorkspaceResponseDTO> getStudentWorkspace(
            @PathVariable Long studentId) {

        StudentWorkspaceResponseDTO workspace =
                studentWorkspaceService.getStudentWorkspace(studentId);

        if (workspace == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(workspace, HttpStatus.OK);
    }
}
