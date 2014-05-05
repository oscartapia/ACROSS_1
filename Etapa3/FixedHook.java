import java.util.*;

public class FixedHook extends PhysicsElement implements SpringAttachable{
   private static int id=0;  // Ball identification number
   double pos_t;
   private ArrayList<Spring> springs;  // ArrayList can grow, arrays cannot.
   
   public FixedHook(double position){
      super(++id);
      pos_t = position;
      springs = new ArrayList<Spring>();
   }

   public void attachSpring(Spring s){
      springs.add(s);
   }
   
   public double getPos(){
      return pos_t;
   }

   public String getDescription(){ 
      return "FixedHook_" + getId();
   }

   public void computeNextState(double delta_t, MyWorld world) {}

   public void updateState(){}

   public String getState(){ //Return the position in string format
      String a=String.valueOf(pos_t); // Convert format double to String
      return a;   
   }
}
