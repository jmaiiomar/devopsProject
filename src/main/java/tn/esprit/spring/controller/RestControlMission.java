package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.MissionExterne;
import tn.esprit.spring.services.IMissionService;

@RestController
public class RestControlMission {
	
	@Autowired
	IMissionService imissionservice;
	// http://localhost:8086/SpringMVC/servlet/addMission
	/*   Mission
	  {
        "name": "mission one",
        "description": "this is a description of mission one",
        "departement": null,
        "timesheets": []
	  }
	 */

	@PostMapping("/addMission")
	@ResponseBody
	public Mission addMission(@RequestBody Mission miss ) {
		imissionservice.addMission(miss);
		return miss;
	}
	
	/*   MissionExterne
    {
   "name": "mission two",
   "description": "this is a description of mission two",
   "departement": null,
   "timesheets": [],
   "emailFacturation": "hamza.ennour@esprit.tn",
   "tauxJournalierMoyen": 5.0
	}
	*/
	@PostMapping("/addMissionExterne")
	@ResponseBody
	public MissionExterne addMission(@RequestBody MissionExterne missext ) {
		imissionservice.addMission(missext);
		return missext;
	}
	
	@PutMapping(value = "/updateMission/{id}") 
	@ResponseBody
	public void updateMission(@RequestBody Mission miss , @PathVariable("id") int missionId) {
		imissionservice.updateMissionById(missionId, miss);
	}
	
    @DeleteMapping("/deleteMission/{missionId}") 
	@ResponseBody 
	public void deleteMission(@PathVariable("missionId")int missionId) {
    	imissionservice.deleteMissionById(missionId);
	}
    
    @GetMapping(value = "/getMissionById/{missionId}")
    @ResponseBody
    public Mission getMissionById(@PathVariable("missionId")int missionId) {
 		return imissionservice.getMissionById(missionId);
 	}
    
    @GetMapping(value = "/getAllMissions")
    @ResponseBody
    public List<Mission> getAllMissions() {
 		return imissionservice.getAllMissions();
 	}
    
    @GetMapping(value = "/getAllMissionByDepartment/{depId}")
    @ResponseBody
    public List<Mission> getAllMissionByDepartment(@PathVariable("depId")int depId) {
 		return imissionservice.getAllMissionByDepartment(depId);
 	}
    
    @GetMapping(value = "/getAllMissionsByEmailFact/{email}")
    @ResponseBody
    public List<Mission> getAllMissionsByEmailFact(@PathVariable("email")String email) {
 		return imissionservice.getAllMissionsByEmailFact(email);
 	}
    
    @GetMapping(value = "/getSumofAverageDayRateJPQL")
    @ResponseBody
    public int getSumofAverageDayRateJPQL() {
 		return imissionservice.getSumofAverageDayRateJPQL();
 	}
    
    @PutMapping(value = "/assignDepartmentToMission/{dep}/{miss}")
    public void assignDepartmentToMission(@PathVariable("dep")int dep,@PathVariable("miss")int miss) {
 		imissionservice.assignDepartmentToMission(dep,miss);
 	}
    
    @PutMapping(value = "/assignMissionToTimeSheet/{miss}")
    public void assignMissionToTimeSheet(@PathVariable("miss")int miss) {
 		imissionservice.assignMissionToTimeSheet(miss);
 	}
    

}
