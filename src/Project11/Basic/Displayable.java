package Project11.Basic;

// Anything that can be displayed must have a location and a current velocity.
// It's also expected to have a toString suitable for display
public interface Displayable {
   public Vector getLoc();
   public Vector getVlc();
}