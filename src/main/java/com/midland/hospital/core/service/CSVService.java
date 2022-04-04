package com.midland.hospital.core.service;

import com.midland.hospital.modules.patient.dto.PatientProfileDTO;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

@Service
public class CSVService {

    private static final String[] HEADERS = {"Id", "Name", "Age", "lastVisitDate"};
    private static final CSVFormat FORMAT = CSVFormat.DEFAULT.withHeader(HEADERS);

    //write data to csv
    public ByteArrayInputStream writeDataToCsv(final PatientProfileDTO profileDTO) {

        try (final ByteArrayOutputStream stream = new ByteArrayOutputStream();
            final CSVPrinter printer = new CSVPrinter(new PrintWriter(stream), FORMAT)) {
            final List<String> data = Arrays.asList(String.valueOf(profileDTO.getId()),profileDTO.getName(),String.valueOf(profileDTO.getAge()),
            String.valueOf(profileDTO.getLastVisitDate()));
            printer.printRecord(data);

            printer.flush();
            return new ByteArrayInputStream(stream.toByteArray());
        } catch (final IOException e) {
            throw new RuntimeException("Csv writing error: " + e.getMessage());
        }
    }
}
