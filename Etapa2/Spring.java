public class Spring extends PhysicsElement {
   private static int id=0;  // Spring identification
   protected final double restLength;
   private final double stiffness;
   protected Ball a_end, b_end;

   private Spring(){   // nobody can create a block without state
      this(0,0);
   }
   public Spring(double restLength, double stiffness){
      super(id++);
      this.restLength = restLength;
      this.stiffness = stiffness;
      a_end = b_end = null;
   }
   public void attachEnd (Ball sa) {  // note: we attach a spring to a ball, 
      if(a_end==null){                             //       not the other way around.
         a_end = sa; 
		 sa.attachSpring(this);	
		}		 
      else if(b_end==null){
		b_end = sa;
		sa.attachSpring(this);
		}    
   }
   private double getAendPosition() {
      if (a_end != null)
         return a_end.getPos();
      if (b_end != null)
         return b_end.getPos()-restLength;
      return 0;
   }
   public double getBendPosition() {
      if (b_end != null)
         return b_end.getPos();
      if (a_end != null)
         return a_end.getPos()-restLength;
      return 0;
   }
   public double getForce(Ball ball) {
      double delta_x= 0;
      double force = 0;
      if ((a_end == null) || (b_end == null))
         return force;
      if ((ball != a_end) && (ball != b_end))
         return force;
      //agregado
      delta_x=getBendPosition()-getAendPosition()-restLength;
      force=(-1)*delta_x*stiffness;
      if(ball==a_end) return (-1)*force; //force ball a
      return force; //force ball b
   }

   public void computeNextState(double delta_t, MyWorld w){} 
   public void updateState(){}

   public String getDescription() {
      return "Spring_"+ getId()+":a_end\tb_end";
   }

   public String getState() {
	String a = String.valueOf(a_end.getPos())+"\t"+String.valueOf(b_end.getPos()); // Convert format double to String
    return a; 
   }
}
