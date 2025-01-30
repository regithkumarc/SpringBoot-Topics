package com.example.passwordprotectedpdf.controller;

import com.example.passwordprotectedpdf.service.PDFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class PDFController {

    @Autowired
    private PDFService pdfService;

    @Value("${readFilePath}")
    private String readFilePath;

    @Value("${protectedFilePath}")
    private String protectedFilePath;

    @PostMapping("/writeProtectedPDF")
    public String writeProtectedPDF(@RequestParam("fileName") String fileName) throws IOException {
        return pdfService.writeProtectedPDFToAnotherFolder(readFilePath, protectedFilePath, fileName);
    }

    @PostMapping("/writeProtectedSingleORMultiplePDF")
    public List<String> writeProtectedSingleORMultiplePDF(@RequestBody List<String> fileNameList) throws IOException {
        return pdfService.writeProtectedSingleORMultiplePDFToAnotherFolder(readFilePath, protectedFilePath, fileNameList);
    }

    @RequestMapping("/readProtectedPDF")
    public ResponseEntity<String> readProtectedPDF(@RequestParam("file") MultipartFile file,
                                                   @RequestParam("password") String password) throws IOException {
        String content = pdfService.readProtectedPDF(file.getInputStream(), password);
        System.out.println("PDF file is decrypted successfully!");
        return ResponseEntity.ok(content);
    }
}
