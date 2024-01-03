package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import com.example.demo.Service.SciencePlanRequest;
import edu.gemini.app.ocs.model.SciencePlan;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.demo.Models.DataProcRequirement;
import edu.gemini.app.ocs.OCS;
import edu.gemini.app.ocs.model.StarSystem.CONSTELLATIONS;
import com.example.demo.Service.ModelMapper;

public class GeminiTest {

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

        SciencePlanRequest request = getSciencePlanRequest();

        SciencePlan result = ModelMapper.createSciencePlan(request);

        assertNotNull(result, "SciencePlan is null");
        assertEquals("Chanisara Kotrachai", result.getCreator());
        assertEquals("Waris Damkham", result.getSubmitter());
        assertEquals(1000.0, result.getFundingInUSD());
        assertEquals("To study the Auriga star system.", result.getObjectives());
        assertEquals(CONSTELLATIONS.Auriga, result.getStarSystem());
        assertEquals(edu.gemini.app.ocs.model.SciencePlan.TELESCOPELOC.HAWAII, result.getTelescopeLocation());

        SciencePlan.STATUS expectedStatus = SciencePlan.STATUS.valueOf("SAVED");
        assertEquals(expectedStatus, result.getStatus(), "Status does not match the expected value");

        assertNotNull(result.getStartDate(), "Start date is null");
        assertEquals("2021-02-22 23:00:00", result.getStartDate());

        assertNotNull(result.getEndDate(), "End date is null");
        assertEquals("2021-02-23 02:00:00", result.getEndDate());

        ArrayList<edu.gemini.app.ocs.model.DataProcRequirement> requirements = result.getDataProcRequirements();
        assertFalse(requirements.isEmpty(), "Data Processing Requirements list is empty");

        edu.gemini.app.ocs.model.DataProcRequirement firstRequirement = requirements.get(0);
        assertNotNull(firstRequirement, "First Data Processing Requirement is null");
        assertEquals("JPEG", firstRequirement.getFileType());
        assertEquals("Low", firstRequirement.getFileQuality());
        assertEquals("Color mode", firstRequirement.getColorType());
        assertEquals(0.0, firstRequirement.getContrast());
        assertEquals(10.0, firstRequirement.getBrightness());
        assertEquals(5.0, firstRequirement.getSaturation());
        assertEquals(0.0, firstRequirement.getHighlights());
        assertEquals(7.0, firstRequirement.getExposure());
        assertEquals(0.0, firstRequirement.getShadows());
        assertEquals(0.0, firstRequirement.getWhites());
        assertEquals(0.0, firstRequirement.getBlacks());
        assertEquals(10.0, firstRequirement.getLuminance());
        assertEquals(8.0, firstRequirement.getHue());

        verify(mockOCS).createSciencePlan(result);
    }

    @NotNull
    private static SciencePlanRequest getSciencePlanRequest() throws ParseException {
        SciencePlanRequest request = new SciencePlanRequest();
        request.setCreator("Chanisara Kotrachai");
        request.setSubmitter("Waris Damkham");
        request.setFundingInUSD((int) 1000.0);
        request.setObjectives("To study the Auriga star system.");
        request.setStarSystem("Auriga");
        request.setTelescopeLocation("HAWAII");

        request.setStatus("SAVED");

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.ENGLISH);

        Date testStartDate = dateFormat.parse("22/02/2021 23:00:00");
        Date testEndDate = dateFormat.parse("23/02/2021 02:00:00");

        request.setStartDate(dateFormat.format(testStartDate));
        request.setEndDate(dateFormat.format(testEndDate));

        request.setDataProcRequirements(getDataProcRequirement());
        return request;
    }

    @NotNull
    private static DataProcRequirement getDataProcRequirement() {
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
        return dataProcRequirement;
    }

}