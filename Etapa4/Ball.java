import java.util.*;

public class Ball extends PhysicsElement implements SpringAttachable{
   private static int id=0;  // Ball identification number
   private final double mass;
   private final double radius;
   private double pos_t;     // current position at time t
   private double pos_tPlusDelta;  // next position in delta time in future
   private double speed_t;   // speed at time t
   private double speed_tPlusDelta;   // speed in delta time in future
   private double a_t;    // acceleration at time t
   private double a_tMinusDelta;  // acceleration delta time ago;
   private ArrayList<Spring> springs;  // ArrayList can grow, arrays cannot.
   private Ball(){   // nobody can create a block without state
     this(1.0,0.1,0,0);
   }
   public Ball(double mass, double radius, double position, double speed){
      super(++id);
      this.mass = mass;
      pos_t = position;
      speed_t = speed;
      this.radius=radius;
      springs = new ArrayList<Spring>(); 
   }
   

   public double getRadius() {
      return radius;
   }
   public double getSpeed() {
      return speed_t;
   }
   public double getPos() {
      return pos_t;
   }
   public double getMass() {
      return mass;
   }
   private double getNetForce() {
      double force=0;
      for (Spring s:springs) //Roam Springs attacched to the ball
	  force+=s.getForce(this);
      return force;
   }
   
   public void attachSpring(Spring s){
   springs.add(s);
   }
     
  
   public void computeNextState(double delta_t, MyWorld world) {
     Ball b;  // Assumption: on collision we only change speed. 
	 a_t= getNetForce()/mass;
     if ((b=world.findCollidingBall(this))!= null){ /* elastic collision */
        speed_tPlusDelta=((mass-b.getMass())*speed_t+2*b.getMass()*b.getSpeed())/(mass+b.getMass()); 
        pos_tPlusDelta = pos_t+speed_tPlusDelta*delta_t;
		
     } else {
        speed_tPlusDelta = speed_t+(a_t)*delta_t;
        pos_tPlusDelta = pos_t + (speed_tPlusDelta)*delta_t;
     }
   }
   public boolean collide(Ball b) { // Compare two balls and verify if it will crash
  	 if(Math.abs(pos_t - b.getPos())>(radius+b.getRadius())) // Compare the diference between positions and radiuses
      		 return false;                                // False if not collide
   	 else return true;
   }
   
   public void updateState(){
     pos_t = pos_tPlusDelta;
     speed_t = speed_tPlusDelta;
     a_tMinusDelta = a_t;
   }
   
   public String getDescription(){ 
	return "Ball_" + getId();
   }
   
   public String getState(){ //Return the position in string format
      String a = String.valueOf(pos_t); // Convert format double to String
    return a;   
   }
}
