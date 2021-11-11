package tn.esprit.spring.services;

import java.util.List;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Mission;

public interface IMissionService {
	
	public int addMission(Mission Mission);
	public void deleteMissionById(int MissionId);
	public void updateMissionById(int MissionId, Mission miss);
	public List<Mission> getAllMissions();
	public Mission getMissionById(int MissionId);
	public List<Mission> getAllMissionByDepartment(int department);
	public void assignDepartmentToMission(int department,int MissionId);
	public void assignMissionToTimeSheet(int mission);
	public List<Mission> getAllMissionsByEmailFact(String email);
	public int getSumofAverageDayRateJPQL();
}
