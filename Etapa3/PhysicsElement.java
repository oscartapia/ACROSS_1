public abstract class PhysicsElement {
   private final int myId; /* to identify each element within its category */
   
   protected PhysicsElement(int id){
      myId = id;
   }
   protected int getId() {
      return myId;
   }
   public abstract String getDescription();
   public abstract String getState();

   // Aggregated to posterior implementation
   public abstract void updateState();  								   //Necessary for MyWorld.java
   public abstract void computeNextState(double deta_t, MyWorld world);    //Necessary for MyWorld.java
}
