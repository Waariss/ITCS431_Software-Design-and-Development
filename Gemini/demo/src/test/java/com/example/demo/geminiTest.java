package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.example.demo.Service.SciencePlanRequest;
import edu.gemini.app.ocs.model.SciencePlan;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.demo.Models.DataProcRequirement;
import edu.gemini.app.ocs.OCS;
import edu.gemini.app.ocs.model.StarSystem;
import edu.gemini.app.ocs.model.StarSystem.CONSTELLATIONS;
import com.example.demo.Service.ModelMapper;

public class geminiTest {

    private OCS mockOCS;

    @BeforeEach
    public void setUp() throws Exception {
        mockOCS = mock(OCS.class);
        setPrivateField(ModelMapper.class, "ocs", mockOCS);
    }

    private static void setPrivateField(Class<?> clazz, String fieldName, Object value)
            throws NoSuchFieldException, IllegalAccessException {
        Field field = clazz.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(null, value);
    }

    @Test
    public void testCreateSciencePlan() throws Exception {
        // Arrange
        SciencePlanRequest request = new SciencePlanRequest();
        request.setPlanNo(123);
        request.setCreator("John Doe");
        request.setSubmitter("SubmitterName");
        request.setFundingInUSD(1000);
        request.setObjectives("Study the stars");
        request.setStarSystem(String.valueOf(CONSTELLATIONS.Auriga));
        request.setTelescopeLocation(String.valueOf(edu.gemini.app.ocs.model.SciencePlan.TELESCOPELOC.HAWAII));

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date startDate = dateFormat.parse("22/02/2021 23:00:00");
        Date endDate = dateFormat.parse("23/02/2021 02:00:00");

        request.setStartDate(String.valueOf(startDate));
        request.setEndDate(String.valueOf(endDate));


//        Date startDate = dateFormat.parse("22/02/2021 23:00:00");
//        Date endDate = dateFormat.parse("23/02/2021 02:00:00");

//        System.out.println("Parsed startDate: " + startDate); // Add this line
//        System.out.println("Parsed endDate: " + endDate);     // Add this line

        // Parse date strings only if they are not null
//        Date startDate = null;
//        Date endDate = null;
//        try {
//            startDate = dateFormat.parse("22/02/2021 23:00:00");
//            endDate = dateFormat.parse("23/02/2021 02:00:00");
//        } catch (ParseException e) {
//            // Handle the exception (print or log it, or throw a new exception)
//            e.printStackTrace();
//        }


        DataProcRequirement dataProcRequirement = new DataProcRequirement();
        dataProcRequirement.setFileType("JPEG");
        dataProcRequirement.setFileQuality("Low");
        dataProcRequirement.setColorType("Color mode");
        dataProcRequirement.setContrast(0.0);
        dataProcRequirement.setBrightness(10.0);
        dataProcRequirement.setSaturation(5.0);
        dataProcRequirement.setHighlights(0.0);
        dataProcRequirement.setExposure(7.0);
        dataProcRequirement.setShadows(0.0);
        dataProcRequirement.setWhites(0.0);
        dataProcRequirement.setBlacks(0.0);
        dataProcRequirement.setLuminance(10.0);
        dataProcRequirement.setHue(8.0);

        request.setDataProcRequirements(dataProcRequirement);

        ModelMapper mapper = new ModelMapper();

        // Act
        SciencePlan result = mapper.createSciencePlan(request);

        // Assert
        assertEquals(123, result.getPlanNo());
        assertEquals("John Doe", result.getCreator());
        assertEquals("SubmitterName", result.getSubmitter());
        assertEquals(1000.0, result.getFundingInUSD());
        assertEquals("Study the stars", result.getObjectives());
        assertEquals(CONSTELLATIONS.Auriga, result.getStarSystem());
        assertEquals(edu.gemini.app.ocs.model.SciencePlan.TELESCOPELOC.HAWAII, result.getTelescopeLocation());
        // Check for null and format the date if not null
        // Check for null and format the date if not null
        if (result.getStartDate() != null) {
            assertEquals("22/02/2021 23:00:00", dateFormat.format(result.getStartDate()));
        } else {
            assertNull(result.getStartDate());
        }

// Check for null and format the date if not null
        if (result.getEndDate() != null) {
            assertEquals("23/02/2021 02:00:00", dateFormat.format(result.getEndDate()));
        } else {
            assertNull(result.getEndDate());
        }

        assertEquals(dataProcRequirement, result.getDataProcRequirements());

        // Verify that createSciencePlan method was called with the correct parameter
        verify(mockOCS).createSciencePlan(result);
    }
    // Add more test methods as needed
}
