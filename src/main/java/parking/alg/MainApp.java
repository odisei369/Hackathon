
import java.util.Scanner;


class FIFO{
    private int currentRoute = 0;
    private Vehicle[] vehicles;
    private Gate[] gates;
    private Route[] routes;
    public FIFO(Route[] routes, Gate[] gates, Vehicle[] vehicles){
        this.routes = routes;
        this.gates = gates;
        this.vehicles = vehicles;
    }

    private boolean tryLoadTruck(int vehicleId, int timestamp){
        for(int gateId = 0; gateId < gates.length; gateId++){
            if(gates[gateId].busyUntil <= timestamp){
                gates[gateId].busyUntil = timestamp + vehicles[vehicleId].numberOfPallet * 1;
                Route route = routes[currentRoute++];
                vehicles[vehicleId].route = route;
                vehicles[vehicleId].status = "loading";
                vehicles[vehicleId].currentTakenGate = gates[gateId];
                System.out.println("vehicle " + vehicleId + " loading");
                route.start = timestamp + vehicles[vehicleId].numberOfPallet;
                route.completionTime = route.bursts + route.start;
                return true;
            }
        }
        return false;
    }

    private boolean tryUnload(int vehicleId, int timestamp){
        for(int gateId = 0; gateId < gates.length; gateId++){
            if(gates[gateId].busyUntil <= timestamp){
                gates[gateId].busyUntil = timestamp + vehicles[vehicleId].numberOfPallet * 1;
                vehicles[vehicleId].route = null;
                vehicles[vehicleId].status = "unloading";
                vehicles[vehicleId].currentTakenGate = gates[gateId];
                System.out.println("vehicle " + vehicleId + " unloading");
                return true;
            }
        }
        System.out.println("vehicle " + vehicleId + " waiting for unload");
        return false;
    }
    private void isUnloadEnded(int vehicleId, int timestamp){
        if(vehicles[vehicleId].currentTakenGate.busyUntil <= timestamp){
            vehicles[vehicleId].currentTakenGate = null;
            if(!tryLoadTruck(vehicleId, timestamp)){
                vehicles[vehicleId].status = "doing nothing";
            }
        }
    }

    public void simulate(){
        //routes are sorted from bigger one
        int timestamp = 0;
        while(timestamp != 480){
            for(int vehicleId=0; vehicleId<vehicles.length; vehicleId++){
                if(vehicles[vehicleId].route == null && vehicles[vehicleId].status == "doing nothing"){
                    tryLoadTruck(vehicleId, timestamp);
                } else if(vehicles[vehicleId].status == "unloading"){
                    isUnloadEnded(vehicleId, timestamp);
                } else if(vehicles[vehicleId].status == "waiting for unload"){
                    tryUnload(vehicleId, timestamp);
                } else if(vehicles[vehicleId].route.start == timestamp){
                    vehicles[vehicleId].currentTakenGate = null;
                    vehicles[vehicleId].status = "on route";
                    System.out.println("vehicle " + vehicleId + " on route");
                } else if(vehicles[vehicleId].route.completionTime <= timestamp){
                    vehicles[vehicleId].status = "waiting for unload";
                    tryUnload(vehicleId, timestamp);
                }
                }
            if(currentRoute == routes.length){
                break;
            }
            timestamp++;
        }
    }


}

class Vehicle{
    int id;
    int numberOfPallet = 10;
    Route route;
    String status = "doing nothing";
    Gate currentTakenGate;
    Vehicle(int id){
        this.id = id;
    }
}

class Route{
    int id;
    int start;
    int bursts;
	int completionTime;
    Route(int id, int bur){
        this.id = id;
        bursts = bur;
    }
}

class Gate{
    int id;
    int busyUntil = 0;
    Gate(int id){
        this.id = id;
    }

}
public class MainApp {

    public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the number of routes:");
		int n = s.nextInt();

        Route[] myRoutes = new Route[n];
		for(int i=0;i<n;i++){
			System.out.println("Enter time for route " + i +": ");
			int bur = s.nextInt();
			myRoutes[i] = new Route(i,bur);
		}

        System.out.println("Enter the number of gates:");
        int numOfGates = s.nextInt();
        Gate[] myGates = new Gate[numOfGates];
        for(int i=0;i<numOfGates;i++){
			myGates[i] = new Gate(i);
		}

        System.out.println("Enter the number of vehicles:");
        int numOfVehicles = s.nextInt();
        Vehicle[] myVehicles = new Vehicle[numOfVehicles];
        for(int i=0;i<numOfVehicles;i++){
			myVehicles[i] = new Vehicle(i);
		}

        FIFO fifo = new FIFO(myRoutes, myGates, myVehicles);
        fifo.simulate();
    }

}