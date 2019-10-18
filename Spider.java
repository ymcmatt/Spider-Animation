/**
 * Arm object
 * 
 * @author Jeffrey Finkelstein <jeffrey.finkelstein@gmail.com>
 * @author Zezhou Sun <micou@bu.edu>
 * @since Spring 2011
 */

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.jogamp.opengl.util.gl2.GLUT;

public class Spider extends Component implements Animate, Selection{
	/** The OpenGL utility toolkit object. */
	private final GLUT glut = new GLUT();
	
	
	/** The upper arm to be modeled. */
	private final Component head;
	/** The hand to be modeled. */
	private final Component body;
	/** The forearm to be modeled. */
	//rivate final Component forearm;
	/** The fingers on the hand to be modeled. */
	private final Legs[] legs;
	/** The set of all components. */
	private final List<Component> components;
	/** The set of components which are currently selected for rotation. */
	private final Set<Component> selectedComponents = new HashSet<Component>(18);
	
	/** The color for components which are selected for rotation. */
	public static final FloatColor ACTIVE_COLOR = FloatColor.RED;
  	/** The color for components which are not selected for rotation. */
	public static final FloatColor INACTIVE_COLOR = FloatColor.ORANGE;
	
	
	/** The radius of the components which comprise the arm. */
	
	public static final double HEAD_SIZE = 0.2;
	
	public static final double BODY_SIZE = 0.48;
	/** The height of the distal joint on each of the fingers. */
	public static final double OUT_JOINT_HEIGHT = 0.25;
	/** The radius of each joint which comprises the finger. */
	public static final double LEG_RADIUS = 0.03;
	/** The height of the forearm. */
	public static final double FOREARM_HEIGHT = 1.5;

	/** The height of the middle joint on each of the fingers. */
	public static final double MIDDLE_JOINT_HEIGHT = 0.2;
	/** The height of the palm joint on each of the fingers. */
	public static final double IN_JOINT_HEIGHT = 0.2;
	/** The height of the upper arm. */

	
	
	public static final String LEFT_LEG_1_JOINT_1 = "LegLeft11";
	public static final String LEFT_LEG_1_JOINT_2 = "LegLeft12";
  	public static final String LEFT_LEG_1_JOINT_3 = "LegLeft13";
	public static final String LEFT_LEG_2_JOINT_1 = "LegLeft21";
	public static final String LEFT_LEG_2_JOINT_2 = "LegLeft22";
	public static final String LEFT_LEG_2_JOINT_3 = "LegLeft23";
  	public static final String LEFT_LEG_3_JOINT_1 = "LegLeft31";
	public static final String LEFT_LEG_3_JOINT_2 = "LegLeft32";
	public static final String LEFT_LEG_3_JOINT_3 = "LegLeft33";
  	public static final String RIGHT_LEG_1_JOINT_1 = "LegRight11";
	public static final String RIGHT_LEG_1_JOINT_2 = "LegRight12";
	public static final String RIGHT_LEG_1_JOINT_3 = "LegRight13";
  	public static final String RIGHT_LEG_2_JOINT_1 = "LegRight21";
  	public static final String RIGHT_LEG_2_JOINT_2 = "LegRight22";
  	public static final String RIGHT_LEG_2_JOINT_3 = "LegRight23";
  	public static final String RIGHT_LEG_3_JOINT_1 = "LegRight31";
  	public static final String RIGHT_LEG_3_JOINT_2 = "LegRight32";
  	public static final String RIGHT_LEG_3_JOINT_3 = "LegRight33";
  	public static final String BODY_NAME = "body";
  	public static final String HEAD_NAME = "head";
	
  	private Component mapNum2Component(int componentNum) {
  		switch(componentNum) {
  			case  0: return this.head;
			case  1: return this.body;
			case  2: return this.legs[0].insideJoint();
			case  3: return this.legs[0].middleJoint();
			case  4: return this.legs[0].outJoint();
			case  5: return this.legs[1].insideJoint();
			case  6: return this.legs[1].middleJoint();
			case  7: return this.legs[1].outJoint();
			case  8: return this.legs[2].insideJoint();
			case 9: return this.legs[2].middleJoint();
			case 10: return this.legs[2].outJoint();
			case 11: return this.legs[3].insideJoint();
			case 12: return this.legs[3].middleJoint();
			case 13: return this.legs[3].outJoint();
			case 14: return this.legs[4].insideJoint();
			case 15: return this.legs[4].middleJoint();
			case 16: return this.legs[4].outJoint();
			case 17: return this.legs[5].insideJoint();
			case 18: return this.legs[5].middleJoint();
			case 19: return this.legs[5].outJoint();
			default: throw new IllegalArgumentException("componentNum over index"); 
  		}
  	}
  	
  	private Component mapName2Component(String componentName) {
  		switch(componentName) {
	  		case  HEAD_NAME: return this.head;
			case  BODY_NAME: return this.body;
			case  RIGHT_LEG_3_JOINT_1: return this.legs[5].insideJoint();
			case  RIGHT_LEG_3_JOINT_2: return this.legs[5].middleJoint();
			case  RIGHT_LEG_3_JOINT_3: return this.legs[5].outJoint();
			case  RIGHT_LEG_2_JOINT_1: return this.legs[4].insideJoint();
			case  RIGHT_LEG_2_JOINT_2: return this.legs[4].middleJoint();
			case  RIGHT_LEG_2_JOINT_3: return this.legs[4].outJoint();
			case  RIGHT_LEG_1_JOINT_1: return this.legs[3].insideJoint();
			case  RIGHT_LEG_1_JOINT_2: return this.legs[3].middleJoint();
			case  RIGHT_LEG_1_JOINT_3: return this.legs[3].outJoint();
			case  LEFT_LEG_3_JOINT_1: return this.legs[2].insideJoint();
			case  LEFT_LEG_3_JOINT_2: return this.legs[2].middleJoint();
			case  LEFT_LEG_3_JOINT_3: return this.legs[2].outJoint();
			case  LEFT_LEG_2_JOINT_1: return this.legs[1].insideJoint();
			case  LEFT_LEG_2_JOINT_2: return this.legs[1].middleJoint();
			case  LEFT_LEG_2_JOINT_3: return this.legs[1].outJoint();
			case  LEFT_LEG_1_JOINT_1: return this.legs[0].insideJoint();
			case  LEFT_LEG_1_JOINT_2: return this.legs[0].middleJoint();
			case  LEFT_LEG_1_JOINT_3: return this.legs[0].outJoint();
			default: throw new IllegalArgumentException("componentName doesn't exist");
  		}
  	}
  	
  	public void setModelStates(final ArrayList<Configuration> config_list) {
  		for (int i = 0; i < config_list.size(); i++) {
  			if ( 0 <= i && i <= 17) {
  				mapNum2Component(i).setAngles(config_list.get(i));
  			}
  		}
  	}
  	
  	public void setModelStates(final Map<String, Configuration> state) {
  		for (Map.Entry<String, Configuration> entry: state.entrySet()) {
  			this.mapName2Component(entry.getKey()).setAngles(entry.getValue());
  		}
  	}
  	
  	/**
     * Prints the joints on the specified PrintStream.
     * 
     * @param printStream
     *          The stream on which to print each of the components.
     */
    public void printJoints(final PrintStream printStream) {
      for (final Component component : this.components) {
        printStream.println(component);
      }
    }

  	
  	public void toggleSelection(int selectionNum) {
  		if ( 0 <= selectionNum && selectionNum <= 17) {
  			Component component = mapNum2Component(selectionNum);
  			if ( this.selectedComponents.contains(component) ) {
  				this.selectedComponents.remove(component);
  				component.setColor(INACTIVE_COLOR);
  			}
  			else {
  		      this.selectedComponents.add(component);
  		      component.setColor(ACTIVE_COLOR);
  		    }
		}
  	}
  	
  	public void changeSelected(Configuration config) {
  		for(Component c: this.selectedComponents) {
  			c.changeConfiguration(config);
  		}
  	}
  	
	public Spider(final Point3D position, final String name) {
		// Arm object itself as a top level component, need initialization
		super(position, name);
		
		// all the distal joints
	    final Component out1 = new Component(new Point3D(0, 0,
	        MIDDLE_JOINT_HEIGHT), new RoundedCylinder(LEG_RADIUS,
	        OUT_JOINT_HEIGHT, this.glut), LEFT_LEG_1_JOINT_3);
	    final Component out2 = new Component(new Point3D(0, 0,
	        MIDDLE_JOINT_HEIGHT), new RoundedCylinder(LEG_RADIUS,
	        OUT_JOINT_HEIGHT, this.glut), LEFT_LEG_2_JOINT_3);
	    final Component out3 = new Component(new Point3D(0, 0,
	        MIDDLE_JOINT_HEIGHT), new RoundedCylinder(LEG_RADIUS,
	        OUT_JOINT_HEIGHT, this.glut), LEFT_LEG_3_JOINT_3);
	    final Component out4 = new Component(new Point3D(0, 0,
	        MIDDLE_JOINT_HEIGHT), new RoundedCylinder(LEG_RADIUS,
	        OUT_JOINT_HEIGHT, this.glut), RIGHT_LEG_1_JOINT_3);
	    final Component out5 = new Component(new Point3D(0, 0,
	        MIDDLE_JOINT_HEIGHT), new RoundedCylinder(LEG_RADIUS,
	        OUT_JOINT_HEIGHT, this.glut), RIGHT_LEG_2_JOINT_3);
	    final Component out6 = new Component(new Point3D(0, 0,
		        MIDDLE_JOINT_HEIGHT), new RoundedCylinder(LEG_RADIUS,
		        OUT_JOINT_HEIGHT, this.glut), RIGHT_LEG_2_JOINT_3);

	    // all the middle joints
	    final Component middle1 = new Component(new Point3D(0, 0,
	        IN_JOINT_HEIGHT), new RoundedCylinder(LEG_RADIUS,
	        MIDDLE_JOINT_HEIGHT, this.glut), LEFT_LEG_1_JOINT_2);
	    final Component middle2 = new Component(new Point3D(0, 0,
	        IN_JOINT_HEIGHT), new RoundedCylinder(LEG_RADIUS,
	        MIDDLE_JOINT_HEIGHT, this.glut), LEFT_LEG_2_JOINT_2);
	    final Component middle3 = new Component(new Point3D(0, 0,
	        IN_JOINT_HEIGHT), new RoundedCylinder(LEG_RADIUS,
	        MIDDLE_JOINT_HEIGHT, this.glut), LEFT_LEG_3_JOINT_2);
	    final Component middle4 = new Component(new Point3D(0, 0,
	        IN_JOINT_HEIGHT), new RoundedCylinder(LEG_RADIUS,
	        MIDDLE_JOINT_HEIGHT, this.glut), RIGHT_LEG_1_JOINT_2);
	    final Component middle5 = new Component(new Point3D(0, 0,
	        IN_JOINT_HEIGHT), new RoundedCylinder(LEG_RADIUS,
	        MIDDLE_JOINT_HEIGHT, this.glut), RIGHT_LEG_2_JOINT_2);
	    final Component middle6 = new Component(new Point3D(0, 0,
		        IN_JOINT_HEIGHT), new RoundedCylinder(LEG_RADIUS,
		        MIDDLE_JOINT_HEIGHT, this.glut), RIGHT_LEG_2_JOINT_2);

	    // all the palm joints, displaced by various amounts from the palm
	    final Component in1 = new Component(new Point3D(-0.35, 0, 0.3),
	        new RoundedCylinder(LEG_RADIUS, IN_JOINT_HEIGHT, this.glut),
	        LEFT_LEG_1_JOINT_1);
	    final Component in2 = new Component(new Point3D(-0.43, 0, 0.05),
	        new RoundedCylinder(LEG_RADIUS, IN_JOINT_HEIGHT, this.glut),
	        LEFT_LEG_2_JOINT_1);
	    final Component in3 = new Component(new Point3D(-0.35, 0, -0.1),
	        new RoundedCylinder(LEG_RADIUS, IN_JOINT_HEIGHT, this.glut),
	        LEFT_LEG_3_JOINT_1);
	    final Component in4 = new Component(new Point3D(0.35, 0, 0.3),
	        new RoundedCylinder(LEG_RADIUS, IN_JOINT_HEIGHT, this.glut),
	        RIGHT_LEG_1_JOINT_1);
	    final Component in5 = new Component(new Point3D(0.43, 0, 0.05),
	        new RoundedCylinder(LEG_RADIUS, IN_JOINT_HEIGHT, this.glut),
	        RIGHT_LEG_2_JOINT_1);
	    final Component in6 = new Component(new Point3D(0.35, 0, -0.1),
		        new RoundedCylinder(LEG_RADIUS, IN_JOINT_HEIGHT, this.glut),
		        RIGHT_LEG_2_JOINT_1);

	    // put together the fingers for easier selection by keyboard input later on
	    this.legs = new Legs[] { new Legs(in1, middle1, out1),
	        new Legs(in2, middle2, out2),
	        new Legs(in3, middle3, out3),
	        new Legs(in4, middle4, out4),
	        new Legs(in5, middle5, out5),
	        new Legs(in6, middle6, out6),};

	    // the hand, which models the wrist joint
	    this.body = new Component(new Point3D(0, 0, BODY_SIZE), new Ellipsoid(
	        BODY_SIZE, this.glut), BODY_NAME);

	    // the forearm, which models the elbow joint


	    // the upper arm which models the shoulder joint
	    this.head = new Component(new Point3D(0, 0, HEAD_SIZE), new Ellipsoid(
	        HEAD_SIZE, this.glut), HEAD_NAME);
	    this.addChild(head);
	    this.head.addChild(this.body);

	    this.body.addChildren(in1, in2, in3, in4, in5,in6);
	    in1.addChild(middle1);
	    in2.addChild(middle2);
	    in3.addChild(middle3);
	    in4.addChild(middle4);
	    in5.addChild(middle5);
	    in6.addChild(middle6);
	    middle1.addChild(out1);
	    middle2.addChild(out2);
	    middle3.addChild(out3);
	    middle4.addChild(out4);
	    middle5.addChild(out5);
	    middle6.addChild(out6);
	    
	    // turn the whole arm to be at an arm-like angle
	    
	    in1.rotate(Axis.X, 95);
	    in2.rotate(Axis.X, 95);
	    in3.rotate(Axis.X, 95);
	    in4.rotate(Axis.X, 95);
	    in5.rotate(Axis.X, 95);
	    in6.rotate(Axis.X, 95);
	    
	    in1.rotate(Axis.Y, -80);
	    in2.rotate(Axis.Y, -60);
	    in3.rotate(Axis.Y, -40);
	    in4.rotate(Axis.Y, 80);
	    in5.rotate(Axis.Y, 60);
	    in6.rotate(Axis.Y, 40);
	    
//	    middle1.rotate(Axis.X, 95);
//	    middle2.rotate(Axis.X, 95);
//	    middle3.rotate(Axis.X, 95);
//	    middle4.rotate(Axis.X, 95);
//	    middle5.rotate(Axis.X, 95);
//	    middle6.rotate(Axis.X, 95);
	    
	    middle1.rotate(Axis.Y, 25);
	    middle2.rotate(Axis.Y, 25);
	    middle3.rotate(Axis.Y, 20);
	    middle4.rotate(Axis.Y, -25);
	    middle5.rotate(Axis.Y, -25);
	    middle6.rotate(Axis.Y, -20);
	    
//	    out1.rotate(Axis.X, 90);
//	    out2.rotate(Axis.X, 90);
//	    out3.rotate(Axis.X, 90);
//	    out4.rotate(Axis.X, 90);
//	    out5.rotate(Axis.X, 90);
//	    out6.rotate(Axis.X, 90);
	    
	    out1.rotate(Axis.Y, 25);
	    out2.rotate(Axis.Y, 25);
	    out3.rotate(Axis.Y, 25);
	    out4.rotate(Axis.Y, -25);
	    out5.rotate(Axis.Y, -25);
	    out6.rotate(Axis.Y, -25);
	    


	    for (final Component palmJoint : Arrays.asList(in1, in2, in3, in4, in5, in6)) {
	      palmJoint.setXPositiveExtent(105);
	      palmJoint.setXNegativeExtent(85);
	      palmJoint.setYPositiveExtent(95);
	      palmJoint.setYNegativeExtent(-95);
	      palmJoint.setZPositiveExtent(30);
	      palmJoint.setZNegativeExtent(0);
	    }

	    // and set the rotation limits for the palm joint of the thumb
//	    in5.setXPositiveExtent(10);
//	    in5.setXNegativeExtent(10);
//	    in5.setYPositiveExtent(12);
//	    in5.setYNegativeExtent(18);
//	    in5.setZPositiveExtent(10);
//	    in5.setZNegativeExtent(10);

	    // set rotation limits for the middle joints of the finger
	    for (final Component middleJoint : Arrays.asList(middle1, middle2,
	        middle3, middle4, middle5, middle6)) {
	      middleJoint.setXPositiveExtent(30);
	      middleJoint.setXNegativeExtent(-20);
	      middleJoint.setYPositiveExtent(30);
	      middleJoint.setYNegativeExtent(-20);
	      middleJoint.setZPositiveExtent(0);
	      middleJoint.setZNegativeExtent(0);
	    }

	    // set rotation limits for the distal joints of the finger
	    for (final Component distalJoint : Arrays.asList(out1, out2,
	        out3, out4, out5, out6)) {
	      distalJoint.setXPositiveExtent(30);
	      distalJoint.setXNegativeExtent(-30);
	      distalJoint.setYPositiveExtent(30);
	      distalJoint.setYNegativeExtent(-30);
	      distalJoint.setZPositiveExtent(0);
	      distalJoint.setZNegativeExtent(0);
	    }

	    // create the list of all the components for debugging purposes
	    this.components = Arrays.asList(in1, middle1, out1, in2, middle2,
	        out2, in3, middle3, out3, in4, middle4, out4, in5,
	        middle5, out5, in6, middle6, out6, this.body, this.head);
	}
	
	private class Legs {
	    /** The distal joint of this finger. */
	    private final Component outJoint;
	    /** The list of all the joints in this finger. */
	    private final List<Component> joints;
	    /** The middle joint of this finger. */
	    private final Component middleJoint;
	    /** The palm joint of this finger. */
	    private final Component inJoint;

	    /**
	     * Instantiates this finger with the three specified joints.
	     * 
	     * @param palmJoint
	     *          The palm joint of this finger.
	     * @param middleJoint
	     *          The middle joint of this finger.
	     * @param distalJoint
	     *          The distal joint of this finger.
	     */
	    public Legs(final Component inJoint, final Component middleJoint,
	        final Component outJoint) {
	      this.inJoint = inJoint;
	      this.middleJoint = middleJoint;
	      this.outJoint = outJoint;

	      this.joints = Collections.unmodifiableList(Arrays.asList(this.inJoint,
	          this.middleJoint, this.outJoint));
	    }

	    /**
	     * Gets the distal joint of this finger.
	     * 
	     * @return The distal joint of this finger.
	     */
	    Component outJoint() {
	      return this.outJoint;
	    }

	    /**
	     * Gets an unmodifiable view of the list of the joints of this finger.
	     * 
	     * @return An unmodifiable view of the list of the joints of this finger.
	     */
	    List<Component> joints() {
	      return this.joints;
	    }

	    /**
	     * Gets the middle joint of this finger.
	     * 
	     * @return The middle joint of this finger.
	     */
	    Component middleJoint() {
	      return this.middleJoint;
	    }

	    /**
	     * Gets the palm joint of this finger.
	     * 
	     * @return The palm joint of this finger.
	     */
	    Component insideJoint() {
	      return this.inJoint;
	    }
	}


}

