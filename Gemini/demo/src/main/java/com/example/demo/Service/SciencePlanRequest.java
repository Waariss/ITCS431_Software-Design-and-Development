package com.example.demo.Service;

import com.example.demo.Models.DataProcRequirement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SciencePlanRequest {
    private int planNo;
    private String creator;
    private String submitter;
    private int fundingInUSD;
    private String objectives;
    private String starSystem;
    private String startDate;
    private String endDate;
    private String telescopeLocation;
    private DataProcRequirement dataProcRequirements;
    private String status;

    @Override
    public String toString() {
        return "SciencePlanRequest [planNo="+ planNo +",creator=" + creator + ", dataProcRequirements="
                + dataProcRequirements + ", endDate=" + endDate + ", fundingInUSD=" + fundingInUSD
                + ", objectives=" + objectives + ", starSystem=" + starSystem + ", startDate=" + startDate
                + ", status=" + status + ", submitter=" + submitter + ", telescopeLocation="
                + telescopeLocation + "]";
    }
}
