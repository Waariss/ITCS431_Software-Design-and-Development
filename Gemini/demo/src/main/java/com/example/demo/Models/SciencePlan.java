package com.example.demo.Models;

import lombok.Data;
import java.util.ArrayList;
import jakarta.persistence.*;

@Entity
@Table(name = "science_plans")
@Data
public class SciencePlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int planNo;
    private String creator;
    private String submitter;
    private int fundingInUSD;
    private String objectives;
    private String starSystem;
    private String startDate;
    private String endDate;
    private String telescopeLocation;
    @OneToOne(cascade = CascadeType.ALL)
    private DataProcRequirement dataProcRequirements;
    private String status;

    public SciencePlan(int planNo, String creator, String submitter, int fundingInUSD, String objectives, String starSystem, String startDate, String endDate, String telescopeLocation, DataProcRequirement dataProcRequirements, String status) {
        this.planNo = planNo;
        this.creator = creator;
        this.submitter = submitter;
        this.fundingInUSD = fundingInUSD;
        this.objectives = objectives;
        this.starSystem = starSystem;
        this.startDate = startDate;
        this.endDate = endDate;
        this.telescopeLocation = telescopeLocation;
        this.dataProcRequirements = dataProcRequirements;
        this.status = status;
    }

    public SciencePlan() {

    }

    public int getPlanNo() {
        return planNo;
    }

    public String getCreator() {
        return creator;
    }

    public String getSubmitter() {
        return submitter;
    }

    public int getFundingInUSD() {
        return fundingInUSD;
    }

    public String getObjectives() {
        return objectives;
    }

    public String getStarSystem() {
        return starSystem;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getTelescopeLocation() {
        return telescopeLocation;
    }

    public DataProcRequirement getDataProcRequirements() {
        return dataProcRequirements;
    }

    public String getStatus() {
        return status;
    }

}