package com.example.passwordprotectedpdf.service;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.apache.pdfbox.pdmodel.encryption.StandardProtectionPolicy;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PDFService {

    @Value("${pdf.protected.userPassword}")
    private String userPassword;

    @Value("${pdf.protected.ownerPassword}")
    private String ownerPassword;

    public String writeProtectedPDFToAnotherFolder(String readFilePath, String protectedFilePath, String fileName) throws IOException {

        File readFileName = new File(readFilePath + "/" + fileName);
        System.out.println("Read File Name : " + readFileName);
        if(readFileName.exists()) {
            PDDocument pdDocument = PDDocument.load(readFileName);

            AccessPermission permission = new AccessPermission();
            permission.setCanPrint(false); // Set to true if you want to allow printing

            System.out.println("User Password : " + userPassword);
            System.out.println("Owner Password : " + ownerPassword);

            StandardProtectionPolicy policy = new StandardProtectionPolicy(userPassword, ownerPassword, permission);
            pdDocument.protect(policy);

            File protectedFileName = new File(protectedFilePath + "/" + fileName);
            System.out.println("Protected File Name : " + protectedFileName);
            pdDocument.save(protectedFileName);
            pdDocument.close(); // Your code to password protect the document will go here
            System.out.println("PDF file is password protected successfully!");
            return "PDF file is password protected successfully!";
        } else {
            return "No PDF is matching for this fileName : " + readFileName.getName();
        }
    }

    public List<String> writeProtectedSingleORMultiplePDFToAnotherFolder(String readFilePath, String protectedFilePath, List<String> fileNameList) throws IOException {

        List<String> validFileNamesList = new ArrayList<>();
        List<String> inValidFileNamesList = new ArrayList<>();

        if(!fileNameList.isEmpty()) {
            for (String fileName : fileNameList) {
                File readFileName = new File(readFilePath + "/" + fileName);
                System.out.println("Read File Name : " + readFileName);
                if (readFileName.exists()) {
                    PDDocument pdDocument = PDDocument.load(readFileName);

                    AccessPermission permission = new AccessPermission();
                    permission.setCanPrint(false); // Set to true if you want to allow printing

                    System.out.println("User Password : " + userPassword);
                    System.out.println("Owner Password : " + ownerPassword);

                    StandardProtectionPolicy policy = new StandardProtectionPolicy(userPassword, ownerPassword, permission);
                    pdDocument.protect(policy);

                    File protectedFileName = new File(protectedFilePath + "/" + fileName);
                    System.out.println("Protected File Name : " + protectedFileName);
                    pdDocument.save(protectedFileName);
                    pdDocument.close(); // Your code to password protect the document will go here
                    System.out.println("PDF file is password protected successfully for this fileName : " + readFileName.getName());
                    validFileNamesList.add(readFileName.getName());
                } else {
                    System.out.println("No PDF is matching for this fileName : " + readFileName.getName());
                    inValidFileNamesList.add(readFileName.getName());
                }
            }
        } else {
            System.out.println("Invalid file list");
            inValidFileNamesList.add("Invalid file list");
        }

        return List.of("Valid FileNames List : " + validFileNamesList,"Invalid FileNames List : " + inValidFileNamesList);
    }


    public String readProtectedPDF(InputStream inputStream, String password) throws IOException {
        PDDocument pdDocument = PDDocument.load(inputStream, password);
        if (!pdDocument.isEncrypted()) {
            PDFTextStripper stripper = new PDFTextStripper();
            return stripper.getText(pdDocument);
        } else {
            return "PDF is encrypted. Unable to read";
        }
    }
}
