package com.example.demo.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.example.demo.Repositories.SciencePlanRepository;
import edu.gemini.app.ocs.OCS;
import edu.gemini.app.ocs.model.DataProcRequirement;
import edu.gemini.app.ocs.model.SciencePlan;
import edu.gemini.app.ocs.model.SciencePlan.TELESCOPELOC;
import edu.gemini.app.ocs.model.StarSystem;
import edu.gemini.app.ocs.model.StarSystem.CONSTELLATIONS;
import org.springframework.beans.factory.annotation.Autowired;

public class ModelMapper {
    static OCS ocs = new OCS(true);

    public static OCS getInstance() {
        return ocs;
    }
    public static DataProcRequirement DataProcRequest(com.example.demo.Models.DataProcRequirement dataProcRequirementRequest) {
        DataProcRequirement DPR = new DataProcRequirement();

        DPR.setFileType(dataProcRequirementRequest.getFileType());
        DPR.setFileQuality(dataProcRequirementRequest.getFileQuality());
        DPR.setColorType(dataProcRequirementRequest.getColorType());
        DPR.setContrast(dataProcRequirementRequest.getContrast());
        DPR.setBrightness(dataProcRequirementRequest.getBrightness());
        DPR.setSaturation(dataProcRequirementRequest.getSaturation());
        DPR.setHighlights(dataProcRequirementRequest.getHighlights());
        DPR.setExposure(dataProcRequirementRequest.getExposure());
        DPR.setShadows(dataProcRequirementRequest.getShadows());
        DPR.setWhites(dataProcRequirementRequest.getWhites());
        DPR.setBlacks(dataProcRequirementRequest.getBlacks());
        DPR.setLuminance(dataProcRequirementRequest.getLuminance());
        DPR.setHue(dataProcRequirementRequest.getHue());

        return DPR;
    }

    public static SciencePlan createSciencePlan(SciencePlanRequest sciencePlanRequest) {
        SciencePlan SP = new SciencePlan();

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        SP.setPlanNo(sciencePlanRequest.getPlanNo());
        SP.setCreator(sciencePlanRequest.getCreator());
        SP.setSubmitter(sciencePlanRequest.getSubmitter());
        SP.setFundingInUSD(sciencePlanRequest.getFundingInUSD());
        SP.setObjectives(sciencePlanRequest.getObjectives());
        SP.setStarSystem(CONSTELLATIONS.valueOf(sciencePlanRequest.getStarSystem()));
        SP.setTelescopeLocation(TELESCOPELOC.valueOf(sciencePlanRequest.getTelescopeLocation()));
        SP.setStatus(SciencePlan.STATUS.valueOf(sciencePlanRequest.getStatus()));
        if (sciencePlanRequest.getDataProcRequirements() != null) {
            SP.setDataProcRequirements(ModelMapper.DataProcRequest(sciencePlanRequest.getDataProcRequirements()));
        }
        try {
            SP.setStartDate(dateFormat.parse(sciencePlanRequest.getStartDate()));
            SP.setEndDate(dateFormat.parse(sciencePlanRequest.getEndDate()));
        } catch (ParseException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Unparseable date: " + e.getMessage());
        }
        ocs.createSciencePlan(SP);
        return SP;
    }
}
