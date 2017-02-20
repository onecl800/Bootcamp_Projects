
public class Main {
	
	public static void main(String [] args) {
        
		//create buses and coaches
        Bus bus301 = new Bus("301");
        Bus bus506 = new Bus("506");
  
        Coach coach49 = new Coach("49");
        Coach coach56 = new Coach("56");


        //create passengers and drivers
        Passenger a = new Passenger("Ashley", "ticket");
        Passenger b = new Passenger("Benjamin", "ticket");
        Passenger c = new Passenger("Clarence", "ticket");
        Passenger d = new Passenger("Daniel", "ticket");
        Passenger e = new Passenger("Eve", "ticket");
        Passenger f = new Passenger("Freddy", "ticket");
        Passenger g = new Passenger("George", "ticket");
        Passenger h = new Passenger("Henrietta", "ticket");
        Passenger i = new Passenger("Israel", "ticket");
        Passenger j = new Passenger("James", "ticket");
        Passenger k = new Passenger("Kathleen", "ticket");
        Passenger l = new Passenger("Logan", "ticket");
        Passenger m = new Passenger("Megan", "ticket");
        Passenger o = new Passenger("Ashley", "ticket");
        Passenger p = new Passenger("Benjamin", "ticket");
        Passenger q = new Passenger("Clarence", "ticket");
        Passenger r = new Passenger("Daniel", "ticket");
        Passenger s = new Passenger("Eve", "ticket");
        Passenger t = new Passenger("Freddy", "ticket");
        Passenger u = new Passenger("George", "ticket");
        Passenger v = new Passenger("George", "ticket");
        Passenger w = new Passenger("Henrietta", "ticket");
        Passenger x = new Passenger("Israel", "ticket");
        Passenger y = new Passenger("James", "ticket");
        Passenger aa = new Passenger("Kathleen", "ticket");
        Passenger ab = new Passenger("Logan", "ticket");
        Passenger ac = new Passenger("Megan", "ticket");
        Driver z = new Driver("Driver", "License");
        Driver zz = new Driver("Driver", "License");
        Driver zzz = new Driver("Driver", "License");
        
 
        //add people to buses and coaches
        bus301.getOnBus(a);
        bus301.getOnBus(b);
        bus301.getOnBus(c);
        bus301.getOnBus(d);
        bus301.getOnBus(k);
        bus301.getOnBus(l);
        bus506.getOnBus(e);
        bus506.getOnBus(f);
        bus506.getOnBus(g);
        bus506.getOnBus(h);
        bus506.getOnBus(i);
        bus506.getOnBus(j);
        bus506.getOnBus(m);
        bus506.getOnBus(zzz);
        
        coach49.getOnCoach(o);
        coach49.getOnCoach(p);
        coach49.getOnCoach(q);
        coach49.getOnCoach(r);
        coach49.getOnCoach(x);
        coach49.getOnCoach(y);
        coach49.getOnCoach(z);
        coach49.getOnCoach(aa);
        coach56.getOnCoach(s);
        coach56.getOnCoach(t);
        coach56.getOnCoach(u);
        coach56.getOnCoach(v);
        coach56.getOnCoach(w);
        coach56.getOnCoach(ab); 
        coach56.getOnCoach(ac);
        coach56.getOnCoach(zz);
        
             
        System.out.println(bus301.toString());
        System.out.println(bus506.toString());
        System.out.println(coach49.toString());
        System.out.println(coach56.toString());
        System.out.println();

        
        //check if buses and coaches can move
        coach49.canMove();
        coach56.canMove();

        bus301.canMove();
        bus506.canMove();
        System.out.println();
        
        
        //print balances of passengers on each bus
        for (int ii = 0; ii < bus301.getPeopleOnBus().size(); ii++) {
        	if (bus301.getPeopleOnBus().get(ii) instanceof Driver) {
        		continue;
        	} else {
        		Passenger pass = (Passenger)bus301.getPeopleOnBus().get(ii);
        		System.out.println(pass.getName() + " " + pass.getSnapper().getBalance());
        	}
        }
        System.out.println();
        
        for (int ij = 0; ij < bus506.getPeopleOnBus().size(); ij++) {
        	if (bus506.getPeopleOnBus().get(ij) instanceof Driver) {
        		continue;
        	} else {
        		Passenger pass = (Passenger)bus506.getPeopleOnBus().get(ij);
        		System.out.println(pass.getName() + " " + pass.getSnapper().getBalance());
        	}
        }
        System.out.println();
        
        for (int ik = 0; ik < coach49.getPeopleOnCoach().size(); ik++) {
        	if (coach49.getPeopleOnCoach().get(ik) instanceof Driver) {
        		continue;
        	} else {
        		Passenger pass = (Passenger)coach49.getPeopleOnCoach().get(ik);
        		System.out.println(pass.getName() + " " + pass.getSnapper().getBalance());
        	}
        }
        System.out.println();
        
        for (int il = 0; il < coach56.getPeopleOnCoach().size(); il++) {
        	if (coach56.getPeopleOnCoach().get(il) instanceof Driver) {
        		continue;
        	} else {
        		Passenger pass = (Passenger)coach56.getPeopleOnCoach().get(il);
        		System.out.println(pass.getName() + " " + pass.getSnapper().getBalance());
        	}
        }
        System.out.println();

	}
}
