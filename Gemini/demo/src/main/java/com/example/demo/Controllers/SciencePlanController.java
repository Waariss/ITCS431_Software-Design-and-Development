package com.example.demo.Controllers;

import java.util.List;
import java.util.Map;

import com.example.demo.Models.User;
import com.example.demo.Repositories.SciencePlanRepository;
import com.example.demo.Service.ModelMapper;
import com.example.demo.Service.SciencePlanRequest;
import edu.gemini.app.ocs.model.StarSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import edu.gemini.app.ocs.OCS;
import edu.gemini.app.ocs.model.SciencePlan;
import edu.gemini.app.ocs.model.SciencePlan.STATUS;

import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/science_plan")
public class SciencePlanController {
    OCS ocs = ModelMapper.getInstance();
    @Autowired
    private SciencePlanRepository sciencePlanRepository;

    // GET /api/science_plan – Get all science plans in the OCS system
    @GetMapping("")
    public @ResponseBody List<SciencePlan> getAllSciencePlans() {
        return ocs.getAllSciencePlans();
    }

    // GET /api/science_plan/{planNo} – Get a specific science plan
    @GetMapping("/{planNo}")
    public @ResponseBody SciencePlan getSciencePlan(@PathVariable(value = "planNo") int planNo) {
        return ocs.getSciencePlanByNo(planNo);
    }

    // POST /api/science_plan – Create a new science plan
    @PostMapping("")
    public ResponseEntity<SciencePlan> createSciencePlan(@RequestBody SciencePlanRequest body) {
        SciencePlan sciencePlan = ModelMapper.createSciencePlan(body);
        return new ResponseEntity<>(sciencePlan, HttpStatus.CREATED);
    }

    // PUT /api/science_plan/{planNo} – Update a science plan
    @PutMapping("/{planNo}")
    public @ResponseBody SciencePlan updateSciencePlanStatus(@PathVariable("planNo") int planNo, @RequestBody Map<String, String> status) {
        ocs.updateSciencePlanStatus(planNo, STATUS.valueOf(status.get("status")));
        return ocs.getSciencePlanByNo(planNo);
    }

    // DELETES /api/science_plan/{planNo} – Delete a science plan
    @DeleteMapping("/{planNo}")
    public @ResponseBody void deleteSciencePlanByPlanNo(@PathVariable("planNo") int planNo) {
        ocs.deleteSciencePlanByNo(planNo);
        return;
    }

    // DELETE /api/science_plan – Delete all science plans
    @DeleteMapping("")
    public @ResponseBody void  deleteAllSciencePlans() {
        ocs.deleteAllSciencePlans();
        return;
    }
    // GET /api/science_plan/test/{planNO} - Test Science Plan
    @GetMapping("test/{planNo}")
    public @ResponseBody String testSciencePlan(@PathVariable(value = "planNo") int planNo) {
        SciencePlan sc = ocs.getSciencePlanByNo(planNo);
        System.out.println("SciencePlan object before testing: " + sc.toString());
        return ocs.testSciencePlan(sc);
    }

    // GET /api/science_plan/submit/{planNO} - Submit Science Plan
    @GetMapping("submit/{planNo}")
    public @ResponseBody String submitSciencePlan(@PathVariable(value = "planNo") int planNo){
        SciencePlan sp = ocs.getSciencePlanByNo(planNo);
        return ocs.submitSciencePlan(sp);
    }

    // GET /api/science_plan/starsystem - Get all starsystem
    @CrossOrigin
    @GetMapping("starsystems")
    public @ResponseBody StarSystem.CONSTELLATIONS[] getAllStarSystems() {
        return StarSystem.CONSTELLATIONS.values();
    }

    // GEt /api/science_plan/telescopelocation - Get all telescopelocation
    @CrossOrigin
    @GetMapping("telescopelocations")
    public @ResponseBody SciencePlan.TELESCOPELOC[] getAllTelescopeLoc() {
        return SciencePlan.TELESCOPELOC.values();
    }

    //GET /api/science_plan/status/{planNo} - Get status by planNo
    @CrossOrigin
    @GetMapping("status/{planNo}")
    public @ResponseBody SciencePlan.STATUS getStatus(@PathVariable(value = "planNo") int planNo) {
        SciencePlan sc = getSciencePlan(planNo);
        return sc.getStatus();
    }
}